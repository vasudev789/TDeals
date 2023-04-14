# Test case on Delete Method
Feature: Test case on Delete Method using Reqres

  Scenario Outline: Testcase to validate the http status code for Delete Method
    Given Users selects the URL as "<URL>"
    And Users selects the Endpoint as "<EndPoint>"
    And User hits the Delete Endpoint
    Then User validates the "<HttpCode>"

    Examples: 
      | URL               | EndPoint     | HttpCode |
      | https://reqres.in | /api/users/2 |      204 |
