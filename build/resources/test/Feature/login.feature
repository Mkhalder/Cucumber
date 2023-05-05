Feature: Register

  @smoke
  Scenario Outline: User can Register with valid value
    Given Base url is provided
    When user '<firstName>' and '<lastName>' and '<email>'
    And enter '<password>' and '<repeatPassword>'
    And click Register
    Then user login home page

    Examples:
    |firstName|lastName|email|password|repeatPassword|
    |Manotosh |Halder  |manotosh.10@gmail.com|123456|123456|