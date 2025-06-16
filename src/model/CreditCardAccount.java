package model;

import exception.WithDrawException;

public class CreditCardAccount extends Account {
    public double creditLimit;

    public CreditCardAccount() {
        super();
    }

    public CreditCardAccount(double creditLimit) {
        super();
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(Double cash) {
        double balance = getBalance();
        double totalAvailableAmount = balance + creditLimit;
        if (cash < 0 || cash > totalAvailableAmount) {
            throw new WithDrawException("ថវិការមិនគ្រប់គ្រាន់");
        }
        setBalance(balance - cash);
        System.out.println("ការដកលុយចេញពីគណនីក្រេឌីតកាតបានសម្រេច");
    }

    @Override
    public void deposit(Double cash) throws IllegalAccessException {
        if (cash < 0) {
            throw new IllegalAccessException("សូមបញ្ចូលលេខវិជ្ជមាន");
        }
        setBalance(getBalance() + cash);
        System.out.println("ការដាក់លុយចូលគណនីក្រេឌីតកាតបានសម្រេច");
    }

    public void showDetails() {
        System.out.println("=".repeat(30));
        System.out.println("Credit Card Account Name: " + getAccountName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Credit Limit: " + creditLimit);
        System.out.println("Available Funds: " + (getBalance() + creditLimit));
        System.out.println("=".repeat(30));
    }

    // Getter for balance using reflection
    private double getBalance() {
        try {
            java.lang.reflect.Field balanceField = Account.class.getDeclaredField("balance");
            balanceField.setAccessible(true);
            return balanceField.getDouble(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Setter for balance using reflection
    private void setBalance(double balance) {
        try {
            java.lang.reflect.Field balanceField = Account.class.getDeclaredField("balance");
            balanceField.setAccessible(true);
            balanceField.setDouble(this, balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getter for account name using reflection
    public String getAccountName() {
        try {
            java.lang.reflect.Field nameField = Account.class.getDeclaredField("accountName");
            nameField.setAccessible(true);
            return (String) nameField.get(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
