# Automation Mobile Testing - Klinik Management System

Automated UI test suite for the Klinik (Clinic) Management System Android app, built with **Appium**, **Cucumber BDD**, and **Serenity**.

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Language |
| Maven | 3.x | Build & dependency management |
| Appium | 7.3.0 | Mobile automation framework |
| Serenity BDD | 2.6.0 | Test framework & reporting |
| Cucumber | 6 (via Serenity) | BDD test scenarios |
| JUnit 5 | 5.8.2 | Assertions |
| UIAutomator2 | - | Android driver |

## Project Structure

```
src/
├── main/java/com/example/app/
│   ├── base/
│   │   └── BasePageObject.java         # Common element interactions (find, click, type, wait)
│   ├── drivers/
│   │   └── AndroidDriverInit.java      # Appium driver setup (reads from config)
│   ├── pages/
│   │   ├── LoginPage.java              # Login screen page object
│   │   ├── DashboardAdminPage.java     # Admin dashboard
│   │   ├── DashboardDoctorPage.java    # Doctor dashboard
│   │   ├── DataDoctorPage.java         # Doctor CRUD screens
│   │   ├── DataPatientPage.java        # Patient CRUD screens
│   │   ├── ManageSchedulePage.java     # Daily schedule management
│   │   ├── ArchiveSchedulePage.java    # Schedule archive
│   │   └── ReviewDoctorPage.java       # Doctor review/diagnosis
│   └── utils/
│       └── General.java                # Random test data generator
├── main/resources/
│   └── appium.properties               # Appium & device config
└── test/
    ├── java/com/example/
    │   ├── acceptancetests/
    │   │   └── AcceptanceTestSuite.java # Cucumber test runner
    │   ├── hooks/
    │   │   └── AndroidDriverHook.java   # Before/After hooks (driver lifecycle)
    │   └── steps/
    │       ├── Auth/                    # Login/Logout step definitions
    │       ├── DoctorData/              # Doctor CRUD steps
    │       ├── PatientData/             # Patient CRUD steps
    │       ├── ManageSchedule/          # Schedule steps
    │       ├── ArchiveSchedule/         # Archive steps
    │       └── Review/                  # Doctor review steps
    └── resources/
        ├── application/
        │   └── app-release.apk         # Android app under test
        ├── features/                   # Cucumber feature files
        └── cucumber.properties
```

## Configuration

All Appium settings are in `src/main/resources/appium.properties`:

```properties
appium.url=http://0.0.0.0:4723/wd/hub
device.platformName=Android
device.platformVersion=9
device.automationName=UIAutomator2
app.path=src/test/resources/application/app-release.apk
timeout.implicit=30
```

No hardcoded paths — update this file for your environment.

## Prerequisites

1. **Java 11+** installed
2. **Maven 3.x** installed
3. **Appium Server** running (`npm install -g appium`)
4. **Android emulator** or physical device connected
5. **Android SDK** configured

## How to Run

### Start Appium server
```bash
appium
```

### Run all tests
```bash
mvn clean verify
```

### Run specific tag
```bash
mvn clean verify -Dcucumber.filter.tags="@LoginAdmin"
```

### Generate report
```bash
mvn serenity:aggregate
```

Reports at `target/site/serenity/index.html`.

## Test Coverage

| Module | Features |
|--------|----------|
| Auth | Login admin, Login doctor, Logout admin, Logout doctor |
| Doctor Data | Add, Edit, Delete, Search, View detail, View list |
| Patient Data | Add, Edit, Delete, Search, View detail, View list |
| Schedule | View daily schedule, Search schedule |
| Archive | View archive, Search archive |
| Review | View review list, Process ordinary care review |

## Design Patterns

- **Page Object Model**: Each screen has a dedicated page class with locators and actions
- **Base Page Object**: Common interactions (find, click, type, wait) in one place
- **Cucumber BDD**: Feature files describe behavior in Gherkin syntax
- **Hook Pattern**: Driver lifecycle managed via `@Before`/`@After` hooks
