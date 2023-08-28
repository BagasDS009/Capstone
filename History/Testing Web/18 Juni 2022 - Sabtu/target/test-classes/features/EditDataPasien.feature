@EditPatientData
Feature: Edit Data Pasien - Admin

  Scenario Outline: As a admin i want to edit data pasien
    Given Open page data pasien
    And Click Detail Patient data
    When Valid data detail pasien
    And Click button edit profil
    And Clean all data pasien
    Then I input "<namalengkap>" "<nik>" "<usia>" "<nomortelepon>" "<alamat>" patient
    And I click button jenis kelamin patient
    And Click button simpan
    And Valid edit data
    Examples:
      |namalengkap|    nik      |usia|  nomortelepon   |    alamat    |
      |   Bagas   |  1234479680 | 20 |   01294657612   |   perumahan  |
      |           |  1234479680 | 20 |   01294657612   |   perumahan  |
      |  Bagas    |             | 20 |   01294657612   |   perumahan  |
      |  Bagas    | 1234479680  |    |  01294657612    |   perumahan  |
      |  Bagas    |  1234479680 | 20 |                 |   perumahan  |
      |  Bagas    |  1234479680 | 20 |   01294657612   |              |