Feature: Testing website

  @test1
  Scenario: Testing Test1 with parallel testing
    Given user navigates to tutorials ninja website and verify that the title is "Your Store"
    And user selects Laptops & Notebooks  From top menu
    And user selects Show All Laptops & Notebooks From dropdown menu
    And  user finds the Macbook item and click ADD TO CART
    And user clicks Cart Button and clicks View Cart From the top side
    When user clicks on Checkout button
    And  In Checkout Options user selects Guest Checkout and clicks Continue
    And  In Billing details user enters all mandatory fields and Continue
    And  user adds In Payment Method and adds a comment
    And  In Payment Method, user selects Agree radio button and Continue
    Then user Verify that "Warning: Payment method required!" and closes the browser