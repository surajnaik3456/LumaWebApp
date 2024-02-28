@NewUserCheckout @Regression
Feature: Verify new user checkout functionality

  @NewUserCheckoutFlow
  Scenario Outline: Verify new user is able to checkout or not
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header create an account link
    And Create New Customer Account page is displayed
    When User enters the <firstname>,<lastname>,<email>,<password> and <confirmPassword>
    And User clicks on the create account button
    Then "Thank you for registering with Main Website Store." shows up
    And User clicks on Luma logo
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
    And user fills in all the parameters <company>,<streetAddress>,<city>,<state>,<zip>,<country> and <phoneNumber>
    And Select a <shipping> method
    When Clicked on next button
    Then "Payment Method" page is getting displayed
    And click on place order
    And "Thank you for your purchase!" screen should be displayed with the order number

    Examples: 
      | firstname | lastname | email                  | password  | confirmPassword | yogaPant                   | size | colour | company                       | streetAddress                          | city     | state   | zip   | country       | phoneNumber | shipping |
      | Tester    | s        | Testers1213@yopmail.com | Test12345 | Test12345       | Ida Workout Parachute Pant |   29 | Black  | Teknotrait solutions Pvt. Ltd | Linwood Boulevard Kansas City Missouri | Missouri | Arizona | 12345 | United States |  9732123456 | Fixed    |
