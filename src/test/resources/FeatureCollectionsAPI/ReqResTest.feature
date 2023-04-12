Feature:To Test the Reqres API responses

Scenario Outline:
Given PSU login to website "<URL>"
And PSU sends the GET Method request with end point "<Endpoint>"
Then the Http Method should be "<ExpectedCode>" ok
And validte the URL response data as for "<textResponse>"

Examples:
|URL|Endpoint|ExpectedCode|textResponse|
|https://reqres.in/|api/users?page=2|200|To keep ReqRes free, contributions towards server costs are appreciated!|

