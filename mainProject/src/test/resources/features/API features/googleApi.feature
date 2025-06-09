Feature: Google api

  @googleAPI1
  Scenario: Google api - Add
    Given I 'ADD' place
    Then Retrieve 'place_id' from response
    Then I 'UPDATE' place
    Then I 'GET' place

  @googleAPI2
  Scenario: Google api - Complex JSON
    Given I perform all operations in Complex JSON