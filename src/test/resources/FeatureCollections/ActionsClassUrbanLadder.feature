#Program to navigate all the menus in urbanladder and print the menu list using Action class
Feature:To check the functionality of urban ladder menus
Background:
Given user opens the chrome browser for urban ldder as "https://www.urbanladder.com/"

@urbanLadder
Scenario:To check the functionality of urban ladder menus and print all menus
Given User Navigate to all the menus present in the urban ladder
And User user prints the menu list present int he urban ladder
Then user closes the browser for urban ladder

