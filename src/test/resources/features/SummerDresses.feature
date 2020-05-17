Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Should be asked to Sign In after summer dresses are added to the cart and checked out
    Given I am on home page
    When I hover on "Dresses" main menu
    And I click on "Summer Dresses" sub menu
    And I add first 3 summer dresses to cart
    And I click on view cart button
    And I proceed to checkout
    Then I should be asked to sign in


 
