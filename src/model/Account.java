package model;
import exception.WithDrawException;
import service.BankingService;

public class Account implements BankingService {
    private String accountName = null;
    private double balance;

    @Override
    public void withdraw(Double cash) {
    }

    public Account() {
        super();
    }

    @Override
    public void deposit(Double cash) {

    }

    public void withdraw(double cash){
        if(cash<0 || cash>balance){
            throw new WithDrawException("លុយមិនគ្រប់គ្រាន់ក្នុងគនណី ឫបញ្ចូលលេខខុស");
        }
        balance -= cash;
        System.out.println("លុយដកបានសម្រេច");
    }

    public void showBalance(){
        System.out.println("=".repeat(30));
        System.out.println("Your balance is " + balance);
        System.out.println("=".repeat(30));
    }
    public void getAccountName(){
        System.out.println("Account Name: " + this.accountName);
    }
    public void setAccountName(String accountName){
        this.accountName = accountName;
    }
}
