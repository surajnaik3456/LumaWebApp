@SortCheck @Regression
Feature: Verify sort products functionality

  Background: 
    Given User is logged in with email "Tester113@yopmail.com" and password "Test12345"

  @SortByPrice
  Scenario: Verify user is able to sort by product price
  
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And User clicks on the sort by dropdown
    And User selects sort by price
    Then Check sorting is done according to the price

  @SortByProductName
  Scenario: Verify user is able to sort by Product Name
    When User clicks on shop new yoga button
    Then the "New Luma Yoga Collection" page is displayed
    And User clicks on the sort by dropdown
    And User selects sort by price
    Then Check sorting is done according to the Product Name
