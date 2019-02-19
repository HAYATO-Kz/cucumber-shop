package ku.shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price,10);
    }

    @Given("a product (.+) with quantity (.+) and price (.+) exists")
    public void a_product_with_price_and_quantity_exists(String name, double quantity,double price) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quantity) {
        if(catalog.getQuantity(name)-quantity<0){
            assertThrows(IllegalArgumentException.class, () -> {
                Product prod = catalog.getProduct(name);
                order.addItem(prod, quantity);
                catalog.getProduct(name).setQuantity(quantity);
            });
            return;
        }
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
        catalog.getProduct(name).setQuantity(quantity);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("(.+) quantity should be (.+)")
    public void quantity_should_be(String name, double quantity) {
        assertEquals(quantity, catalog.getQuantity(name));
    }
}


