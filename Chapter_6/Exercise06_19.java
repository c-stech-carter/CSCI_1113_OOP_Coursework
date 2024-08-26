/**
 * Author: Charles Carter
 * Date: 8/22/2024
 * 
 * 
 * The main test program uses methods in the class 'Triangles' to calculate the validity of the sides of a triangle and to get the area. 
 */


import java.util.Scanner;

class Triangles {
    /** Return true if the sum of every two sides is greater than the third side.*/
    public static boolean isValid(double side1, double side2, double side3) {
        return  (side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side2 + side3 > side1);
    }

    /** Return the area of the triangle. */
    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s- side1) * (s - side2) * (s - side3));
    }
    
}

public class Exercise06_19 {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);

        double side1 = 0;
        double side2 = 0;
        double side3 = 0;
        
        boolean needValidInput = true;
        while(needValidInput) {
            System.out.print("Enter the lenght of the three sides of a triangle: ");
            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();

            if(!Triangles.isValid(side1, side2, side3)) {
                System.out.print("\nThat is not a valid triangle.\n\n");
            }
            else {
                needValidInput = false;
            }
        }

        System.out.print("\nSide 1: " + side1);
        System.out.print("\nSide 2: " + side2);
        System.out.print("\nSide 3: " + side3);
        System.out.printf("\nArea:   %.3f" , Triangles.area(side1, side2, side3));
    }
}
