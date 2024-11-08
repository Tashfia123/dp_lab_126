abstract class ProductDecorator implements Product {
    protected Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    public String getDetails() {
        return product.getDetails();
    }

    public double getPrice() {
        return product.getPrice();
    }
}