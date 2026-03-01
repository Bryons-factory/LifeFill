# LifeFill Android: Project Roadmap & Contributor Guide

LifeFill is a secure, biometric-locked medical vault for Android that will leverage SQLCipher, SMART on FHIR, and the Android Autofill Framework to help users manage and share their health data securely.

---

## 📋 Current Project Status

| Item | Current state |
|------|----------------|
| **Package** | `com.example.lifefill` (to be updated to `com.lifefill.app`) |
| **Language** | Java 11 |
| **Build** | Gradle (Kotlin DSL), AGP 9.0.1 |
| **Modules** | **app** (Android application), **core** (Java library), **data** (Android library) |
| **UI** | MainActivity + FirstFragment, SecondFragment; Navigation + Material components |
| **Target SDK** | 34 |
| **Min SDK** | 24 |

**Implemented so far**

- **core**: Shared models (`Patient`, `Allergy`, `Insurance`), repository interfaces (`PatientRepository`, `AllergyRepository`, `InsuranceRepository`), and API contract (`EpicFhirClient`).
- **data**: Repository implementations, `EpicFhirClientImpl` (stub), and `LifeFillDataModule` for dependency access.
- **app**: Shell UI (MainActivity, two fragments, nav graph, view binding). No vault, autofill, or auth yet.

---

## 🛠 Project Structure & Ownership

The project is **multi-module**. Use this layout to find the code you own:

```
LifeFill/
├── app/                                    # Android application (UI team)
│   └── src/main/java/com/example/lifefill/
│       ├── MainActivity.java
│       ├── FirstFragment.java
│       └── SecondFragment.java
│
├── core/                                   # Pure Java library (shared)
│   └── src/main/java/com/example/lifefill/core/
│       ├── api/                            # API contracts (e.g. Epic FHIR)
│       │   └── EpicFhirClient.java
│       ├── model/                          # Shared POJOs
│       │   ├── Patient.java
│       │   ├── Allergy.java
│       │   └── Insurance.java
│       └── repository/                     # Repository interfaces
│           ├── PatientRepository.java
│           ├── AllergyRepository.java
│           └── InsuranceRepository.java
│
└── data/                                   # Android library (backend/API team)
    └── src/main/java/com/example/lifefill/data/
        ├── LifeFillDataModule.java         # Entry point for repos & API client
        ├── api/
        │   └── EpicFhirClientImpl.java
        └── repository/
            ├── PatientRepositoryImpl.java
            ├── AllergyRepositoryImpl.java
            └── InsuranceRepositoryImpl.java
```

**Dependency flow**

- `app` → `core`, `app` → `data`
- `data` → `core`

**Not yet in the repo** (planned): `security/`, `database/`, `autofill/`, `auth/`, and full `api/`/`ui/` implementations will live under `app` or `data` as the phases below are implemented.

---

## 🚀 Implementation Phases (Role Reference)

### Phase 1: Security & Database (The Foundation)

**Focus:** Secure data storage and biometric access.

**Key tasks**

- Implement `KeystoreManager` (e.g. in `app` or a new module) for AES key generation.
- Set up SQLCipher in a `LifeFillDatabase` (or equivalent).
- Add DAOs for Patients, Allergies, Medications, Insurance (or align with existing `core` models).
- Gate DB access behind `BiometricPrompt`.

### Phase 2: Autofill Framework (The Utility)

**Focus:** Making vault data usable in other apps.

**Key tasks**

- Declare and configure `LifeFillAutofillService` in the manifest.
- Build `AssistStructureParser` to identify fields (name, DOB, etc.).
- Map FHIR-backed data to `AUTOFILL_HINT_*` constants.
- Add a test form Activity for QA.

### Phase 3: FHIR & API Integration (The Data)

**Focus:** Pulling data from medical providers.

**Key tasks**

- Use AppAuth for Epic/Cerner (and similar) logins.
- Implement Retrofit (or equivalent) for Epic FHIR endpoints; replace or fill in `EpicFhirClientImpl` in **data**.
- Integrate Flexpa Link (e.g. via Chrome Custom Tabs).
- Keep network usage confined to the sync/data layer (e.g. **data** module).

### Phase 4: Material 3 Dashboard (The UI)

**Focus:** Modernizing the user experience.

**Key tasks**

- Refactor current fragments into a proper vault/dashboard (e.g. `VaultDashboardFragment`).
- Move to Material 3 components and theming.
- Use `FLAG_SECURE` where sensitive health data is shown.
- Add CRUD screens for manual entry and edits.

---

## ⚙️ Development Setup

### Build configuration

Current `app/build.gradle.kts` (and sibling modules) use:

- **compileSdk:** 34  
- **minSdk:** 24  
- **targetSdk:** 34  
- **Java:** 11 (source/target compatibility)

Root `build.gradle.kts` only applies the Android application and library plugins; `settings.gradle.kts` includes `:app`, `:core`, and `:data`.

### Current dependencies (in use)

- AndroidX: AppCompat, Material, ConstraintLayout, Navigation (Fragment + UI).
- JUnit and AndroidX test / Espresso for tests.

### Dependencies to add (as phases are implemented)

- `net.zetetic:android-database-sqlcipher` — encrypted DB.
- `androidx.biometric:biometric` — biometric gate.
- `net.openid:appauth` — SMART on FHIR / OAuth.
- `com.squareup.retrofit2:retrofit` (and converters) — FHIR/API calls.

---

## 📝 Contribution Workflow

1. **Claim a component:** Tell the group which phase or file you’re working on.
2. **Branching:** Use a feature branch (e.g. `feature/biometric-auth`).
3. **Security:** Do not log sensitive medical data or PII to Logcat.

---

## 📄 Module details

See **MODULES.md** in the `LifeFill` project directory for:

- How to use `LifeFillDataModule` and repositories from the app.
- How to add new API interfaces in **core** and implementations in **data**.
- How to add new shared models in **core**.
