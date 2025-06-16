package service;

public interface BankingService {
    void withdraw(Double cash);
    void deposit(Double cash) throws IllegalAccessException;
    void showBalance();
}


