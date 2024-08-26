/**
 * Author Charles Carter
 * Date: 08/26/2024
 * 
 * This program tests the validity of a password, the rules for the password are as follows:
 * 
 * A password must have at least eight characters.
 * A password must contain only letters and digits.
 * A password must contain at least two digits.
 * 
 * 
 */

import java.util.Scanner;

class TestPassword {
    public static boolean isValid(String s) {
        int letterCount = 0;
        int digitCount = 0;
        int invalidCharCount = 0;
        for(int i = 0; i < s.length(); i ++){
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {  //Tests ASCII codes in the string for letters
                letterCount += 1;  //Adds a count if the character if found to be a letter
            }
            else if ((s.charAt(i) >= 48 && s.charAt(i) <= 57)) {  //Tests ASCII codes in the string for numbers
                digitCount += 1;  //Adds a count if the character if found to be a letter
            }
            else {
                invalidCharCount += 1;  //default count for any invalid character (not a letter or digit)
            }
        }

        return ((letterCount + digitCount) > 8 && digitCount >= 2 && invalidCharCount == 0);  //Makes sure the requirements are met to return True
    }
}

public class Exercise06_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userString;

        boolean running = true;
        while (running) { //Runs until valid password entered
            System.out.print("Enter a password: ");
            userString = input.nextLine();
           
            if (TestPassword.isValid(userString)) {
                System.out.println("Valid Password");
                running = false;
            }
            else {
                System.out.println("Invalid Password\n");
            }
        }
    }
    
    
    
}
