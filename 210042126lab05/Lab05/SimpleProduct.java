class SimpleProduct implements Product {
    private String name;
    private String description;
    private double price;

    public SimpleProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDetails() {
        return "Product: " + name + "\nDescription: " + description + "\nPrice: $" + price + "\n";
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}