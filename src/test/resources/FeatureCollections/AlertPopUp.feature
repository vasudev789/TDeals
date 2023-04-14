#Program to under stand the functionality of alert popups
Feature: To check the functionality of alert popups in rediffmail

  Background: 
    Given user opens the chrome browser for rediff

  @alertPopup1
  Scenario Outline: To check the functionality of alert popups
    Given Use launchess the url as "<URL>"
    Given user only enters the user name "<Name>"
    And user clicks on signing button
    Then user receives an popup messase as "<Message>"
    And user accepts the popus message
    And closes the browser

    Examples: 
      | URL                                       | Message                    | Name |
      | https://mail.rediff.com/cgi-bin/login.cgi | Please enter your password | Dev  |

  @alertPopup2
  Scenario Outline: To check the functionality of alert popups
    Given Use launchess the url as "<URL>"
    Given user only enters the password "<Password>"
    And user clicks on signing button
    Then user receives an popup messase as "<Message>"
    And user accepts the popus message
    And closes the browser

    Examples: 
      | URL                                       | Message                        | Password |
      | https://mail.rediff.com/cgi-bin/login.cgi | Please enter a valid user name |      123 |

      
      @alertPopup3
  Scenario Outline: To check the functionality of alert popups
    Given Use launchess the url as "<URL>"
    And user directly clicks on signing button
    Then user receives an popup messase as "<Message>"
    And user accepts the popus message
    And closes the browser

    Examples: 
      | URL                                       | Message                        |
      | https://mail.rediff.com/cgi-bin/login.cgi | Please enter a valid user name |
      