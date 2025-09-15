Feature: Login

  @test1
  Scenario Outline: Login
    Given I am a amazon Page
    When User enters username and password
    And verify below products
      | iphone   | smasung   | vivo   | oppo   |
      | <iphone> | <smasung> | <vivo> | <oppo> |
    Examples:
      | iphone | smasung | vivo | oppo |
      | 10     | 5       | 18   | 20   |
      | 11     | 10      | 16   | 5    |