Feature: Native application

  @appiumNative1 @appiumNativeApp
  Scenario Outline: Native application automation
    Given I am on api demos app and click on 'Preference'
    Then I am on api demos app and click on '3. Preference dependencies'
    Then I select 'WiFi' checkbox
    Then I click on 'WiFi settings'
    Then I enter data in '<WiFi Settings>'
    Then I click on 'Ok'
    Examples:
      | WiFi Settings |
      | ramya         |

  @appiumNative2 @appiumNativeApp
  Scenario: Native application - Gestures long press
    Given I am on api demos app and click on 'Views'
    Then I am on api demos app and click on 'Expandable Lists'
    Then I am on api demos app and click on '1. Custom Adapter'
    Then I 'Long Press' to 'People Names'

  @appiumNative3 @appiumNativeApp
  Scenario: Native application - Scroll
    Given I am on api demos app and click on 'Views'
    Then I 'Scroll' to 'WebView'

  @appiumNative4 @appiumNativeApp
  Scenario: Native application - Swipe
    Given I am on api demos app and click on 'Views'
    Given I am on api demos app and click on 'Gallery'
    Given I am on api demos app and click on '1. Photos'
    Then I 'Swipe' to 'Photos'

  @appiumNative5 @appiumNativeApp
  Scenario: Native application - Drag and drop
    Given I am on api demos app and click on 'Views'
    Given I am on api demos app and click on 'Drag and Drop'
    Then I 'Drag and Drop' to 'destination'