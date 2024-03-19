@CheckSearchFunctionality @Regression
Feature: Verify search products functionality

  @CheckProductSearch
  Scenario Outline: Verify user is able to search a product by entering keywords in the search bar
    Given User is logged in with email "Tester0001@yopmail.com" and password "Test12345"
    When User clicks on search bar
    And Enter required product <name>
    Then Suggestions appears with <name> as initials
    And User selects " tshirt man"
    Then Search results page for "tshirt man" appears
    And Checks if the SKU value for all the resulted product starts with "M"

    Examples: 
      | name   |
      | tshirt |
