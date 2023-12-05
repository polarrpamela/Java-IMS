import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {

    private static Map<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addItem(sc);
                case 2 -> displayInventory();
                case 3 -> {
                    System.out.println("Exiting Inventory Management System.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String itemN = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (inventory.containsKey(itemN)) {
            int cQuantity = inventory.get(itemN);
            inventory.put(itemN, cQuantity + quantity);
        } else {
            inventory.put(itemN, quantity);
        }
        System.out.println("Item added to the inventory.");
    }

    private static void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
