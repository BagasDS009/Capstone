# Automation Website Testing - Klinik Management System

Automated UI test suite for the Klinik (Clinic) Management System web application, built with **Selenium WebDriver**, **Serenity BDD**, and **Cucumber**.

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Language |
| Maven | 3.x | Build & dependency management |
| Serenity BDD | 3.2.5 | Test framework, WebDriver management & reporting |
| Cucumber | 7.2.3 | BDD test scenarios |
| Selenium | (via Serenity) | Browser automation |
| JUnit 5 | 5.8.2 | Test runner (via vintage engine) |

## Project Structure

```
src/test/
├── java/
│   ├── CucumberTestSuite.java              # Test runner
│   └── starter/
│       ├── pages/
│       │   ├── LoginPage.java              # Login page object
│       │   ├── DashboardPage.java          # Dashboard navigation
│       │   ├── PatientDataPage.java        # Patient CRUD page
│       │   ├── DokterDataPage.java         # Doctor CRUD page
│       │   ├── KelolaJadwalPage.java       # Schedule management page
│       │   └── ArsipJadwalPage.java        # Schedule archive page
│       └── stepdefinitios/
│           ├── LoginSteps.java             # Auth step definitions
│           ├── PatientDataSteps.java       # Patient steps
│           ├── DokterDataSteps.java        # Doctor steps
│           ├── KelolaJadwalSteps.java      # Schedule steps
│           └── ArsipJadwalSteps.java       # Archive steps
└── resources/
    └── features/                           # Cucumber feature files
        ├── 1Login.feature
        ├── 2LogOut.feature
        ├── 3DataDokter.feature
        ├── 4DataPasien.feature
        ├── 5KelolaJadwal.feature
        ├── 6ArsipJadwal.feature
        ├── AddDataDokter.feature
        ├── AddDataPasien.feature
        ├── EditDataDokter.feature
        ├── EditDataPasien.feature
        ├── DeleteDataDokter.feature
        ├── DeleteDataPasien.feature
        ├── SearchDataDokter.feature
        ├── SearchDataPasien.feature
        └── ... (more feature files)
```

## Configuration

Settings in `serenity.properties` (project root):

```properties
webdriver.driver=chrome
webdriver.base.url=https://puskesmas-malaka.netlify.app/
webdriver.autodownload=true
```

Serenity automatically downloads the correct ChromeDriver — no manual binary needed.

## How to Run

### Prerequisites
- Java 11+ installed
- Maven 3.x installed
- Chrome browser installed

### Run all tests
```bash
mvn clean verify
```

### Generate Serenity report
```bash
mvn serenity:aggregate
```

Reports at `target/site/serenity/index.html`.

## Test Coverage

| Module | Scenarios |
|--------|-----------|
| Login | Valid login, empty fields, invalid credentials |
| Logout | Confirm logout, cancel logout |
| Patient Data | View, Add, Edit, Delete, Search, Detail |
| Doctor Data | View, Add, Edit, Delete, Search, Detail |
| Schedule | View, Add, Search |
| Archive | View, Search, Detail review |

## Design Patterns

- **Page Object Model**: Each web page has a dedicated class extending Serenity `PageObject`
- **Serenity Steps**: `@Step` annotation for reporting and abstraction
- **Cucumber BDD**: Feature files in Gherkin, step definitions glue the scenarios to page actions

## Notes

- The web app is hosted on Netlify (`puskesmas-malaka.netlify.app`) — it may or may not still be active
- ChromeDriver is auto-managed by Serenity (no need to commit binaries)
- Feature files are numbered (1-6) to control execution order for dependent flows
