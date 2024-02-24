@SortCheck @Suite
Feature: Verify sort products functionality

  Background: 
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header sign-in link
    And "Customer Login" page is displayed
    When User enters the email address "Test121@yopmail.com" and password "Test12345"
    And User clicks on the sign-in button
    Then User should be logged in

  @SortByPrice
  Scenario: Verify user is able to sort by product price
    When User clicks on shop new yoga button
    Then the "New Luma Yoga Collection" page is displayed
    And Click on the sort by dropdown
    And Select sort by price
    Then check sorting is done according to the price 
    
   @SortByProductName
    Scenario: Verify user is able to sort by Product Name
    When User clicks on shop new yoga button
    Then the "New Luma Yoga Collection" page is displayed
    And Click on the sort by dropdown
    And Select sort by Product Name
    Then check sorting is done according to the Product Name
    
   