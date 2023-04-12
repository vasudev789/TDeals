Feature: Test the response of json array

  Scenario Outline: 
    Given Customer logs in to the website with URL as "<URL>"
    And Customer sends the Get Method with "<Endpoint>"
    Then The http response code will be as "<ExpectedstatusCode>"
    And validate the name in response body as "<Name>"

    Examples: 
      | URL                   | Endpoint                                | ExpectedstatusCode | Name |
      | https://run.mocky.io/ | v3/ac71d84a-ee94-4a42-a68a-ba57de0e1d82 |                200 | lala |
