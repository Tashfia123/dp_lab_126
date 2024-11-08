import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> allItems = new ArrayList<>();

        System.out.println("Welcome to the E-Commerce Platform");


        boolean addingItems = true;

        while (addingItems) {
            System.out.println("Would you like to add a Simple Product or a Bundle? (Enter 'product' or 'bundle', or 'exit' to finish): ");
            String itemType = scanner.nextLine().trim().toLowerCase();

            if (itemType.equals("product")) {
                Product product = createProduct(scanner);
                allItems.add(product);
            } else if (itemType.equals("bundle")) {
                Bundle bundle = createBundle(scanner, allItems);
                allItems.add(bundle);
            } else if (itemType.equals("exit")) {
                addingItems = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }


        displayAllProducts(allItems);
        scanner.close();
    }


    private static Product createProduct(Scanner scanner) {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        System.out.println("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new SimpleProduct(name, description, price);
    }


    private static Bundle createBundle(Scanner scanner, List<Product> availableItems) {
        System.out.println("Enter bundle name: ");
        String name = scanner.nextLine();

        System.out.println("Enter bundle description: ");
        String description = scanner.nextLine();

        System.out.println("Enter bundle discount (as a percentage): ");
        double discount = Double.parseDouble(scanner.nextLine());

        Bundle bundle = new Bundle(name, description, discount);

        boolean addingToBundle = true;
        while (addingToBundle) {
            System.out.println("Would you like to add an existing item to the bundle? (yes/no): ");
            String addItem = scanner.nextLine().trim().toLowerCase();

            if (addItem.equals("yes")) {

                for (int i = 0; i < availableItems.size(); i++) {
                    System.out.println(i + 1 + ". " + availableItems.get(i).getDetails());
                }
                System.out.println("Select the item number to add to the bundle: ");
                int selectedItem = Integer.parseInt(scanner.nextLine()) - 1;

                if (selectedItem >= 0 && selectedItem < availableItems.size()) {
                    bundle.addItem(availableItems.get(selectedItem));
                } else {
                    System.out.println("Invalid item number. Please try again.");
                }
            } else {
                addingToBundle = false;
            }
        }

        return bundle;
    }


    public static void displayAllProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getDetails());
        }
    }
}