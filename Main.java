import Bank.Bank;
import BankAccount.BankAccount;

public class Main {
        public static void main(String[] args) {
                // Bank bmce = new Bank("bmce");
                // bmce.createAccount("adam");
                // bmce.createAccount("adam");
                // bmce.createAccount("hamid");
                // bmce.createAccount("khalid");
                // get a user account by his name
                // BankAccount adamAccount = (BankAccount) bmce.getBankAccountByName("adam");
                // BankAccount hamid = (BankAccount) bmce.getBankAccountById(3);
                // bmce.BankMenu();
                // System.out.println(adamAccount.getId());

                // adamJemmyAccount.accountMenu();
                // BankAccount adamAccount = (BankAccount) bmce.getBankAccountByName("adam");
                // adamAccount.deposit(50);
                // adamAccount.accountMenu();
                // adam will send jemmy 20 dollars
                // if (bmce.send(adamAccount, adamJemmyAccount, 20)) {
                // System.out.println("success");
                // } else {
                // System.out.println("fail");
                // }

                // System.out.println(adamAccount.getCredit());//30
                // System.out.println(adamJemmyAccount.getCredit());//20
                // System.out.println(bmce);// print all accounts
                // bank menu
                // bmce.BankMenu();
                // compte menu
                // ((BankAccount) bmce.getBankAccountByName("adam")).accountMenu();
                Bank cih = new Bank("cih");
                cih.createAccount();
                cih.createAccount("adam");
                cih.createAccount("khalid", "noraml");
                cih.createAccount("amin", "courant");
                cih.createAccount("ahmed", "epargne");
                System.out.println(cih);

        }
}
