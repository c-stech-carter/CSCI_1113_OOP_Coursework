/**
 * Author Charles Carter
 * Date: 08/26/2024
 * 
 * 
 * 
 * This program uses a method in the class 'TestString' to determine the number of valid letters in a string.
 */

import java.util.Scanner;

class TestString {
    public static int countLetters(String s) {
        int letterCount = 0;
        for(int i = 0; i < s.length(); i ++){
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {  //Tests ASCII codes in the string for letters
                letterCount += 1;  //Adds a count if the character if found to be a letter
            }
        }

        return letterCount;
    }
}

public class Exercise06_20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = input.nextLine();
        System.out.printf("'%s' is %d characters long.", userString, userString.length());
        System.out.printf("\nThere are %d letters in '%s'", TestString.countLetters(userString), userString);  
    }
    
    
    
}
