Feature: Native application

  @appiumNative1
  Scenario Outline: Native application automation
    Given I am on apidemos app and click on 'Preference'
    Then I am on apidemos app and click on '3. Preference dependencies'
    Then I select 'wifi' checkbox
    Then I click on 'WiFi settings'
    Then I enter data in '<WIFi Settings>'
    Then I click on 'Ok'
    Examples:
      | WIFi Settings |
      | ramya         |

  @appiumNative2
  Scenario: Native application - Gestures long press
    Given I am on apidemos app and click on 'Views'
    Then I am on apidemos app and click on 'Expandable Lists'
    Then I am on apidemos app and click on '1. Custom Adapter'
    Then I longPress to get gesture popup 'People Names'

  @appiumNative3
  Scenario: Native application - Scroll
    Given I am on apidemos app and click on 'Views'