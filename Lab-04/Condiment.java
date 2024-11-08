public abstract class Condiment {
    private String name;
    private double cost;

    public Condiment(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}