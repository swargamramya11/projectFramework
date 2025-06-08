Feature: Native application - General Store

  @GeneralStore1 @appiumNativeAppGeneralStore
  Scenario: Native application automation - general store - verify toast message
    Then I select 'Female' radio button
    Then I click 'Let's Shop' button
    Then Verify toast error message

  @GeneralStore2 @appiumNativeAppGeneralStore
  Scenario: Native application automation - get all details and verify price details
    Given I enter data in below field
      | Your Name     |
      | Swargam Ramya |
    Then I select 'Female' radio button
    Then I select 'Argentina' from dropdown
    Then I click 'Let's Shop' button
    Then Get all elements and add 'Air Jordan 4 Retro' product to cart
    Then Get all elements and add 'Jordan 6 Rings' product to cart
    Then I click 'Cart' button
    Then I wait for 'Cart' title
    Then Get price of all products in cart
    Then Verify total price
    Then I click 'Terms and Conditions' button
    Then I click 'Close' button
    Then I click 'Terms and Conditions' checkbox
    Then I click 'Proceed' button
    Then Get all contexts
    Then Navigate to required 'Web' context page
    Then I enter data in below field
      | Chrome Search        |
      | rahul shetty academy |
    Then I press 'Back' in mobile
    Then Navigate to required 'Native' context page