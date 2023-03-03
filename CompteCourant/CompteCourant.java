package CompteCourant;

import BankAccount.BankAccount;
import Reader.Reader;

public class CompteCourant extends BankAccount {
    private double maxCredit;

    Reader reader = new Reader();

    public CompteCourant(String name) {
        super(name);
        System.out.println("vieller entrer le seuil");
        this.maxCredit = reader.getDouble();
    }

    @Override
    public String toString() {
        System.out.println("Compte courant avec taux d'intérêt" + this.maxCredit + "\n");
        return super.toString();
    }

    @Override
    public double withdrawal(double amount) {
        if (amount < 0 || this.credit + this.maxCredit < amount)
            return 0;

        this.addToCredit(-amount);

        return amount;
    }

    @Override
    public double withdrawal() {
        double amount = this.reader.getDouble();
        if (amount < 0 || this.credit + this.maxCredit < amount)
            return 0;

        this.addToCredit(-amount);

        return amount;
    }

}
