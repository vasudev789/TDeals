# Updating record using PUT Method
Feature: Test case to update the record using PUT Method

  Scenario Outline: Test case to valiate the name feild using PUT Method
    Given User selects the URL for put "<URL>"
    And User selects the EndPoint for put "<EndPoint>"
    And user Hits the Endpoint that is PUT Method with request body
    Then user validates the status code as "<StatusCode>" and name feild as "<Name>"

    Examples: 
      | URL               | EndPoint     | StatusCode | Name           |
      | https://reqres.in | /api/users/2 |        200 | GeorgeoBasarie |
