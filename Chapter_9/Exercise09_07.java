/**
 * Author: Charles T. Carter
 * Date: 08/28/2024
 *
 *
 * This program use a class called 'Account' that can create a savings Account object,
 * the class contains methods for modifiying or getting specific info from these objects like withdraw, deposit, displaying date created, etc.
 * 
 * The test program creates an instance of this class and shows the balance, the monthly interest, and the date the account was created.
 */



import java.util.Date;
//Test Program
public class Exercise09_07 {
    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000);
        account1.setAnnualInterestRate(0.045);
        account1.withdraw(2500);
        account1.deposit(3000);

        System.out.printf("Balance for account %d: $%.2f\n" , account1.getId() , account1.getBalance());
        System.out.printf("Monthly interest: $%.2f\n" , account1.getMonthlyInterest());
        System.out.println("Date Created: " + account1.getDateCreated());


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
