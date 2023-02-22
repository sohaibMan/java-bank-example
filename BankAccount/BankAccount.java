package BankAccount;

import Reader.Reader;

import java.util.Scanner;


public class BankAccount {
    final String owner;
    final private int id;
    private double credit;
    private static int accountCount = 0;
    Reader reader = new Reader();

    public BankAccount(String name) {
        this.id = ++BankAccount.accountCount;
        this.credit = 0;
        this.owner = name;
    }

    public double getCredit() {
        return this.credit;
    }

    public void setCredit(double credit) {
        if (credit < 0) return;
        this.credit = credit;
    }

    public int getId() {
        return this.id;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public String getOwner() {
        return this.owner;
    }

    public double withdrawal(double amount) {
        if (amount < 0 || this.credit < amount) return 0;
        this.addToCredit(-amount);
        return this.credit;
    }

    public double withdrawal() {
        System.out.println("entrez le montant que vous voulez retirer \n");
        double amount = reader.getDouble();
        if (amount < 0 || this.credit < amount) return 0;
        this.addToCredit(-amount);
        return amount;

    }

    private BankAccount addToCredit(double amount) {
        this.credit += amount;
        return this;
    }

    public void deposit(double amount) {
        if (amount < 0) return;
        this.addToCredit(amount);
    }

    public void deposit() {
        System.out.println("entrez le montant que vous voulez déposer \n");
        double amount = reader.getDouble();
        if (amount < 0) return;
        this.addToCredit(amount);
    }

    public boolean sendMoney(BankAccount b1, double amount) {
        if (this.credit < amount)return false;
        this.withdrawal(amount);
        b1.deposit(amount);
        return true;
    }

    public boolean sendMoney() {
        System.out.println("Entrez le montant que vous voulez envoyer. \n");
        double amount = reader.getDouble();
        System.out.println("Entrez l’ID du destinataire \n");
        int receiverId = reader.getInteger();
        if (this.credit < amount) return false;
        this.withdrawal(amount);
        return true;
        //        BankAccount b=getAccountByid(id);
        //        it should bring user account from the accounts and desposit from it
        //        receiver.deposit(amount);
    }

    public void accountMenu() {
        while (true) {
            System.out.println("Veuillez choisir l’une des options: \n 1:verser 2:retirer  3:consulter 4:virer 5:quitter");
            int choice = reader.getInteger();
//        System.out.println(choice);
            switch (choice) {
                case 1:
                    this.deposit();
                    break;
                case 2:
                    System.out.println("vous avez" + this.withdrawal() + "$ ");
                    break;
                case 3:
                    System.out.println(this.toString());
                    break;
                case 4:
                    if (this.sendMoney()) {
                        System.out.println("réussite des transactions");
                    } else {
                        System.out.println("transaction refusée");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("votre choix n’existe pas");
            }
        }
    }

    @Override
    public String toString() {
        return "compte bancaire{" +
                "propriétaire='" + owner + '\'' + " " +
                "id='" + id + '\'' + " " +
                "credit='" + credit + '\'' + " $ " +
                '}';
    }
}
