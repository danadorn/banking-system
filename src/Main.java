import exception.WithDrawException;
import model.CreditCardAccount;
import model.SavingAccount;

public class Main {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountName("My Saving Account Name");
        savingAccount.deposit(200D);
        try{
            savingAccount.withdraw(100D);
        }catch (WithDrawException exception) {
            System.out.println(exception.getMessage());
        }
        savingAccount.showBalance();
        savingAccount.getAccountName();


// credit card account
        CreditCardAccount creditCardAccount = new CreditCardAccount();
        creditCardAccount.setAccountName("My Credit Account Name");
        creditCardAccount.deposit(200D);
        creditCardAccount.showBalance();
    }
}