package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(input);
            System.out.println();

            if (choice == 1){
                accounts[numAccounts++] = createAccount(input);
            }else if(choice ==2 ){
                doDepsiot(accounts, numAccounts , input);
            }else if (choice == 3){
                doWithdraw(accounts, numAccounts , input);
            }else if (choice == 4){
                applyInterest(accounts, numAccounts , input);
            }else {
                System.out.println("Bye Bye!!");
            }

            System.out.println();
        }while (choice != 5);
    }

    public static int accountMenu(Scanner input) {
        System.out.println("Select account type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter a choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account account[], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (account[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void doDepsiot(Account accounts[], int count, Scanner input) {
        System.out.print("Please enter account number: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            System.out.print("Please enter deposit amount: ");
            double amout = input.nextDouble();

            accounts[index].deposit(amout);
        }else {
            System.out.print("Account doesn't exist with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts[] , int count , Scanner input){
        System.out.print("Please enter account number: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            System.out.print("Please enter Withdraw amount: ");
            double amout = input.nextDouble();

            accounts[index].withdraw(amout);
        }else {
            System.out.print("Account doesn't exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts[] , int count , Scanner input){
        System.out.print("Please enter account number: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            System.out.print("Please enter Withdraw amount: ");
            double amout = input.nextDouble();
            if (accounts[index] instanceof SavingsAccount){
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        }else {
            System.out.print("Account doesn't exist with AccountNumber: " + accountNumber);
        }
    }

    public static Account createAccount(Scanner input) {

        Account account = null;
        int choice = accountMenu(input);

        int accountNumber;
        System.out.print("Enter account: ");
        accountNumber = input.nextInt();
        if (choice == 1) {
            System.out.println("Enter tracaction fee: ");
            double fee = input.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.print("Please enter Interest Rate: ");
            double interestRate = input.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);
        }
        return account;
    }

    public static int menu(Scanner input) {
        System.out.println("Bank Account Menu: ");
        System.out.println("1. Create New Account: ");
        System.out.println("2. Deposit funds: ");
        System.out.println("3. Withdraw Funds: ");
        System.out.println("4. Apply interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter a choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 5);

        return choice;
    }
}
