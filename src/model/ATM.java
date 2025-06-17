package model;

import service.BankingService;

public class ATM implements BankingService {
    private final Account account;
    public ATM(Account account){
        this.account = account;
    }
    @Override
    public void withdraw(Double cash) {
        account.withdraw(cash);
    }

    @Override
    public void deposit(Double cash) {
        try {
            account.deposit(cash);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showBalance() {
        account.showBalance();
    }
}
