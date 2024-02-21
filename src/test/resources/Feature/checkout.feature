@checkout
Feature: Verify user checkout functionality

  Background: 
    Given User is on the home page
    And the page title is "Home Page"
    And User clicks on the header sign-in link
    And "Customer Login" page is displayed
    When User enters the email address "surajnaik345@gmail.com" and password "Test12345"
    And User clicks on the sign-in button
    Then User should be logged in

  @CheckoutFlow
  Scenario Outline: Verify user is able to checkout or not
    When User clicks on shop new yoga button
    Then "New Luma Yoga Collection" page is displayed
    And Click on the required <yogaPant>
    And the required pant page is displayed
    And Select <size> and <colour>
    And Click on Add to card button
    Then button text changes to "Added"
    And User should scroll to the top
    And Click on cart
    And Click on proceed to checkout button
    Then checkout page is displayed
    And user fills in all the parameters <firstName>,<lastName>,<company>,<streetAddress>,<city>,<state>,<zip>,<country> and <phoneNumber>
    And Select a shipping method
    When Clicked on next button
    Then "Payment Method" page is displayed
    And click on place order
    And "Thank you for your purchase!" screen should be displayed with the order number

    Examples: 
      | yogaPant                   | size | colour | firstName | lastName | company                       | streetAddress                             | city     | state  | zip    | country       | phoneNumber |
      | Gwen Drawstring Bike Short |   29 | Orange | Suraj     | Naik     | Teknotrait solutions Pvt. Ltd | Linwood Boulevard (Kansas City, Missouri) | Missouri | Kansas | 143107 | United states |  9732123456 |
