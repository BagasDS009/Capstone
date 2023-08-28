@DataPasien
Feature: Data Pasien Admin

  @ViewPatientData
  Scenario Outline: As a admin i want to view data pasien
    Given User selects admin role
    When I input "<username>" login email
    And I input "<password>" login password
    Then I click button login
    And Click button data pasien
    And View Patient data
    Examples:
      |username|password|
      |bagas   |123     |

  @DetailPatientData
  Scenario Outline: As a admin i want to view data pasien
    Given User selects admin role
    When I input "<username>" login email
    And I input "<password>" login password
    Then I click button login
    And Click button data pasien
    And Click Detail Patient data
    Examples:
      |username|password|
      |bagas   |123     |

  @AddPatientData
  Scenario Outline: As a admin i want to add data pasien
    Given User selects admin role
    And I input "<username>" login email
    And I input "<password>" login password
    When I click button login
    And Click button data pasien
    And Click button tambah data
    Then I input "<namalengkap>" "<nik>" "<usia>" "<nomortelepon>" "<alamat>" patient
    And I click button jenis kelamin patient
    And Click button simpan
    Examples:
      |username|password|namalengkap|nik|usia|nomortelepon|alamat|
      |bagas   |123     |   Bagas   |  1734 | 20 |   097876   |   perumahan  |
      |bagas   |123     |           |  1211 | 12 |   088089   |   perumahan  |
      |bagas   |123     |  yogi     |       | 19 |   123423   |   perumahan  |
      |bagas   |123     |  yogi     | 1123  |    |  0987132   |   perumahan  |
      |bagas   |123     |  yogi     |  1123 | 11 |            |   perumahan  |
      |bagas   |123     |  yogi     |  1123 | 11 |   123123   |              |

  @AddPatientDataNoJK
  Scenario Outline: As an admin I want to add patient data forgot select gender
    Given User selects admin role
    And I input "<username>" login email
    And I input "<password>" login password
    When I click button login
    And Click button data pasien
    And Click button tambah data
    Then I input "<namalengkap>" "<nik>" "<usia>" "<nomortelepon>" "<alamat>" patient
    And Click button simpan
    Examples:
      |username|password|namalengkap|nik|usia|nomortelepon|alamat|
      |bagas   |123     |   Bagas   |  1734 | 20 |   097876   |   perumahan  |

  @YesDeletePatientData
  Scenario Outline: As a admin i want to delete data pasien
    Given User selects admin role
    And I input "<username>" login email
    And I input "<password>" login password
    When I click button login
    And Click button data pasien
    Then Pressing the trash image in action
    And Click button hapus ya
    Examples:
      |username|password|
      |bagas   |123     |

  @TidakDeletePatientData
  Scenario Outline: As a admin i wan't to delete data pasien
    Given User selects admin role
    And I input "<username>" login email
    And I input "<password>" login password
    When I click button login
    And Click button data pasien
    Then Pressing the trash image in action
    And Click button hapus tidak
    Examples:
      |username|password|
      |bagas   |123     |