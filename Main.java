import Bank.Bank;
import BankAccount.BankAccount;

public class Main {
    public static void main(String[] args) {
        Bank bmce = new Bank("bmce");
        bmce.createAccount("adam jemmy");
        bmce.createAccount("adam");
//        get a user account by his name
        BankAccount adamJemmyAccount = (BankAccount) bmce.getBankAccountByName("adam jemmy");
//        adamJemmyAccount.accountMenu();
        BankAccount adamAccount = (BankAccount) bmce.getBankAccountByName("adam");
        adamAccount.deposit(50);
//        adamAccount.accountMenu();
//        adam will send jemmy 20 dollars
//        if (bmce.send(adamAccount, adamJemmyAccount, 20)) {
//            System.out.println("success");
//        } else {
//            System.out.println("fail");
//        }

//        System.out.println(adamAccount.getCredit());//30
//        System.out.println(adamJemmyAccount.getCredit());//20
//        System.out.println(bmce);// print all accounts
//        bank menu
        bmce.BankMenu();
//        compte menu
//        ((BankAccount) bmce.getBankAccountByName("adam")).accountMenu();

    }
}
