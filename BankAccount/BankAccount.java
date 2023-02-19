package BankAccount;

import Reader.Reader;

import java.util.Scanner;


public class BankAccount {
    final String owner;
    final private int number;
    private double credit;
    private static int accountCount = 0;
    Reader reader = new Reader();

    public BankAccount(String name) {
        this.number = ++BankAccount.accountCount;
        this.credit = 0;
        this.owner = name;
//        Scanner scanner;
    }

    public double getCredit() {
        return this.credit;
    }

    public void setCredit(double credit) {
        if (credit < 0) return;
        this.credit = credit;
    }

    public int getNumber() {
        return this.number;
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
        System.out.println("enter the amount of money you want to withdrawal \n");
        double amount = reader.getDouble();
        if (amount < 0 || this.credit < amount) return 0;
        return this.addToCredit(-amount).credit;

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
        System.out.println("enter the amount of money you want to deposit \n");
        double amount = reader.getDouble();
        if (amount < 0) return;
        this.addToCredit(amount);
    }

    public void accountMenu() {


        while (true) {
            System.out.println("Please choose one of the options : 1:deposit 2:withdrawal  3:check 4:exit");
            int choice = reader.getInteger();
//        System.out.println(choice);
            switch (choice) {
                case 1:
                    this.deposit();
                    break;
                case 2:
                    this.withdrawal();
                    break;
                case 3:
                    System.out.println(this.toString());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("your choice doesn't exists");
            }
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' + " " +
                "number='" + number + '\'' + " " +
                "credit='" + credit + '\'' + " " +
                '}';
    }
}
