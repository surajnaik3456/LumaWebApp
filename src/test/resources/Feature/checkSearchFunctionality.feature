@CheckSearchFunctionality
Feature: Verify search products functionality

  Background: 
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header sign-in link
    And "Customer Login" page is displayed
    When User enters the email address "Test121@yopmail.com" and password "Test12345"
    And User clicks on the sign-in button
    Then User should be logged in

  @CheckProductSearch
  Scenario Outline: Verify user is able to Verify user is able to search a product by entering keywords in the search bar
    When User clicks on search bar
    And Enter required product <name>
    And Suggestions appears with "tshirt" as initials
    And User selects " tshirt man"
    Then Search results page for "tshirt man" appears
    And Checks if the SKU value for all the resulted product starts with "M"

    Examples: 
      | name   |
      | Tshirt |
