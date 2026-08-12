# Automation API Testing - Klinik Management System

Automated API test suite for the Klinik (Clinic) Management System backend, built with **Cucumber BDD**, **Serenity**, and **REST Assured**.

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Language |
| Maven | 3.x | Build & dependency management |
| Serenity BDD | 2.6.0 | Test framework & reporting |
| Cucumber | 6 (via Serenity) | BDD test scenarios |
| REST Assured | 4.4.0 | HTTP client for API testing |
| JUnit 4 | 4.13.2 | Test runner |

## Project Structure

```
src/test/
├── java/
│   ├── CucumberTestSuite.java          # Test runner
│   ├── utils/
│   │   ├── BaseApi.java                # Common HTTP request & assertion helpers
│   │   ├── ConfigManager.java          # Reads config.properties
│   │   ├── DataGenerator.java          # Random test data factory
│   │   ├── TokenManager.java           # In-memory auth token storage
│   │   └── TestDataStore.java          # In-memory shared test data (IDs, etc.)
│   └── starter/
│       ├── auth/                       # Login & Register API classes
│       ├── dokter/                     # Doctor CRUD API classes
│       ├── pasien/                     # Patient CRUD API classes
│       ├── jadwal/                     # Schedule CRUD API classes
│       ├── user/                       # User CRUD API classes
│       └── stepdefinitions/            # Cucumber step definitions
└── resources/
    ├── config.properties               # Base URL & credentials config
    ├── Authentication/                 # Feature files: login, register
    ├── DataDokter/                     # Feature files: doctor CRUD
    ├── DataPasien/                     # Feature files: patient CRUD
    ├── KelolaJadwal/                   # Feature files: schedule CRUD
    └── User/                           # Feature files: user CRUD
```

## Configuration

All environment settings are in `src/test/resources/config.properties`:

```properties
base.url=https://your-api-server.com/
admin.username=admin
admin.password=admin123
admin.role=ROLE_ADMIN
doctor.username=sasa
doctor.password=sasa123
doctor.role=ROLE_DOKTER
```

To point to a different environment, just update this single file.

## How to Run

### Prerequisites
- Java 11+ installed
- Maven 3.x installed

### Run all tests
```bash
mvn clean verify
```

### Run specific feature tag
```bash
mvn clean verify -Dcucumber.filter.tags="@LoginAdmin"
```

### Generate Serenity report only
```bash
mvn serenity:aggregate
```

Reports are generated at `target/site/serenity/index.html`.

## Available Test Tags

| Tag | Description |
|-----|-------------|
| `@LoginAdmin` | Admin login scenarios |
| `@LoginDoctor` | Doctor login scenarios |
| `@Register` | Account registration |
| `@GetAllDokter` | Get all doctors |
| `@CreateDokter` | Create doctor |
| `@UpdateDokter` | Update doctor |
| `@DeleteDokter` | Delete doctor |
| `@GetAllPasien` | Get all patients |
| `@CreatePasien` | Create patient |
| `@UpdatePasien` | Update patient |
| `@DeletePasien` | Delete patient |
| `@CreateJadwal` | Create schedule |
| `@UpdateJadwalAdmin` | Update schedule (admin) |
| `@UpdateJadwalDoctor` | Update schedule (doctor) |
| `@DeleteJadwal` | Delete schedule |

## API Endpoints Tested

| Module | Endpoints |
|--------|-----------|
| Auth | `POST /api/auth/login/`, `POST /api/auth/register/`, `PUT /api/auth/updateuser/{id}` |
| Doctor | `GET /dokter/`, `GET /dokter/{id}`, `GET /dokter/getbydokter/`, `POST /dokter/`, `PUT /dokter/{id}`, `DELETE /dokter/{id}` |
| Patient | `GET /pasien/`, `GET /pasien/{id}`, `POST /pasien/`, `PUT /pasien/{id}`, `DELETE /pasien/{id}` |
| Schedule | `GET /jadwal/`, `GET /jadwal/{id}`, `GET /jadwal/jadwalbydokter/`, `POST /jadwal/`, `PUT /jadwal/{id}`, `PUT /jadwal/editbydokter/{id}`, `DELETE /jadwal/{id}` |
| User | `GET /user/`, `GET /user/{id}`, `PUT /user/{id}`, `DELETE /user/{id}` |

## Test Approach

- **Positive tests**: Valid data, expect 200 response with correct body
- **Negative tests**: Empty fields, invalid data, null values, wrong IDs
- **Auth flow**: Login first to obtain token, then use token for protected endpoints
- **Data-driven**: Cucumber Scenario Outline with Examples table for multiple test cases per scenario

## Notes

- The original API server (`herokuapp.com`) is no longer active (Heroku removed free tier in Nov 2022)
- To run tests against a live server, update `base.url` in `config.properties`
- Token and test data are shared in-memory between scenarios (no file I/O dependency)
