@CookieTests
Feature: ClearScore Cookie Notification

  Scenario: ClearScore Cookie notification displayed
    When I navigate to the ClearScore homepage
    Then the cookie notification is displayed to the user

  Scenario: Dismissing the Cookie notification
    Given I am on the ClearScore homepage
    And the cookie notification is present
    When I dismiss the cookie notification
    Then the cookie notification will be removed

  Scenario: Checking Cookie notification does not reappear on refreshing the browser after accepting cookie notification
    Given I am on the ClearScore homepage
    And the cookie notification is present
    When I dismiss the cookie notification
    And I refresh the page
    Then the cookie notification will not be present on the page

  Scenario: Checking Cookie notification does not reappear when navigating the ClearScore site after accepting cookie notification
    Given I am on the ClearScore homepage
    And the cookie notification is present
    When I dismiss the cookie notification
    And I navigate to the ClearScore about us page
    And I navigate to the ClearScore homepage
    Then the cookie notification will not be present on the page

  Scenario: Checking Cookies are applied after accepting cookie notification
    Given I am on the ClearScore homepage
    And the cookie notification is present
    And the ClearScore cookie has not been set
    When I dismiss the cookie notification
    Then the ClearScore cookies will be applied to the browser