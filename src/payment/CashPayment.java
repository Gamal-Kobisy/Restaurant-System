package payment;

import java.util.Scanner;

public class CashPayment implements PaymentStrategy {

    @Override
    public void payment(double amount) {
        Scanner scanner = new Scanner(System.in);
        double cashReceived = 0.0;




        // this is comment

        System.out.printf("Total amount due: $%.2f%n", amount);

        // ✅ Input validation loop
        while (true) {
            System.out.print("Enter cash amount given: ");
            try {
                cashReceived = Double.parseDouble(scanner.nextLine());
                if (cashReceived < amount) {
                    System.out.println("❌ Insufficient amount. Please enter at least $" + amount);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }

        double change = cashReceived - amount;
        System.out.printf("✅ Payment successful. Change: $%.2f%n", change);
    }
}
