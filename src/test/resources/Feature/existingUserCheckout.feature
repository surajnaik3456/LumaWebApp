@ExistingUserCheckout @Regression
Feature: Verify existing user checkout functionality

  Background: 
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header sign-in link
    And "Customer Login" page is displayed
    When User enters the email address "Test121@yopmail.com" and password "Test12345"
    And User clicks on the sign-in button
    Then User should be logged in

  @ExistingUserCheckoutFlow
  Scenario Outline: Verify existing user is able to checkout or not
    When User clicks on shop new yoga button
    Then the "New Luma Yoga Collection" page is displayed
    And Click on the required <yogaPant>
    And the required <yogaPant> page is displayed
    And Select <size> and <colour>
    And Click on Add to card button
    Then button text changes to Added
    And User should scroll to the top
    And Click on cart
    And Click on proceed to checkout button
    Then checkout page is displayed
    And Click on add new address
    And the shipping address pop-up appears
    And user fills in all the parameters <company>,<streetAddress>,<city>,<state>,<zip>,<country> and <phoneNumber>
    And Click on ship here
    And Select a <shipping> method
    When Clicked on next button
    Then "Payment Method" page is getting displayed
    And click on place order
    And "Thank you for your purchase!" screen should be displayed with the order number

    Examples: 
      | yogaPant                   | size | colour | company                       | streetAddress                           | city     | state    | zip   | country   | phoneNumber | shipping |
      | Gwen Drawstring Bike Short |   29 | Orange | Teknotrait solutions Pvt. Ltd | Linwood Boulevard Kansas City Missouri) | Missouri | Victoria | 12345 | Australia |  9732123456 | Fixed    |
