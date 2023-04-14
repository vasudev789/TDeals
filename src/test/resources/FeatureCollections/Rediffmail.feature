#Program to check the login functionality of redifmail with invalid user
Feature: To check the login functionality of redifmail with invalid users

  Background: 
    Given user opens chrome browser for redifmail as "https://the-internet.herokuapp.com/login"

  @rediffmail
  Scenario Outline: 
    Given User Enters Invalid username and password and validates the ErrorMessage as "<ErrorMessage>"
    And User closes the browser after validating

    Examples: 
      | ErrorMessage              |
      | Your username is invalid! |
