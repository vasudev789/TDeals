# To test Post Method with request payload or request body
Feature: scenarios to Post Method  with request payload for reqres website

  Scenario Outline: Test case one to test post method with request payload
    Given user uses the reqres website "<URL>"
    And user decides the endpoint to hit "<Endpoint>"
    And User stores the payload in string_format
    And User hits Post_Method with payload
    Then the status code should be as "<Expected_Status_Code>"

    Examples: 
      | URL               | Endpoint   | Expected_Status_Code |
      | https://reqres.in | /api/users |                  201 |
