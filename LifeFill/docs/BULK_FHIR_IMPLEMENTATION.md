# Bulk FHIR Implementation Strategy

This document captures the executive implementation strategy for **Bulk Data Access** in LifeFill, aligned with the FHIR Bulk Data Export (async) pattern used by Epic and other EHRs.

---

## 1. Architectural Shift: Async Request-Response

Unlike standard FHIR APIs that return data instantly, **Bulk Data Access** follows an **Asynchronous Request-Response Pattern**:

| Phase | Description |
|-------|-------------|
| **Kick-off** | System sends a request to the `$export` endpoint. |
| **Polling** | Epic returns a `Content-Location` header; the system must periodically check status until files are ready. |
| **Retrieval** | Once complete, Epic provides a list of URLs to **NDJSON** (Newline Delimited JSON) files. |

*Think of it as placing an order at a warehouse rather than picking an item off a shelf.*

---

## 2. Four Implementation Pillars

### Pillar 1: Authentication

| Action | Priority |
|--------|----------|
| Implement **SMART Backend Services** using asymmetric cryptography (JWK). | **Security** |
| Store private keys in a **secure Vault**, not in code or config. | **Security** |

**LifeFill mapping:**

- **Android app:** Continue using AppAuth/OAuth for user context; bulk export may be triggered via backend or with a token that has `system/*.read` (see Scopes below).
- **Backend (future):** When a backend service is introduced, implement SMART Backend Services with JWK; private keys must live in a secrets manager (e.g., AWS Secrets Manager, Azure Key Vault, HashiCorp Vault).

---

### Pillar 2: Orchestration

| Action | Priority |
|--------|----------|
| Build a **Job Manager** within LifeFill to handle polling and retry logic. | **Reliability** |
| Bulk exports can take **minutes or hours**; the system must handle timeouts and retries. | **Reliability** |

**LifeFill mapping:**

- **Core:** `BulkFhirExportClient` – contract for kick-off, poll status, and result URLs.
- **Data:** `BulkExportJobManager` – orchestrates: (1) request export, (2) poll `Content-Location` with backoff/retry, (3) on completion, fetch file list and trigger download/ingestion.
- **Android:** Use **WorkManager** or a foreground service for long-running export jobs so they survive process death and respect battery/Doze.

---

### Pillar 3: Ingestion

| Action | Priority |
|--------|----------|
| Create a **parser for NDJSON files** to stream data into the database. | **Performance** |
| **Avoid loading entire files into memory**; use streaming to keep costs low. | **Performance** |

**LifeFill mapping:**

- **Data:** `NdjsonStreamParser` – reads NDJSON line-by-line (streaming), parses each line as JSON, and invokes a callback or `Stream` for each resource. Map FHIR resources to existing `core.model` (e.g., Patient, Allergy) or new FHIR DTOs as needed.

---

### Pillar 4: Storage

| Action | Priority |
|--------|----------|
| Provision a **landing zone** (e.g., S3 or Azure Blob) for raw FHIR files. | **Compliance** |
| Ensure this storage is **HIPAA-compliant** and **encrypted at rest**. | **Compliance** |

**LifeFill mapping:**

- **Backend / cloud:** Use a dedicated bucket/container for Bulk FHIR export files. Enable encryption at rest and access logging; restrict access via IAM/roles. LifeFill backend (when built) should download from Epic’s temporary URLs and immediately persist to this landing zone, then trigger ingestion.
- **Android:** If the app ever holds raw NDJSON temporarily (e.g., after download before upload to backend), store in app-private, encrypted storage (e.g., EncryptedFile) and delete after successful upload/ingestion.

---

## 3. Critical Watch-Outs

### Group Export vs. System Export

- **Start with Group-level export.** This allows pulling data for specific cohorts (e.g., “All patients on Medication X”) rather than the entire hospital database.
- Epic may **restrict** full system export for performance; Group export is the recommended starting point.

### Transient Nature of Data

- Epic hosts generated files for a **short window** (typically **24–48 hours**).
- LifeFill **must** automate download **immediately upon completion**; do not rely on manual steps.

### Scopes

- In the **Epic Vendor Portal**, ensure the App Registration requests **`system/*.read`** (or the specific bulk scopes required).
- Standard **`user/`** or **`patient/`** scopes do **not** suffice for Bulk Data export.

---

## 4. Code Artifacts (LifeFill Repo)

| Component | Location | Purpose |
|-----------|----------|---------|
| `BulkFhirExportClient` | `core/api` | Contract: request export, poll status, get result URLs. |
| `BulkExportJobStatus` | `core/model` or `core/api` | Status enum/model for async job state. |
| `BulkFhirExportClientImpl` | `data/api` | Implementation (Retrofit/OkHttp) for Epic $export and status. |
| `BulkExportJobManager` | `data/bulk` | Orchestration: kick-off, poll with retry, then download/ingest. |
| `NdjsonStreamParser` | `data/bulk` | Streaming NDJSON parser; feed lines to repository or mapper. |
| Data module wiring | `LifeFillDataModule` | Expose `BulkFhirExportClient` and `BulkExportJobManager`. |

---

## 5. Sequence Overview

```
[App/Backend] --> requestExport() --> [Epic $export]
       <-- 202 Accepted, Content-Location
[Job Manager] --> pollStatus(Content-Location) ... (retry/backoff)
       <-- 200 OK + output file list (NDJSON URLs)
[Job Manager] --> download each URL --> Landing zone / local encrypted
[Ingestion]    --> NdjsonStreamParser --> Repositories / DB
```

This document should be updated as backend services (auth vault, landing zone, server-side job runner) are introduced.
