Feature: Login
  As a user
  I want to log in
  So that I can access the home screen

  Background:
    Given I open the app

  @happy_path
  Scenario: Successful login
    When I enter "user" into the field with id "usernameField"
    And I enter "pass1234" into the field with id "passwordField"
    And I tap the button with id "loginButton"
    Then I see the Home screen

  @wrong_credentials
  Scenario: Wrong username or password
    When I enter "user" into the field with id "usernameField"
    And I enter "wrongpass" into the field with id "passwordField"
    And I tap the button with id "loginButton"
    Then I see text "Invalid credentials"

  @validation_password
  Scenario: Too short password
    When I enter "user" into the field with id "usernameField"
    And I enter "123" into the field with id "passwordField"
    And I tap the button with id "loginButton"
    Then I see text "Password too short"
