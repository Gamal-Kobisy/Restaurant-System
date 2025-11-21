import factories.*;
import menu.*;
import order.*;
import observers.*;
import payment.*;
import discount.*;
import decorator.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to the Restaurant System ===");

        // --- Step 1: Choose menu type ---
        MenuFactory factory = null;
        boolean nonVegan = false; // flag to remember if Non-Veg was chosen
        while (factory == null) {
            System.out.println("Select menu type:");
            System.out.println("1. Vegan Menu");
            System.out.println("2. Non-Veg Menu");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    factory = new VeganMenuFactory();
                    nonVegan = false;
                }
                case "2" -> {
                    factory = new NonVegMenuFactory();
                    nonVegan = true;
                }
                default -> System.out.println("❌ Invalid choice. Enter 1 or 2.");
            }
        }

        // --- Step 2: Get RestaurantSystem singleton ---
        RestaurantSystem restaurant = RestaurantSystem.getInstance(factory);
        Menu menu = factory.createMenu();

        // --- Step 3: Add observers (Kitchen, etc.) ---
        OrderNotifier notifier = restaurant.getNotifier();
        notifier.attach(new Kitchen());
        notifier.attach(new Waiter());

        // --- Step 4: Create new order ---
        Order order = restaurant.createOrder();

        // --- Step 5: Display menu ---
        menu.showMenu();

        boolean addingItems = true;
        boolean takeChicken = false;
        while (addingItems) {
            // --- Step 6: Select menu item ---
            System.out.print("\nEnter item number to add (0 to finish): ");
            int itemNumber;
            try {
                itemNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Try again.");
                continue;
            }

            if (itemNumber == 0) {
                addingItems = false;
                break;
            }

            MenuItem selectedItem = menu.getItem(itemNumber - 1);
            if (selectedItem == null) {
                System.out.println("❌ Invalid item number. Try again.");
                continue;
            }
            if(itemNumber == 1 && nonVegan) {
                takeChicken = true;
            }
            // --- Step 7: Select quantity ---
            int qty = 0;
            while (qty <= 0) {
                System.out.print("Enter quantity: ");
                try {
                    qty = Integer.parseInt(scanner.nextLine());
                    if (qty <= 0) System.out.println("❌ Quantity must be > 0.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid number. Try again.");
                }
            }

            // --- Step 8: Optionally add add-ons (decorators) ---
            boolean addingAddons = true;
            MenuItem finalItem = selectedItem;
            while (addingAddons) {
                System.out.println("Add-ons (optional):");
                System.out.println("1. Extra Cheese (+$2)");
                System.out.println("2. Extra Sauce (+$1)");
                System.out.println("3. No more add-ons");
                System.out.print("Your choice: ");
                String addonChoice = scanner.nextLine();
                switch (addonChoice) {
                    case "1" -> finalItem = new ExtraCheese(finalItem);
                    case "2" -> finalItem = new ExtraSauce(finalItem);
                    case "3" -> addingAddons = false;
                    default -> System.out.println("❌ Invalid choice. Try again.");
                }
            }

            // --- Step 9: Add to order ---
            OrderItem orderItem = new OrderItem(finalItem, qty);
            order.addItem(orderItem);
            System.out.println("✅ Added " + qty + " x " + finalItem.getName());
        }

        // --- Step 10: Show order summary ---
        System.out.println("\n--- Your Order ---");
        order.showOrderItems();

        // --- Step 11: Choose payment method ---
        PaymentStrategy payment = null;
        while (payment == null) {
            System.out.println("\nSelect payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.print("Your choice: ");
            String payChoice = scanner.nextLine();
            switch (payChoice) {
                case "1" -> payment = new CashPayment();
                case "2" -> payment = new CreditCardPayment();
                default -> System.out.println("❌ Invalid choice. Enter 1 or 2.");
            }
        }

        // --- Step 12: Optional discount ---
        DiscountStrategy discount = null;
        if(takeChicken){
            discount = new ChickenDiscount();
        }

        // --- Step 13: Checkout ---
        restaurant.checkout(order, payment, discount);

        System.out.println("\n✅ Thank you for visiting!");
    }
}
