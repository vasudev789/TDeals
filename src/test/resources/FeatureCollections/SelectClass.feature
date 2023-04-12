#Program to understand the functionality of select class
Feature: To check the fucntionaly of drop down using select class

  Background: 
    Given user opens the chrome broswer for face book

@selectClass
  Scenario Outline: 
    : To check the functionality of drop down using face book

    Given user launches the face book website "<URL>"
    And user select the day of his choice "<DAY>"
    And user selects the Month of his choice "<Month>"
    And user selects the year of his choice "<YEAR>"
    And user closes the chrome browser for face book

    Examples: 
      | URL                                                                  | DAY | Month | YEAR |
      | https://www.facebook.com/campaign/landing.php?&campaign_id=973072061 |  31 | May   | 1990 |
