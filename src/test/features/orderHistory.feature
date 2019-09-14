
Feature: order history

    Scenario: verify t-shirts purchase in order history
    Given user is on the home page
      And navigate to t-shirts section
      And add an item to the cart
      And proceed to checkout
      When they make the payment
      And navigate to order history page
      Then purchased order details should be displayed



