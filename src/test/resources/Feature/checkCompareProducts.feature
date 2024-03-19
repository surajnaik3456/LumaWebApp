@CheckCompareProductsFunctionality @Regression
Feature: Verify compare products functionality

  @CheckCompareProducts
  Scenario Outline: Verify user is able to Compare the products
    Given User is logged in with email "Tester0001@yopmail.com" and password "Test12345"
    And User scrolls all the way down to hot seller section
    When Clicks on three bar button to add first <product1> to compare list
    Then You added product <product1> to the comparison list shows up
    And Clicks on three bar button to add secound <product2> to compare list
    Then You added secound product <product2> to the comparison list shows up
    When User clicks on compare products
    And User gets directed to "Compare Products" page
    Then Check the products added <product1> and <product2> to the list are same products user has added by comparing name,SKU and description

    Examples: 
      | product1    | product2          |
      | Radiant Tee | Breathe-Easy Tank |
