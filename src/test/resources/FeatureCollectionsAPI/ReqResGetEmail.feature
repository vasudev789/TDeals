#Test case to validate all email from Get Method using req res webiste
Feature: Test case for Get To validate the email in response body

  Scenario Outline: Test case one to extract all email in response body
    Given User select website  Reqres as URL "<URL>"
    And User selects the enpdoint for Reqres "<EndPoint>"
    And User sends the Get Method for Reqres API
    And User Prints all the Email from response body
    Then User Validates the Email value "<ExpectedEmail>"

    Examples: 
      | URL               | EndPoint          | ExpectedEmail           |
      | https://reqres.in | /api/users?page=2 | rachel.howell@reqres.in |
