/**
 * Author: Charles Carter
 * Date: 08/29/2024
 *
 * This program uses the class 'Account' in its executable to simulate an ATM
 * and allows the user to make deposits and withdrawals if they have their account ID.
 * The program remains running until the session is forced to shut down by the person running the program.
 */


import java.util.Date;
import java.util.Scanner;

public class Exercise10_07 {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        Scanner input = new Scanner(System.in);

        //Initializing 10 accounts with $100 each
        for(int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i,100.0);
        }

        int numberId = -1;
        int choice = 0;
        double amount = 0;

        boolean running = true;
        //Main loop for program
        while(running) {
            while (true) {  //Getting valid input before going to displayOptions()
                System.out.print("Enter account number: ");
                numberId = input.nextInt();
                System.out.println();
                if (numberId < 0 || numberId > accounts.length) {
                    System.out.println("Invalid account number.\n");
                } else {
                    break;
                }
            }
            boolean inUserSession = true;
            //Secondary loop for when in-use by user
            while(inUserSession) {
                System.out.println("Main Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit\n\n");
                System.out.print("Enter choice: ");
                choice = input.nextInt();

                //Switch for choices
                switch (choice) {
                    case 1:
                        System.out.printf("Balance: $%.2f\n",accounts[numberId].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        amount = input.nextDouble();
                        accounts[numberId].withdraw(amount);
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        amount = input.nextDouble();
                        accounts[numberId].deposit(amount);
                        break;
                    case 4:
                        inUserSession = false;
                        break;
                    default: //simply restarts loop if user enters invalid choice
                        System.out.println("Invalid choice, please try again.\n");
                        break;
                }
            }
        }
    }

    private static void displayOptions(Account account) {

    }
}


//'Account' Class
class Account {
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated = new Date();

    Account() {
    }

    Account(int userId, double userBalance) {
        id = userId;
        balance = userBalance;
    }

    int getId(){
        return id;
    }

    void setId(int userId){
        id = userId;
    }

    double getBalance(){
        return balance;
    }

    void setBalance(double userBalance){
        balance = userBalance;
    }

    double getAnnualInterestRate(){
        return annualInterestRate;
    }

    void setAnnualInterestRate(double userAnnualInterestRate){
        annualInterestRate = userAnnualInterestRate;
    }

    Date getDateCreated() {
        return dateCreated;
    }

    double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    void withdraw(double amount){
        balance -= amount;
    }

    void deposit(double amount){
        balance += amount;
    }
}

