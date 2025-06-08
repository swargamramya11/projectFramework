Feature: Native application - General Store

  @GeneralStore1 @appiumNativeAppGeneralStore
  Scenario Outline: Native application automation - general store
    Given I enter '<Your Name>'
    Then I select 'Female' radio button
    Then I select 'Argentina' from dropdown
    Then I click 'Let's Shop' button
    Examples:
      | Your Name     |
      | Swargam Ramya |

  @GeneralStore2 @appiumNativeAppGeneralStore
  Scenario: Native application automation - general store - verify toast message
    Then I select 'Female' radio button
    Then I click 'Let's Shop' button
    Then Verify toast error message

  @GeneralStore3 @appiumNativeAppGeneralStore
  Scenario Outline: Native application automation - get all details
    Given I enter '<Your Name>'
    Then I select 'Female' radio button
    Then I select 'Argentina' from dropdown
    Then I click 'Let's Shop' button
    Then Get all elements and add 'Jordan 6 Rings' product to cart
    Then I click 'Cart' button
    Then I wait for 'Cart' title
    Examples:
      | Your Name     |
      | Swargam Ramya |
