#Test case to validate the response body for Post reqres when request payload is sent
Feature: Test case to validate the response body field


  Scenario Outline: Test case to validate the response body field
    Given User select the website or URL as reqres "<URL>"
    And User select the endpoint for reqres "<EndPoint>"
    And User Post the reqres with Payload
    Then the payload should contain job field as "<Job>"

    Examples: 
      | URL               | EndPoint   | Job      |
      | https://reqres.in | /api/users | Inventor |

      