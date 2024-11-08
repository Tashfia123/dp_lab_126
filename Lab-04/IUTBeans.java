import java.util.*;

public class IUTBeans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Beverage beverage = null;

        Map<Integer, Beverage> beverageOptions = new HashMap<>();
        beverageOptions.put(1, new Espresso());
        beverageOptions.put(2, new Latte());
        beverageOptions.put(3, new Cappuccino());

        Map<Integer, Condiment> condimentOptions = new HashMap<>();
        condimentOptions.put(1, new Milk());
        condimentOptions.put(2, new Sugar());
        condimentOptions.put(3, new Cream());

        System.out.println("Choose a beverage:");
        System.out.println("1. Espresso (150 taka)");
        System.out.println("2. Latte (300 taka)");
        System.out.println("3. Cappuccino (100 taka)");
        int beverageChoice = scanner.nextInt();

        if (beverageOptions.containsKey(beverageChoice)) {
            beverage = beverageOptions.get(beverageChoice);
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        // Display the initial beverage cost
        System.out.printf("Base order: %s (Cost: %.2f taka)%n", beverage.getDescription(), beverage.cost());
        double totalCost = beverage.cost();

        while (true) {
            System.out.println("Choose a condiment to add (or type 0 to finish):");
            System.out.println("1. Milk (20 taka)");
            System.out.println("2. White Sugar (15 taka)");
            System.out.println("3. Whipped Cream (30 taka)");
            System.out.println("0. No more condiments / Skip");

            int condimentChoice = scanner.nextInt();

            if (condimentChoice == 0) {
                break;
            }

            Condiment selectedCondiment = condimentOptions.get(condimentChoice);
            if (selectedCondiment != null) {
                beverage.addCondiment(selectedCondiment);
                totalCost += selectedCondiment.getCost();
                System.out.printf("Added %s (+%.2f taka)%n", selectedCondiment.getName(), selectedCondiment.getCost());
                System.out.printf("Current order: %s (Total cost: %.2f taka)%n", beverage.getDescription(), totalCost);
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        System.out.println("Your final order: " + beverage.getDescription());
        System.out.printf("Total cost: %.2f taka%n", totalCost);

        scanner.close();
    }
}
