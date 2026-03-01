# LifeFill Module Structure

Frontend and backend are separated so teams can work in parallel.

## Modules

| Module | Purpose | Who Works Here |
|--------|---------|----------------|
| **app** | UI: Activities, Fragments, layouts, AutofillService, Material Design | Frontend team |
| **core** | Shared: models (Patient, Allergy, Insurance), repository interfaces | Both (add interfaces here) |
| **data** | Backend: API clients, database, repository implementations | API/backend team |

## Dependency Flow

```
app → core
app → data → core
```

## Using Repositories in the App (Frontend)

```java
import com.example.lifefill.data.LifeFillDataModule;
import com.example.lifefill.core.repository.PatientRepository;

// In your Activity/Fragment/ViewModel:
PatientRepository repo = LifeFillDataModule.getPatientRepository();
Patient patient = repo.getPatient();
```

## Adding New APIs (Backend)

1. Add the interface in **core** (e.g. `core.api.EpicFhirClient`)
2. Implement it in **data** (e.g. `data.api.EpicFhirClientImpl`)
3. Expose via `LifeFillDataModule` in **data**

## Bulk FHIR (Async $export)

- **Core:** `BulkFhirExportClient`, `BulkExportJobStatus` – kick-off, poll status, result file list.
- **Data:** `BulkFhirExportClientImpl`, `BulkExportJobManager`, `NdjsonStreamParser` – orchestration and streaming NDJSON.
- See **`docs/BULK_FHIR_IMPLEMENTATION.md`** for the full implementation strategy (auth, orchestration, ingestion, storage).

## Adding New Models

Add POJOs in **core.model** (e.g. `Patient`, `Allergy`, `Insurance`). Both app and data depend on core.
