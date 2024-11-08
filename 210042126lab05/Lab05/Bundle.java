import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Bundle extends ProductDecorator {
    private String name;
    private String description;
    private double discount;
    private List<Product> items = new ArrayList<>();

    public Bundle(String name, String description, double discount) {
        super(null); // We are decorating a list of items, not a single product.
        this.name = name;
        this.description = description;
        this.discount = discount;
    }

    public void addItem(Product item) {
        items.add(item);
    }
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Bundle: ").append(name)
                .append("\nDescription: ").append(description)
                .append("\nItems:\n");
        for (Product item : items) {
            details.append("  ").append(item.getDetails()).append("\n");
        }
        details.append("Total Price (after discount): $").append(getPrice()).append("\n");
        return details.toString();
    }
    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice * (1 - discount / 100); // Apply discount
    }
}