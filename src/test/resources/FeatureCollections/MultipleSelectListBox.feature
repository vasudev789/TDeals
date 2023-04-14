#Program to understand the functionality of multiple select listbox
Feature: To check the functionality of Multiple select listbox

  Background: 
    Given user launches the chromeBrowser for to test Multipe select

 @MultipleSelect
  Scenario Outline: 
    Given user launches the URL as "<URL>"
    And user click on multiple select list box and select "<Option1>" and "<Option2>"
    And user prints all the elements of listbox
    And user deselects the selected options "<Option1>" and "<Option2>"
    And user closes the browser for muliptle select

    Examples: 
      | URL                                       | Option1 | Option2 |
      | http://uitestpractice.com/students/Select | China   | England |
