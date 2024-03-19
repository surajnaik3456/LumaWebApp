@CheckProductFilter @Regression
Feature: Verify product filter functionality

  Background: 
    Given User is logged in with email "Tester0022@yopmail.com" and password "Test12345"

  @CheckProductFilterByCategory
  Scenario Outline: Verify the user is able to apply category filter
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And User selects category filter as <category>
    And Verifies if the category filter for <category> is applied correctly

    Examples: 
      | category   |
      | Electronic |

  @CheckProductFilterByColor
  Scenario Outline: Verify the user is able to apply color filter
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And User selects color filter as <Color>
    And Verifies if the category filter for <Color> is applied and is highlighted

    Examples: 
      | Color |
      | Black |

  @CheckProductFilterByPattern
  Scenario Outline: Verify the user is able to apply pattern filter
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And User selects pattern filter as <pattern>
    And Verifies if the pattern filter for <pattern> is applied correctly

    Examples: 
      | pattern |
      | Solid   |

  @CheckProductFilterByPrice
  Scenario Outline: Verify the user is able to apply price filter
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And Selects the price filter with <minPrice> and <maxPrice> range
    And Verifies if the price filter for <minPrice> and <maxPrice> is applied correctly

    Examples: 
      | minPrice | maxPrice |
      | $20.00   | $29.99   |

  @CheckCombinationOfFilters
  Scenario Outline: Verify the user is able to combine multiple filters
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And Selects filter by price range <minPrice> to <maxPrice>, <Color> and <pattern>
    And Verifies if the combination of filter for <minPrice> to <maxPrice>, <Color> and <pattern> is applied correctly

    Examples: 
      | minPrice | maxPrice | Color | pattern |
      | $20.00   | $29.99   | Blue  | Solid   |
