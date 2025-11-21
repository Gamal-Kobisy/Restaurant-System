package payment;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void payment(double amount) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Total amount due: $%.2f%n", amount);

        String cardNumber = "";
        String cardHolder = "";
        String expiryDate = "";
        String cvv = "";

        // ✅ Card Number Input (16 digits)
        while (true) {
            System.out.print("Enter card number (16 digits): ");
            cardNumber = scanner.nextLine().replaceAll("\\s+", "");
            if (cardNumber.matches("\\d{16}")) break;
            System.out.println("❌ Invalid card number. Must be 16 digits.");
        }

        // ✅ Card Holder Name
        while (true) {
            System.out.print("Enter card holder name: ");
            cardHolder = scanner.nextLine().trim();
            if (!cardHolder.isEmpty()) break;
            System.out.println("❌ Name cannot be empty.");
        }

        // ✅ Expiry Date (MM/YY)
        while (true) {
            System.out.print("Enter expiry date (MM/YY): ");
            expiryDate = scanner.nextLine().trim();
            if (expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) break;
            System.out.println("❌ Invalid expiry date. Format must be MM/YY.");
        }

        // ✅ CVV (3 digits)
        while (true) {
            System.out.print("Enter CVV (3 digits): ");
            cvv = scanner.nextLine().trim();
            if (cvv.matches("\\d{3}")) break;
            System.out.println("❌ Invalid CVV. Must be 3 digits.");
        }

        System.out.println("✅ Payment successful. Thank you!");
    }
}
