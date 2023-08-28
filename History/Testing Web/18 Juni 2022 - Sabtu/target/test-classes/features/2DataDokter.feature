@DataDokter
Feature: Data Dokter Admin

  @ViewDokterData
  Scenario: As a admin i want to view data dokter
    Given Open page dasbord
    When Click button data dokter
    Then View Dokter data

  @DetailDokterData
  Scenario: As a admin i want to detail data dokter
    Given Open page data dokter
    When Click Detail dokter data
    Then Valid data detail dokter

  @AddDokterData
  Scenario Outline: As a admin i want to add data dokter
    Given Open page data dokter
    When Click button tambah data
    Then I input "<namalengkap>" "<idi>" "<spesialis>" "<username>" "<pass>" dokter
    And Click button simpan
    And Valid data dokter
    Examples:
      |namalengkap|idi|spesialis|username|pass|
      |   Bagas   |  12344 | Bedah |   BagasBedah   |   BagasBedah  |
      |           |  12344 | Bedah |   BagasBedah   |   BagasBedah  |
      |  Bagas    |        | Bedah |   BagasBedah   |   BagasBedah  |
      |  Bagas    | 12344  |       |  BagasBedah    |   BagasBedah  |
      |  Bagas    |  12344 | Bedah |                |   BagasBedah  |
      |  Bagas    |  12344 | Bedah |   BagasBedah   |               |

  @EditDokterData
  Scenario Outline: As a admin i want to edit data dokter
    Given Open page data dokter
    And Click Detail dokter data
    When Valid data detail dokter
    And Click button edit profil
    And Clean all data dokter
    Then I input "<namalengkap>" "<idi>" "<spesialis>" "<username>" "<pass>" dokter
    And Click button simpan
    And Valid edit data
    Examples:
      |namalengkap|idi|spesialis|username|pass|
      |   Bagas   |  12344 | Bedah |   BagasBedah   |   BagasBedah  |
      |           |  12344 | Bedah |   BagasBedah   |   BagasBedah  |
      |  Bagas    |        | Bedah |   BagasBedah   |   BagasBedah  |
      |  Bagas    | 12344  |       |  BagasBedah    |   BagasBedah  |
      |  Bagas    |  12344 | Bedah |                |   BagasBedah  |
      |  Bagas    |  12344 | Bedah |   BagasBedah   |               |

  @YesDeleteDokterData
  Scenario: As a admin i want to delete data dokter
    Given Open page data dokter
    When Click Delete dokter data
    Then Valid data delete dokter

  @SearchDokterData
  Scenario Outline: As a admin i want to delete data dokter
    Given Open page data dokter
    And Click search all category dokter data
    When Click chose nama
    And Input data "<namacategory>" category
    Then Valid data category pasien
    Examples:
      |namacategory|
      |    Bagas   |
      |  &%^%^*)%  |
