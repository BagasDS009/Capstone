# Capstone Membuat Hospital Management Sistem 

Program Hospital Management Sistem ini dibuat dengan dua role, role pertama adalah Pasien dan role kedua adalah Dokter. Untuk Role Pasien dapat melakukan konsultasi ke dokter yang tersedia, dan untuk role dokter dapat menjawab permasalahan pasien. kedua role dapat melakukan login pada page login yang sama. Program ini dibuat dengan versi Website dan Aplikasi Tablet. Dilakukan manual testing API, website, dan aplikasi secara berkala. dan juga dilakukan automation testing dengan selenium.

Berikut struktur folder dalam aplikasi ini:

```
PS D:\Studi Independent\Alterra\Capstone> tree
Folder PATH listing for volume DataBagas
Volume serial number is E03A-2810
D:.
├───AutomationApiTesting
│   ├───.idea
│   └───src
│       └───test
│           ├───java
│           │   ├───Starter
│           │   │   ├───Auth
│           │   │   ├───DataDokter
│           │   │   ├───DataPasien
│           │   │   ├───KelolaJadwal
│           │   │   ├───StepDefinitions
│           │   │   └───User
│           │   └───Utils
│           └───resources
│               ├───Authentication
│               ├───DataDokter
│               ├───DataPasien
│               ├───filejson
│               ├───KelolaJadwal
│               └───User
├───AutomationMobileTesing
│   ├───.gradle
│   │   ├───8.2
│   │   │   ├───checksums
│   │   │   ├───dependencies-accessors
│   │   │   ├───executionHistory
│   │   │   ├───fileChanges
│   │   │   ├───fileHashes
│   │   │   └───vcsMetadata
│   │   ├───buildOutputCleanup
│   │   └───vcs-1
│   ├───.idea
│   ├───gradle
│   │   └───wrapper
│   ├───history
│   ├───src
│   │   ├───main
│   │   │   └───java
│   │   │       └───com
│   │   │           └───example
│   │   │               └───app
│   │   │                   ├───base
│   │   │                   ├───drivers
│   │   │                   ├───pages
│   │   │                   └───utils
│   │   └───test
│   │       ├───java
│   │       │   └───com
│   │       │       └───example
│   │       │           ├───acceptancetests
│   │       │           ├───hooks
│   │       │           └───steps
│   │       │               ├───ArchiveSchedule
│   │       │               ├───Auth
│   │       │               ├───DoctorData
│   │       │               ├───ManageSchedule
│   │       │               ├───PatientData
│   │       │               └───Review
│   │       └───resources
│   │           ├───application
│   │           └───features
│   │               ├───ArchiveSchedule
│   │               ├───Auth
│   │               ├───DoctorData
│   │               ├───ManageSchedule
│   │               ├───PatientData
│   │               └───Review
│   └───target
│       └───site
│           └───serenity
├───AutomationWebsiteTesing
│   ├───.idea
│   │   └───codeStyles
│   ├───src
│   │   └───test
│   │       ├───java
│   │       │   └───starter
│   │       │       ├───pages
│   │       │       └───stepdefinitios
│   │       └───resources
│   │           ├───features
│   │           └───webdriver
│   └───target
│       ├───failsafe-reports
│       ├───maven-archiver
│       ├───maven-status
│       │   └───maven-compiler-plugin
│       │       ├───compile
│       │       │   └───default-compile
│       │       └───testCompile
│       │           └───default-testCompile
│       ├───site
│       │   └───serenity
│       │       ├───bootstrap
│       │       │   ├───css
│       │       │   ├───fonts
│       │       │   └───js
│       │       ├───bootstrap-icons
│       │       │   ├───font
│       │       │   │   └───fonts
│       │       │   └───icons
│       │       ├───bootstrap-treeview
│       │       │   └───dist
│       │       ├───chartjs
│       │       ├───css
│       │       ├───datatables
│       │       │   └───1.11.3
│       │       ├───dygraph
│       │       │   └───1.1.0
│       │       ├───excanvas
│       │       │   └───3
│       │       ├───icons
│       │       ├───images
│       │       ├───jit
│       │       │   ├───2.0.1
│       │       │   └───css
│       │       ├───jqtree
│       │       │   └───0.22
│       │       ├───jqueryui
│       │       │   └───1.11.2-start
│       │       │       ├───external
│       │       │       │   └───jquery
│       │       │       └───images
│       │       ├───nivo-slider
│       │       │   └───3.2
│       │       │       ├───demo
│       │       │       │   ├───images
│       │       │       │   └───scripts
│       │       │       └───themes
│       │       │           ├───bar
│       │       │           ├───dark
│       │       │           ├───default
│       │       │           └───light
│       │       ├───prism
│       │       └───scripts
│       └───test-classes
│           ├───features
│           ├───starter
│           │   ├───pages
│           │   └───stepdefinitios
│           └───webdriver
└───History
    └───Testing Web
        ├───13 Juni 2022 - Senin
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       ├───compile
        │       │       │   └───default-compile
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap
        │       │       │   ├───css
        │       │       │   ├───fonts
        │       │       │   └───js
        │       │       ├───bootstrap-icons
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───chartjs
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───icons
        │       │       ├───jit
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       ├───external
        │       │       │       │   └───jquery
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       └───themes
        │       │       │           └───light
        │       │       ├───prism
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   └───pages
        │           └───webdriver
        ├───15 Juli 2022
        │   ├───target
        │   │   ├───classes
        │   │   ├───failsafe-reports
        │   │   ├───generated-sources
        │   │   │   └───annotations
        │   │   ├───generated-test-sources
        │   │   │   └───test-annotations
        │   │   ├───maven-archiver
        │   │   ├───maven-status
        │   │   │   └───maven-compiler-plugin
        │   │   │       └───testCompile
        │   │   │           └───default-testCompile
        │   │   ├───site
        │   │   │   └───serenity
        │   │   │       ├───bootstrap
        │   │   │       │   ├───css
        │   │   │       │   ├───fonts
        │   │   │       │   └───js
        │   │   │       ├───bootstrap-icons
        │   │   │       │   ├───font
        │   │   │       │   │   └───fonts
        │   │   │       │   └───icons
        │   │   │       ├───bootstrap-treeview
        │   │   │       │   └───dist
        │   │   │       ├───css
        │   │   │       ├───icons
        │   │   │       ├───jqueryui
        │   │   │       │   └───1.11.2-start
        │   │   │       │       └───images
        │   │   │       ├───nivo-slider
        │   │   │       │   └───3.2
        │   │   │       │       ├───demo
        │   │   │       │       │   ├───images
        │   │   │       │       │   └───scripts
        │   │   │       │       └───themes
        │   │   │       │           ├───bar
        │   │   │       │           ├───dark
        │   │   │       │           ├───default
        │   │   │       │           └───light
        │   │   │       └───prism
        │   │   └───test-classes
        │   │       ├───features
        │   │       ├───starter
        │   │       │   ├───pages
        │   │       │   └───stepdefinitios
        │   │       └───webdriver
        │   └───target (08.41 WIB)
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       ├───compile
        │       │       │   └───default-compile
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap-icons
        │       │       │   ├───font
        │       │       │   │   └───fonts
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───css
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───icons
        │       │       ├───images
        │       │       ├───jit
        │       │       │   └───css
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       ├───external
        │       │       │       │   └───jquery
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───bar
        │       │       │           ├───dark
        │       │       │           ├───default
        │       │       │           └───light
        │       │       ├───prism
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───17 juli 2022 (17.56)
        │   ├───ArsipJadwal
        │   │   └───target
        │   │       ├───classes
        │   │       ├───failsafe-reports
        │   │       ├───generated-sources
        │   │       │   └───annotations
        │   │       ├───generated-test-sources
        │   │       │   └───test-annotations
        │   │       ├───maven-archiver
        │   │       ├───maven-status
        │   │       │   └───maven-compiler-plugin
        │   │       │       ├───compile
        │   │       │       │   └───default-compile
        │   │       │       └───testCompile
        │   │       │           └───default-testCompile
        │   │       ├───site
        │   │       │   └───serenity
        │   │       │       ├───bootstrap
        │   │       │       │   ├───fonts
        │   │       │       │   └───js
        │   │       │       ├───bootstrap-icons
        │   │       │       │   └───icons
        │   │       │       ├───bootstrap-treeview
        │   │       │       │   └───dist
        │   │       │       ├───chartjs
        │   │       │       ├───css
        │   │       │       ├───dygraph
        │   │       │       │   └───1.1.0
        │   │       │       ├───icons
        │   │       │       ├───images
        │   │       │       ├───jit
        │   │       │       │   ├───2.0.1
        │   │       │       │   └───css
        │   │       │       ├───jqtree
        │   │       │       │   └───0.22
        │   │       │       ├───jqueryui
        │   │       │       │   └───1.11.2-start
        │   │       │       │       └───images
        │   │       │       ├───nivo-slider
        │   │       │       │   └───3.2
        │   │       │       │       ├───demo
        │   │       │       │       │   ├───images
        │   │       │       │       │   └───scripts
        │   │       │       │       └───themes
        │   │       │       │           ├───bar
        │   │       │       │           ├───dark
        │   │       │       │           ├───default
        │   │       │       │           └───light
        │   │       │       └───scripts
        │   │       └───test-classes
        │   │           ├───features
        │   │           └───starter
        │   │               └───stepdefinitios
        │   ├───Data Dokter
        │   │   └───target
        │   │       ├───classes
        │   │       ├───failsafe-reports
        │   │       ├───generated-sources
        │   │       │   └───annotations
        │   │       ├───generated-test-sources
        │   │       │   └───test-annotations
        │   │       ├───maven-archiver
        │   │       ├───maven-status
        │   │       │   └───maven-compiler-plugin
        │   │       │       └───testCompile
        │   │       │           └───default-testCompile
        │   │       ├───site
        │   │       │   └───serenity
        │   │       │       ├───bootstrap
        │   │       │       │   ├───css
        │   │       │       │   ├───fonts
        │   │       │       │   └───js
        │   │       │       ├───bootstrap-icons
        │   │       │       │   ├───font
        │   │       │       │   │   └───fonts
        │   │       │       │   └───icons
        │   │       │       ├───bootstrap-treeview
        │   │       │       │   └───dist
        │   │       │       ├───chartjs
        │   │       │       ├───css
        │   │       │       ├───datatables
        │   │       │       │   └───1.11.3
        │   │       │       ├───excanvas
        │   │       │       │   └───3
        │   │       │       ├───icons
        │   │       │       ├───jit
        │   │       │       │   └───css
        │   │       │       ├───jqueryui
        │   │       │       │   └───1.11.2-start
        │   │       │       │       └───images
        │   │       │       ├───nivo-slider
        │   │       │       │   └───3.2
        │   │       │       │       ├───demo
        │   │       │       │       └───themes
        │   │       │       │           ├───default
        │   │       │       │           └───light
        │   │       │       └───scripts
        │   │       └───test-classes
        │   │           ├───features
        │   │           ├───starter
        │   │           │   ├───pages
        │   │           │   └───stepdefinitios
        │   │           └───webdriver
        │   ├───Data Pasien
        │   │   └───target(17.56)17
        │   │       ├───classes
        │   │       ├───failsafe-reports
        │   │       ├───generated-sources
        │   │       │   └───annotations
        │   │       ├───generated-test-sources
        │   │       │   └───test-annotations
        │   │       ├───maven-archiver
        │   │       ├───site
        │   │       │   └───serenity
        │   │       │       ├───bootstrap-icons
        │   │       │       │   ├───font
        │   │       │       │   │   └───fonts
        │   │       │       │   └───icons
        │   │       │       ├───bootstrap-treeview
        │   │       │       │   └───dist
        │   │       │       ├───css
        │   │       │       ├───datatables
        │   │       │       │   └───1.11.3
        │   │       │       ├───dygraph
        │   │       │       │   └───1.1.0
        │   │       │       ├───excanvas
        │   │       │       │   └───3
        │   │       │       ├───icons
        │   │       │       ├───images
        │   │       │       ├───jit
        │   │       │       │   └───css
        │   │       │       ├───jqtree
        │   │       │       │   └───0.22
        │   │       │       ├───jqueryui
        │   │       │       │   └───1.11.2-start
        │   │       │       │       └───images
        │   │       │       ├───nivo-slider
        │   │       │       │   └───3.2
        │   │       │       │       ├───demo
        │   │       │       │       │   ├───images
        │   │       │       │       │   └───scripts
        │   │       │       │       └───themes
        │   │       │       │           ├───bar
        │   │       │       │           ├───dark
        │   │       │       │           ├───default
        │   │       │       │           └───light
        │   │       │       ├───prism
        │   │       │       └───scripts
        │   │       └───test-classes
        │   │           ├───features
        │   │           ├───starter
        │   │           │   └───pages
        │   │           └───webdriver
        │   ├───KelolaJadwal
        │   │   └───target
        │   │       ├───classes
        │   │       ├───failsafe-reports
        │   │       ├───generated-sources
        │   │       │   └───annotations
        │   │       ├───generated-test-sources
        │   │       │   └───test-annotations
        │   │       ├───maven-archiver
        │   │       ├───maven-status
        │   │       │   └───maven-compiler-plugin
        │   │       │       ├───compile
        │   │       │       │   └───default-compile
        │   │       │       └───testCompile
        │   │       │           └───default-testCompile
        │   │       ├───site
        │   │       │   └───serenity
        │   │       │       ├───bootstrap
        │   │       │       │   ├───css
        │   │       │       │   └───fonts
        │   │       │       ├───bootstrap-icons
        │   │       │       │   └───icons
        │   │       │       ├───datatables
        │   │       │       │   └───1.11.3
        │   │       │       ├───dygraph
        │   │       │       │   └───1.1.0
        │   │       │       ├───icons
        │   │       │       ├───images
        │   │       │       ├───jit
        │   │       │       │   ├───2.0.1
        │   │       │       │   └───css
        │   │       │       ├───jqtree
        │   │       │       │   └───0.22
        │   │       │       ├───jqueryui
        │   │       │       │   └───1.11.2-start
        │   │       │       │       ├───external
        │   │       │       │       │   └───jquery
        │   │       │       │       └───images
        │   │       │       ├───nivo-slider
        │   │       │       │   └───3.2
        │   │       │       │       ├───demo
        │   │       │       │       │   ├───images
        │   │       │       │       │   └───scripts
        │   │       │       │       └───themes
        │   │       │       │           ├───bar
        │   │       │       │           ├───dark
        │   │       │       │           ├───default
        │   │       │       │           └───light
        │   │       │       └───prism
        │   │       └───test-classes
        │   │           ├───features
        │   │           └───starter
        │   │               └───stepdefinitios
        │   ├───Login
        │   │   └───target(18.23)17
        │   │       ├───classes
        │   │       ├───failsafe-reports
        │   │       ├───generated-sources
        │   │       │   └───annotations
        │   │       ├───generated-test-sources
        │   │       │   └───test-annotations
        │   │       ├───maven-archiver
        │   │       ├───maven-status
        │   │       │   └───maven-compiler-plugin
        │   │       │       ├───compile
        │   │       │       │   └───default-compile
        │   │       │       └───testCompile
        │   │       │           └───default-testCompile
        │   │       ├───site
        │   │       │   └───serenity
        │   │       │       ├───bootstrap
        │   │       │       │   ├───css
        │   │       │       │   ├───fonts
        │   │       │       │   └───js
        │   │       │       ├───bootstrap-icons
        │   │       │       │   ├───font
        │   │       │       │   │   └───fonts
        │   │       │       │   └───icons
        │   │       │       ├───bootstrap-treeview
        │   │       │       │   └───dist
        │   │       │       ├───chartjs
        │   │       │       ├───datatables
        │   │       │       │   └───1.11.3
        │   │       │       ├───excanvas
        │   │       │       │   └───3
        │   │       │       ├───icons
        │   │       │       ├───images
        │   │       │       ├───jit
        │   │       │       │   ├───2.0.1
        │   │       │       │   └───css
        │   │       │       ├───jqtree
        │   │       │       │   └───0.22
        │   │       │       ├───jqueryui
        │   │       │       │   └───1.11.2-start
        │   │       │       │       └───images
        │   │       │       ├───prism
        │   │       │       └───scripts
        │   │       └───test-classes
        │   │           ├───features
        │   │           ├───starter
        │   │           │   └───pages
        │   │           └───webdriver
        │   └───Logout
        │       └───target(18.23)17
        │           ├───classes
        │           ├───failsafe-reports
        │           ├───generated-sources
        │           │   └───annotations
        │           ├───generated-test-sources
        │           │   └───test-annotations
        │           ├───maven-archiver
        │           ├───maven-status
        │           │   └───maven-compiler-plugin
        │           │       └───compile
        │           │           └───default-compile
        │           ├───site
        │           │   └───serenity
        │           │       ├───bootstrap
        │           │       │   ├───css
        │           │       │   └───fonts
        │           │       ├───bootstrap-icons
        │           │       │   ├───font
        │           │       │   │   └───fonts
        │           │       │   └───icons
        │           │       ├───bootstrap-treeview
        │           │       │   └───dist
        │           │       ├───chartjs
        │           │       ├───css
        │           │       ├───datatables
        │           │       │   └───1.11.3
        │           │       ├───dygraph
        │           │       │   └───1.1.0
        │           │       ├───excanvas
        │           │       │   └───3
        │           │       ├───icons
        │           │       ├───images
        │           │       ├───jit
        │           │       │   ├───2.0.1
        │           │       │   └───css
        │           │       ├───jqtree
        │           │       │   └───0.22
        │           │       ├───jqueryui
        │           │       │   └───1.11.2-start
        │           │       │       ├───external
        │           │       │       │   └───jquery
        │           │       │       └───images
        │           │       ├───nivo-slider
        │           │       │   └───3.2
        │           │       │       ├───demo
        │           │       │       │   ├───images
        │           │       │       │   └───scripts
        │           │       │       └───themes
        │           │       │           ├───bar
        │           │       │           ├───dark
        │           │       │           ├───default
        │           │       │           └───light
        │           │       ├───prism
        │           │       └───scripts
        │           └───test-classes
        │               └───features
        ├───18 Juni 2022 - Sabtu
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap
        │       │       │   ├───css
        │       │       │   ├───fonts
        │       │       │   └───js
        │       │       ├───bootstrap-icons
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───css
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───dygraph
        │       │       │   └───1.1.0
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───icons
        │       │       ├───jit
        │       │       │   ├───2.0.1
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   └───images
        │       │       │       └───themes
        │       │       │           ├───dark
        │       │       │           └───light
        │       │       ├───prism
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───23 Juni 2022 - Kamis
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap
        │       │       │   ├───css
        │       │       │   ├───fonts
        │       │       │   └───js
        │       │       ├───bootstrap-icons
        │       │       │   ├───font
        │       │       │   │   └───fonts
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───css
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───dygraph
        │       │       │   └───1.1.0
        │       │       ├───icons
        │       │       ├───images
        │       │       ├───jit
        │       │       │   ├───2.0.1
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───default
        │       │       │           └───light
        │       │       ├───prism
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───24 Juni 2022 - Jumat
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap-icons
        │       │       │   ├───font
        │       │       │   │   └───fonts
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───dygraph
        │       │       │   └───1.1.0
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───icons
        │       │       ├───images
        │       │       ├───jit
        │       │       │   ├───2.0.1
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───bar
        │       │       │           ├───dark
        │       │       │           └───default
        │       │       └───prism
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───27 Juni 2022 - Senin
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       ├───compile
        │       │       │   └───default-compile
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap-icons
        │       │       │   └───icons
        │       │       ├───bootstrap-treeview
        │       │       │   └───dist
        │       │       ├───chartjs
        │       │       ├───css
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───icons
        │       │       ├───jit
        │       │       │   ├───2.0.1
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───bar
        │       │       │           ├───dark
        │       │       │           ├───default
        │       │       │           └───light
        │       │       ├───prism
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───5 Juli 2022
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       ├───compile
        │       │       │   └───default-compile
        │       │       └───testCompile
        │       │           └───default-testCompile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap-icons
        │       │       │   ├───font
        │       │       │   └───icons
        │       │       ├───chartjs
        │       │       ├───datatables
        │       │       │   └───1.11.3
        │       │       ├───dygraph
        │       │       │   └───1.1.0
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───icons
        │       │       ├───images
        │       │       ├───jit
        │       │       │   └───css
        │       │       ├───jqtree
        │       │       │   └───0.22
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       ├───external
        │       │       │       │   └───jquery
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───bar
        │       │       │           ├───dark
        │       │       │           ├───default
        │       │       │           └───light
        │       │       └───scripts
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───6 Juli 2022
        │   └───target
        │       ├───classes
        │       ├───failsafe-reports
        │       ├───generated-sources
        │       │   └───annotations
        │       ├───generated-test-sources
        │       │   └───test-annotations
        │       ├───maven-archiver
        │       ├───maven-status
        │       │   └───maven-compiler-plugin
        │       │       └───compile
        │       │           └───default-compile
        │       ├───site
        │       │   └───serenity
        │       │       ├───bootstrap-icons
        │       │       │   └───icons
        │       │       ├───chartjs
        │       │       ├───css
        │       │       ├───dygraph
        │       │       │   └───1.1.0
        │       │       ├───excanvas
        │       │       │   └───3
        │       │       ├───images
        │       │       ├───jit
        │       │       │   ├───2.0.1
        │       │       │   └───css
        │       │       ├───jqueryui
        │       │       │   └───1.11.2-start
        │       │       │       └───images
        │       │       ├───nivo-slider
        │       │       │   └───3.2
        │       │       │       ├───demo
        │       │       │       │   ├───images
        │       │       │       │   └───scripts
        │       │       │       └───themes
        │       │       │           ├───bar
        │       │       │           ├───dark
        │       │       │           ├───default
        │       │       │           └───light
        │       │       └───prism
        │       └───test-classes
        │           ├───features
        │           ├───starter
        │           │   ├───pages
        │           │   └───stepdefinitios
        │           └───webdriver
        ├───Code karena ga bisa push dengan git ke git hub
        │   └───TestingWebUpdate
        │       ├───.idea
        │       │   └───codeStyles
        │       ├───src
        │       │   ├───main
        │       │   │   ├───java
        │       │   │   └───resources
        │       │   └───test
        │       │       ├───java
        │       │       └───resources
        │       │           └───features
        │       └───target
        │           ├───classes
        │           ├───failsafe-reports
        │           ├───generated-sources
        │           │   └───annotations
        │           ├───generated-test-sources
        │           │   └───test-annotations
        │           ├───maven-archiver
        │           ├───maven-status
        │           │   └───maven-compiler-plugin
        │           │       └───testCompile
        │           │           └───default-testCompile
        │           ├───site
        │           │   └───serenity
        │           │       ├───bootstrap
        │           │       │   └───css
        │           │       ├───bootstrap-icons
        │           │       │   ├───font
        │           │       │   │   └───fonts
        │           │       │   └───icons
        │           │       ├───bootstrap-treeview
        │           │       │   └───dist
        │           │       ├───chartjs
        │           │       ├───excanvas
        │           │       │   └───3
        │           │       ├───icons
        │           │       ├───images
        │           │       ├───jit
        │           │       │   ├───2.0.1
        │           │       │   └───css
        │           │       ├───jqtree
        │           │       │   └───0.22
        │           │       ├───jqueryui
        │           │       │   └───1.11.2-start
        │           │       │       ├───external
        │           │       │       │   └───jquery
        │           │       │       └───images
        │           │       └───prism
        │           └───test-classes
        │               ├───features
        │               ├───starter
        │               │   └───pages
        │               └───webdriver
        └───Video
            ├───Arsip Jadwal
            ├───Data Dokter
            ├───Data Pasien
            │   └───Automatic
            ├───Kelola Jadwal
            ├───Login
            │   ├───Admin
            │   └───Dokter
            └───LogOut
```

## Credits

   Author: Bagas
