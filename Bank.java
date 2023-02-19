import BankAccount.BankAccount;

import java.util.List;

public class Bank {
    List<BankAccount> accounts;
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    public void createAccount(String name) {
        BankAccount account = new BankAccount(name);
        accounts.add(account);
    }

    public void sendMoney(BankAccount bs, BankAccount br, double amount) {
        bs.withdrawal(amount);
        br.deposit(amount);
    }

    public void sendMoney(BankAccount bs, BankAccount br) {
        bs.withdrawal();
        br.deposit();
    }

    public int getAccountNumber() {
        return this.accounts.size();
    }

    public String toString() {
       BankAccount accounts[]= this.accounts.toArray();


        for(BankAccount acc : accounts){

        }


    }
}
