/**
 * Author: Charles T. Carter
 * Date: 9/16/2024
 *
 * This program creates a random array of 100 integers, then lets the user display
 * which number is in the index of their choice until the user decides to exit.
 *
 */



//Importing necessary utilities
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class HandlingExceptions_RealWorld {
    public static void main(String[] args) {

        //Creating an object with the array
        IntArray intArray = new IntArray(100);
        intArray.initialize();

        int[] array1 = intArray.getArray();  //passing the array from the object to a standard array variable

        System.out.println("This program has generated an array of 100 integers.");

        boolean continueInput = true;
        do {
            Scanner input = new Scanner(System.in);
            int index;
            System.out.print("Enter the index for the number you want to see in the array. " +
                    "Enter -1 to exit.\nInput:>");
            try {
                index = input.nextInt();
                if (index == -1) {
                    System.out.print("Exiting...");
                    System.exit(0);
                }
                System.out.println("The number at index " + index + " is " + array1[index]);

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of bounds. Please enter an index between 0 and 99.");
                input.nextLine();
            }
        } while (continueInput);






    }
}

class IntArray {
    private int[] array;
    private int indexSize;

    public IntArray() {
        this.indexSize = 100;
        array = new int[indexSize];
    }

    public IntArray(int indexSize) {
        this.indexSize = indexSize;
        array = new int[this.indexSize];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    //Initializing array method for object
    public void initialize() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }
}




