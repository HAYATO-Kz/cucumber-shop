package ku.shop;

public class Product {
    private double price;
    private String name;
    private double quantity;

    public Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getQuantity() { return quantity; }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }

    public void setQuantity(double quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.quantity -= quantity;
    }
}
