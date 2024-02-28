@CheckCompareProductsFunctionality @Regression
Feature: Verify compare products functionality

  Background: 
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header sign-in link
    And "Customer Login" page is displayed
    When User enters the email address "Test121@yopmail.com" and password "Test12345"
    And User clicks on the sign-in button
    Then User should be logged in

  @CheckCompareProducts
  Scenario Outline: Verify user is able to Compare the products
    And User scrolls all the way down to hot seller section
    When Clicks on three bar button to add first <product1> to compare list
    Then You added product <product1> to the comparison list shows up
    And Clicks on three bar button to add secound <product2> to compare list
    Then You added secound product <product2> to the comparison list shows up
    Then Click compare products
    And User get directed to "Compare Products" page
    Then Check the products added <product1> and <product2> to the list are same products user has added by comparing name,SKU and description

    Examples: 
      | product1    | product2          |
      | Radiant Tee | Breathe-Easy Tank |
