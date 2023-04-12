Feature: To check location New York present in json responses
Scenario Outline: Functionality to test json response
Given customer logs to the website with URL as "<URL>"
And Customers sends the GetMethod with Endpoint as "<EndPoint>"
Then Customer validates the HttpStatus code as "<HttpStatuscode>"
And Customer validate the state as "<State>"

Examples:	
|URL|EndPoint|HttpStatuscode|State|
|https://run.mocky.io/|v3/b47acb82-8b9a-489d-8e79-a2f193b14f71|200|New York|