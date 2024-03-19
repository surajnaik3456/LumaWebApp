@CheckTrackOrders @Regression
Feature: Verify track order functionality

  @CheckTrackOrdersFlow
  Scenario Outline: Verify user is able to track their orders
    Given User is logged in with email "Tester0001@yopmail.com" and password "Test12345"
    When User clicks on shop new yoga button
    Then The "New Luma Yoga Collection" page is displayed
    And User clicks on the required <yogaPant>
    And The required <yogaPant> page is displayed
    And User selects <size> and <colour>
    And User clicks on Add to card button
    Then Button text changes to Added
    And User should scroll to the top
    And User clicks on cart
    And User clicks on proceed to checkout button
    Then Checkout page is displayed
    And User clicks on add new address
    And The shipping address pop-up appears
    And User fills in all the parameters <company>,<streetAddress>,<city>,<state>,<zip>,<country> and <phoneNumber>
    And User clicks on ship here
    When User clicks next button
    Then "Payment Method" page is getting displayed
    And User clicks on place order
    And "Thank you for your purchase!" screen should be displayed with the order number
    When user clicks on account menu
    And selects my account menu
    And my account page is displayed
    And click my orders button
    Then my orders page is displayed
    And User clicks on view order for the ordered number
    And Checks for the details are as expected

    Examples: 
      | yogaPant                   | size | colour | company                       | streetAddress                           | city     | state    | zip   | country   | phoneNumber |
      | Ida Workout Parachute Pant |   29 | Black  | Teknotrait solutions Pvt. Ltd | Linwood Boulevard Kansas City Missouri) | Missouri | Victoria | 12345 | Australia |  9732123456 |
