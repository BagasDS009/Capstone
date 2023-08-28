@SearchDataPasien
Feature: Search Data Pasien - Admin

  @SearchPatientData
  Scenario Outline: As a admin i want to delete data pasien
    Given Open page data pasien
    And Click search all category Patient data
    When Click chose nama
    And Input data "<namacategory>" category
    Then Valid data category pasien
    Examples:
      |namacategory|
      |    bagas   |
      |  &%^%^*)%  |