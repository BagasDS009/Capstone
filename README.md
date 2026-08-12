# Capstone Project - Hospital Management System (QE Automation)

Comprehensive test automation suite for the Hospital Management System (Klinik/Puskesmas), covering **API**, **Web**, and **Mobile** testing.

This project was originally built as a capstone during Studi Independent at Alterra Academy (2022) and has been refactored for improved code quality and maintainability.

## Project Structure

```
Capstone/
├── .github/workflows/
│   ├── api-tests.yml                       # CI pipeline for API tests
│   ├── web-tests.yml                       # CI pipeline for Web tests
│   └── mobile-tests.yml                    # CI pipeline for Mobile tests
│
├── AutomationApiTesting/                   # REST API Automation
│   ├── pom.xml
│   ├── src/test/java/
│   │   ├── CucumberTestSuite.java
│   │   ├── utils/
│   │   │   ├── BaseApi.java               # Common HTTP helpers & assertions
│   │   │   ├── ConfigManager.java         # Reads config.properties
│   │   │   ├── DataGenerator.java         # Random test data factory
│   │   │   ├── TokenManager.java          # In-memory auth token store
│   │   │   └── TestDataStore.java         # In-memory shared test data
│   │   └── starter/
│   │       ├── auth/                       # Login & Register
│   │       ├── dokter/                     # Doctor CRUD
│   │       ├── pasien/                     # Patient CRUD
│   │       ├── jadwal/                     # Schedule CRUD
│   │       ├── user/                       # User CRUD
│   │       └── stepdefinitions/            # Cucumber glue
│   └── src/test/resources/
│       ├── config.properties               # Base URL & credentials
│       ├── Authentication/                 # Feature files
│       ├── DataDokter/
│       ├── DataPasien/
│       ├── KelolaJadwal/
│       └── User/
│
├── AutomationWebsiteTesing/                # Web UI Automation
│   ├── pom.xml
│   ├── serenity.properties                 # WebDriver & base URL config
│   ├── src/test/java/
│   │   ├── CucumberTestSuite.java
│   │   └── starter/
│   │       ├── pages/
│   │       │   ├── LoginPage.java
│   │       │   ├── DashboardPage.java
│   │       │   ├── PatientDataPage.java
│   │       │   ├── DokterDataPage.java
│   │       │   ├── KelolaJadwalPage.java
│   │       │   └── ArsipJadwalPage.java
│   │       └── stepdefinitios/
│   │           ├── LoginSteps.java
│   │           ├── PatientDataSteps.java
│   │           ├── DokterDataSteps.java
│   │           ├── KelolaJadwalSteps.java
│   │           └── ArsipJadwalSteps.java
│   └── src/test/resources/features/       # 20+ feature files
│
├── AutomationMobileTesing/                 # Mobile UI Automation
│   ├── pom.xml
│   ├── src/main/java/com/example/app/
│   │   ├── base/
│   │   │   └── BasePageObject.java        # Common mobile interactions
│   │   ├── drivers/
│   │   │   └── AndroidDriverInit.java     # Appium driver setup
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── DashboardAdminPage.java
│   │   │   ├── DashboardDoctorPage.java
│   │   │   ├── DataDoctorPage.java
│   │   │   ├── DataPatientPage.java
│   │   │   ├── ManageSchedulePage.java
│   │   │   ├── ArchiveSchedulePage.java
│   │   │   └── ReviewDoctorPage.java
│   │   └── utils/
│   │       └── General.java               # Random data generator
│   ├── src/main/resources/
│   │   └── appium.properties              # Appium & device config
│   └── src/test/
│       ├── java/com/example/
│       │   ├── acceptancetests/
│       │   │   └── AcceptanceTestSuite.java
│       │   ├── hooks/
│       │   │   └── AndroidDriverHook.java  # Driver lifecycle
│       │   └── steps/
│       │       ├── Auth/                   # Login/Logout steps
│       │       ├── DoctorData/             # Doctor CRUD steps
│       │       ├── PatientData/            # Patient CRUD steps
│       │       ├── ManageSchedule/         # Schedule steps
│       │       ├── ArchiveSchedule/        # Archive steps
│       │       └── Review/                 # Review steps
│       └── resources/
│           ├── application/app-release.apk
│           └── features/                   # 16 feature files
│
└── README.md                               # This file
```

## Tech Stack

| Layer | Tools |
|-------|-------|
| API Testing | Java 11, REST Assured, Serenity BDD, Cucumber |
| Web Testing | Java 11, Selenium WebDriver, Serenity BDD, Cucumber |
| Mobile Testing | Java 11, Appium, Serenity BDD, Cucumber |
| Build | Maven |
| CI/CD | GitHub Actions |
| Reporting | Serenity BDD Reports |

## CI/CD Pipelines

Three GitHub Actions workflows are configured:

| Workflow | File | Trigger |
|----------|------|---------|
| API Tests | `.github/workflows/api-tests.yml` | Push/PR to `AutomationApiTesting/` |
| Web Tests | `.github/workflows/web-tests.yml` | Push/PR to `AutomationWebsiteTesing/` |
| Mobile Tests | `.github/workflows/mobile-tests.yml` | Push/PR to `AutomationMobileTesing/` |

All workflows can also be triggered manually via the Actions tab (`workflow_dispatch`).

> **Note**: The backend server (Heroku) and web app (Netlify) are no longer active.
> CI pipelines will compile successfully but tests will fail at runtime due to connection timeouts.
> This is expected behavior — the workflows are structured correctly and will pass once a live environment is available.
> To point to a new server, update the config files in each project (see individual README files).

## Quick Start

### Prerequisites
- Java 11+
- Maven 3.x
- Chrome (for web tests)
- Android SDK + Appium (for mobile tests)

### Run API tests
```bash
cd AutomationApiTesting
mvn clean verify
```

### Run Web tests
```bash
cd AutomationWebsiteTesing
mvn clean verify
```

### Run Mobile tests
```bash
# Start Appium server first
appium

# Then run tests
cd AutomationMobileTesing
mvn clean verify
```

## Test Coverage

| Module | API | Web | Mobile |
|--------|-----|-----|--------|
| Login/Auth | ✅ | ✅ | ✅ |
| Logout | - | ✅ | ✅ |
| Doctor CRUD | ✅ | ✅ | ✅ |
| Patient CRUD | ✅ | ✅ | ✅ |
| Schedule | ✅ | ✅ | ✅ |
| Archive | - | ✅ | ✅ |
| Doctor Review | - | - | ✅ |
| User Management | ✅ | - | - |

## Configuration Files

| Project | Config File | Purpose |
|---------|-------------|---------|
| API | `src/test/resources/config.properties` | Base URL, credentials |
| Web | `serenity.properties` | WebDriver, base URL |
| Mobile | `src/main/resources/appium.properties` | Appium URL, device caps |

## Refactoring Highlights

This project has been refactored from its original 2022 state with the following improvements:

- **Externalized configuration** — No more hardcoded URLs, credentials, or file paths
- **Eliminated code duplication** — Helper classes and base objects reduce repetition
- **Proper Java conventions** — Lowercase package names, clean imports
- **In-memory state management** — Replaced file-based token/data sharing (API project)
- **Removed Thread.sleep** — Proper waits via frameworks (Web/Mobile)
- **Fixed broken assertions** — Assertions that previously did nothing now actually verify
- **Cleaned dependencies** — Removed unused/deprecated libraries
- **Added documentation** — README per project + this root README
- **CI/CD ready** — GitHub Actions workflows for all three test suites

## Individual Documentation

Each sub-project has its own detailed README:
- [API Testing README](AutomationApiTesting/README.md)
- [Web Testing README](AutomationWebsiteTesing/README.md)
- [Mobile Testing README](AutomationMobileTesing/README.md)
