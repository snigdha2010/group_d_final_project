@regression
Feature: Booking feature

  Background:
    Given I am on Hotel.com Home page

  @regression-1
  Scenario: Verify booking feature
    When I click on Sign In & Account link on home screen
    And I click on Your booking
    And I enter snigdha.sahara@gmail.com into Email Address text field on sign in page
    And I enter Aabccdeef9* into password text field on sign in page
    And I click Sign in button
#    Then verify that I have no booking /invalid booking by the text You have no bookings











