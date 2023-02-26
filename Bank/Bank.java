package Bank;

import BankAccount.BankAccount;
import Reader.Reader;

import java.util.ArrayList;
import java.util.Iterator;
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
            Object[] result = accounts.stream().filter((acc) -> acc.getOwner() == name).toArray();
            if (result.length == 1)
                return result[0];

            System.out.println("choose one account by number ");
            for (Object account : result) {
                System.out.println((BankAccount) account);

            }
            int id = reader.getInteger();
            return accounts.stream().filter((acc) -> acc.getId() == id).toArray()[0];
        } catch (Exception e) {
            System.out.println("Attention requise. Un nouveau compte a été créé !!");
            return new BankAccount(name);
        }
    }

    private Object getBankAccountByIdHandler(int id) {
        return (Object) accounts.stream().filter((acc) -> acc.getId() == id).toArray()[0];
    }

    public Object getBankAccountById(int id) {
        return this.getBankAccountByIdHandler(id);
    }

    public Object getBankAccountById() {
        System.out.println("enter the user id ");
        int id = reader.getInteger();
        return this.getBankAccountByIdHandler(id);
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
        if (bs.getCredit() < amount)
            return false;
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

    public int yNumber() {
        return this.accounts.size();
    }

    public String toString() {
        accounts.forEach((account) -> System.out.println(account));
        return "";
    }

    public void BankMenu() {
        while (true) {
            System.out.println(
                    "Veuillez choisir l’une des options:\n 1:creer compte 2:lister les compte  3:rechercher un compte par nom  4:rechercher un compte par id 5:quitter");
            int choice = reader.getInteger();
            // System.out.println(choice);
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
                    ((BankAccount) getBankAccountById()).accountMenu();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("votre choix n'existe pas");
            }
        }
    }

}
