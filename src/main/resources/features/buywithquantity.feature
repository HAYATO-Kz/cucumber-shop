Feature: Buy products with quantity
    As a owner
    I want the inventory to be duducted accordingly


Background:
    Given a product Bread with quantity 10.00 and price 20.50  exists
    And a product Jam with quantity 10.00 and price 80.00 exists
    And a product Butter with quantity 10.00 and price 100.00 exists
    And a product Milk with quantity 10.00 and price 20.00 exists

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then Bread quantity should be 8.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then Bread quantity should be 8.00
    And Jam quantity should be 9.00