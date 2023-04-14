Feature: To test the response header validation

  Scenario Outline: Test case one to test the response header validation
    Given user select the URL as "<URL>"
    And user select the endpoint "<Endpoint>"
    And user sends the Get Method for endpoint
    And user recives the http response with resposone Header
    Then user valiadtes the response header  value "<Server>"
    And user validates the response header value "<Connection>"

    Examples: 
      | URL               | Endpoint          | Server | Connection |
      | https://reqres.in | /api/users?page=2 | Server | keep-alive |
