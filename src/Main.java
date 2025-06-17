import exception.WithDrawException;
import model.ATM;
import model.CreditCardAccount;
import model.SavingAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select account type: ");
        System.out.println("1. Saving Account");
        System.out.println("2. Credit Card Account");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            SavingAccount savingAccount = new SavingAccount();

            System.out.print("Enter Saving Account Name: ");
            savingAccount.setAccountName(scanner.nextLine());

            System.out.print("Enter amount to deposit: ");
            savingAccount.deposit(scanner.nextDouble());

            System.out.print("Enter amount to withdraw: ");
            try {
                savingAccount.withdraw(scanner.nextDouble());
            } catch (WithDrawException e) {
                System.out.println(e.getMessage());
            }

            savingAccount.showBalance();
            savingAccount.getAccountName();
            // ATM
            scanner.close();
            ATM atm = new ATM(savingAccount);
            atm.withdraw(50d);
            atm.showBalance();

        } else if (choice == 2) {
            CreditCardAccount creditCardAccount = new CreditCardAccount();

            System.out.print("Enter Credit Card Account Name: ");
            creditCardAccount.setAccountName(scanner.nextLine());

            System.out.print("Enter amount to deposit: ");
            creditCardAccount.deposit(scanner.nextDouble());

            System.out.print("Enter amount to withdraw: ");
            try {
                creditCardAccount.withdraw(scanner.nextDouble());
            } catch (WithDrawException e) {
                System.out.println(e.getMessage());
            }

            creditCardAccount.showDetails();
        } else {
            System.out.println("Invalid choice. Please run the program again.");
        }


    }


}
