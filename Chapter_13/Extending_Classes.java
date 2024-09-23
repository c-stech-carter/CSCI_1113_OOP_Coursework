import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 * Author: Charles T. Carter
 * Date: 9/18/2024
 *
 * This program uses the Triangle class which inherits the abstract GeometricObject class,
 * It lets the user create a triangle and choose its color, whether it is filled,
 * and then displays the area and the perimeter of the triangle.
 * It also displays the color and if the triangle is filled.
 */



//Test Program Class with assignment name
public class Extending_Classes {
    public static void main(String[] args) {
        double side1 = 0.0;
        double side2 = 0.0;
        double side3 = 0.0;
        Scanner input = new Scanner(System.in);


        //First loop to get valid input
        boolean getValidInput = true;
        while (getValidInput) {
            try {
                System.out.println("Enter three sides of a triangle separated by a space:");
                System.out.print("Input:>");
                side1 = input.nextDouble();
                side2 = input.nextDouble();
                side3 = input.nextDouble();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input, please try again");
                continue;
            }

            if (isValidTriangle(side1, side2, side3)) {
                getValidInput = false;
            }
            else {
                System.out.println("Invalid triangle, please try again.");
            }

        }
        input.nextLine();

        String colorChoice = "uncolored";
        boolean filledChoice = false;


        //Getting color from user
        System.out.println("What color is the triangle?  (Type your answer as a word):");
        System.out.print("Input:>");
        colorChoice = input.nextLine();


        //Second loop for valid input
        //Ideally in this block I would have the user type Yes or No, but to shorten the code it uses 'true' or 'false'
        getValidInput = true;
        while (getValidInput) {
            try {
                System.out.println("Is the triangle filled? (Type 'true' or 'false'):");
                System.out.print("Input:>");
                filledChoice = input.nextBoolean();
                getValidInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please type true or false in all lower case.");
                input.nextLine();
            }
        }

        Triangle triangle = new Triangle(side1, side2, side3, colorChoice, filledChoice);

        System.out.println("Your triangle has these properties: ");
        System.out.printf("Area: %.5f\n" , triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled() + "\n");

        System.out.print("It was created on "+ triangle.getDateCreated());



    }


    //Method for testing valid triangle
    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }
}


//GeometricObject Class
abstract class GeometricObject{
    private String color = "white";
    private boolean filled = false;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", Filled: " + filled + ", Date Created: " + dateCreated;
    }


    //Abstract method to get area
    public abstract double getArea();
    //Abstract method to get perimeter
    public abstract double getPerimeter();
}

//Triangle Class
class Triangle extends GeometricObject{

    //default attributes are set to 1 for each side of the triangle
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle(){

    }

    //Constructor for creating a triangle without specifying color and filled
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    //Constructor for triangle with complete attributes
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}
