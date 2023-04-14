#Program to test the functionality of drag and drop feature
Feature: To test the functionality of drag and drop

  Background: 
    Given User opens the chrome browser for jquery website

  @dragNdrop
  Scenario Outline: To check functionality of drag and drop in jquery website
    Given User opens the jquery url as "<URL>"
    And user selects the drag option
    And user selects the drop option
    And user drops the selected drag
    And user closes the browser for jquery

    Examples: 
      | URL                             |
      | https://jqueryui.com/droppable/ |
