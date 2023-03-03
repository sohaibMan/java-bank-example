package CompteEpargne;

import BankAccount.BankAccount;
import Reader.Reader;

public class CompteEpargne extends BankAccount {
    static final private double interestRate = -0.2;
    Reader reader = new Reader();

    public CompteEpargne(String name) {
        super(name);
        System.out.println("veuillez entrer le seuil");
    }

    @Override
    public String toString() {
        System.out.println("Compte courant avec taux epargne" + interestRate + "\n");
        return super.toString();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount + amount * interestRate);
    }

    @Override
    public void deposit() {
        System.out.println("entrez le montant que vous voulez déposer \n");
        double amount = reader.getDouble();
        this.deposit(amount + amount * interestRate);
    }

}
