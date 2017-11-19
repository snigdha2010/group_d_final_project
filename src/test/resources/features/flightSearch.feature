 @regression
  Feature: Multi-City Flight Search feature

  Background:
    Given I am on the Homepage of Hotel.com

    @regression-1
    Scenario: Verify Multi-City Flight Search

      When I click on menu.
    And I click on Packages and Flights button
    And I click on Flight Only button
    And I click on Multi-city flight option
    And I click on Flying From option field and write Charlotte keyword and I select  Amalie, U.S. Virgin Islands
    And I click on Flying To option field and write New keyword and I select John F. Kennedy Intl..
    And I click on Departing field option and I select 28 as departing date from calendar
    And I select 1 Adult in Adults drop down field
    And I select 0 Children in children drop down field
    And I click on Flying From another option field and write New keyword and I select John F. Kennedy Intl..
    And I click on Flying To another option field and write Frankfurt keyword and I select Frankfurt Intl..
    And I click on Departing field and I select 30 as departing date from calendar
    And I click on Advanced options field
    And I select No Preference in Preferred Airlines
    And I select Business in Preferred Class field
    And I click on the Search button
    Then I verify Trip1, Trip2 in another page
