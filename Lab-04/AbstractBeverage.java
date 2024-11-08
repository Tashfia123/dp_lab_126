import java.util.*;

abstract class AbstractBeverage implements Beverage {
    private List<Condiment> condiments = new ArrayList<>();
    private String description;
    private double baseCost;

    public AbstractBeverage(String description, double baseCost) {
        this.description = description;
        this.baseCost = baseCost;
    }

    @Override
    public void addCondiment(Condiment condiment) {
        condiments.add(condiment);
    }

    @Override
    public String getDescription() {
        StringBuilder fullDescription = new StringBuilder(description);
        for (Condiment condiment : condiments) {
            fullDescription.append(", ").append(condiment.getName());
        }
        return fullDescription.toString();
    }

    @Override
    public double cost() {
        double totalCost = baseCost;
        for (Condiment condiment : condiments) {
            totalCost += condiment.getCost();
        }
        return totalCost;
    }
}