Feature: Google api

  @googleAPI
  Scenario: Google api - Add
    Given I 'ADD' place
    Then Retrieve 'place_id' from response
    Then I 'UPDATE' place
    Then I 'GET' place