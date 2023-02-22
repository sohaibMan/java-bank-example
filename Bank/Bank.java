package Bank;

import BankAccount.BankAccount;
import Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<BankAccount> accounts = new ArrayList<BankAccount>();
    Reader reader = new Reader();
    String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }


    private Object getBankAccountByNameHandler(String name) {
        try {
            return accounts.stream().filter((acc) -> acc.getOwner() == name).toArray()[0];
        } catch (Exception e) {
            System.out.println("Attention requise. Un nouveau compte a été créé !!");
            return new BankAccount(name);
        }
    }

    /**
     * @param name
     * @return userAccount if exists , otherwise a new user Account with his name
     */
    public Object getBankAccountByName(String name) {
        return this.getBankAccountByNameHandler(name);
    }

    /**
     * @return userAccount if exists , otherwise a new user Account with his name
     */
    public Object getBankAccountByName() {
        System.out.println("Entrez le nom.");
        String name = reader.getString();
        return this.getBankAccountByNameHandler(name);
    }

    private void createAccountHandler(String name) {
        BankAccount account = new BankAccount(name);
        accounts.add(account);
    }

    public void createAccount(String name) {
        this.createAccountHandler(name);
    }

    public void createAccount() {
        System.out.println("Entrez le nom.");
        String name = reader.getString();
        this.createAccountHandler(name);
    }

    private boolean sendMoneyHandler(BankAccount bs, BankAccount br, Double amount) {
        if (bs.getCredit() < amount) return false;
        bs.withdrawal();
        br.deposit();
        return true;
    }

    public boolean sendMoney(BankAccount bs, BankAccount br, double amount) {
        return this.sendMoneyHandler(bs, br, amount);
    }

    public boolean sendMoney(BankAccount bs, BankAccount br) {
        System.out.println("Entrez le montant que vous voulez envoyer. ");
        double amount = reader.getDouble();
        return this.sendMoneyHandler(bs, br, amount);

    }

    public int getAccountNumber() {
        return this.accounts.size();
    }

    public String toString() {
        accounts.forEach((account) -> System.out.println(account));
        return "";
    }

    public void BankMenu() {
        while (true) {
            System.out.println("Veuillez choisir l’une des options:\n 1:creer compte 2:lister les compte  3:rechercher un compte par nom  4:quitter");
            int choice = reader.getInteger();
//        System.out.println(choice);
            switch (choice) {
                case 1:
                    this.createAccount();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                case 3:
                    System.out.println(this.getBankAccountByName());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("votre choix n’existe pas");
            }
        }
    }

}
