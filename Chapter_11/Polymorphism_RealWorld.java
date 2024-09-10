/**
 * Author: Charles T. Carter
 * Date: 09/09/2024
 *
 * This program contains classes that can be used to simulate Accounts, as well as specific
 * Accounts as Checking Accounts, and Savings Accounts and has a test class to create these objects.
 */

import java.util.Scanner;
import java.util.Date;


//Test class with title of Assignment
public class Polymorphism_RealWorld {
    public static void main(String[] args) {

        //Creating objects
        Account account1 = new Account(2, 300.0, 4.5);
        CheckingAccount checkingAccount1 = new CheckingAccount(11, 300.0, 0.0);
        SavingsAccount savingsAccount1 = new SavingsAccount(12, 600.0, 6.2);


        //Calling toString methods for each object
        System.out.println(account1.toString() + "\n");
        System.out.println(checkingAccount1.toString() + "\n");
        System.out.println(savingsAccount1.toString() + "\n");
    }



}


//'Account' Class
class Account {
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated = new Date();

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }

    public void setId(int userId){
        id = userId;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double userBalance){
        balance = userBalance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double userAnnualInterestRate){
        annualInterestRate = userAnnualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }


    //toString() method for Standard Account
    public String toString() {
        return "Standard Account, ID: " + getId() + ", Balance: $" + getBalance() +
               ",\n Annual Interest Rate: %" + getAnnualInterestRate() +
               ", Date Created: " + getDateCreated();
    }
}


//SavingsAccount Class - subclass of 'Account'
class SavingsAccount extends Account {
    public SavingsAccount(int userId, double userBalance, double annualInterestRate) {
        super(userId, userBalance, annualInterestRate);
    }

    //Withdraw method for SavingsAccount
    @Override
    public void withdraw(double amount){
        if(amount > getBalance()) {
            System.out.println("Insufficient balance");
        }
        else {
            super.withdraw(amount);
        }
    }


    //toString() method for SavingsAccount
    @Override
    public String toString() {
        return "Savings Account, ID: " + getId() + ", Balance: $" + getBalance() +
               ",\n Annual Interest Rate: %" + getAnnualInterestRate() +
               ", Date Created: " + getDateCreated();
    }
}




//CheckingAccount Class, subclass of 'Account'
class CheckingAccount extends Account {
    private final double OVERDRAFT_LIMIT = 100.0; //Fixed overdraft limit

    public CheckingAccount(int userId, double userBalance, double annualInterestRate) {
        super(userId, userBalance, annualInterestRate); // Call the constructor of the superclass (Account)
    }

    public double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }


    //Withdraw method for CheckingAccount, this allows an overdraft
    @Override
    public void withdraw(double amount) {
        if(amount > getBalance() + OVERDRAFT_LIMIT) {
            System.out.println("Overdraft denied, exceed overdraft limit.");
        } else {
            super.withdraw(amount);
            if (getBalance() < 0) {
                System.out.println("Account is overdrawn, current balance: " + getBalance());
            }
        }
    }

    //toString() method for CheckingAccount
    @Override
    public String toString() {
        return "Checking Account, ID: " + getId() + ", Balance: $" + getBalance() +
               ",\n Overdraft Limit: $" + getOverdraftLimit() + ", Annual Interest Rate: %" + getAnnualInterestRate() +
               ", Date Created: " + getDateCreated();
    }
}