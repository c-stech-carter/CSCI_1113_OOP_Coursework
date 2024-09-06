/**
 * Author: Charles T. Carter
 * Date: 9/5/2024
 *
 * Assignment: "Inheritance Real World"
 *
 * This program uses the superclass GeometricObject, and subclass Triangle, to
 * allow the user to create a Triangle, then displays properties of the triangle
 * according to the user's specifications provided.
 */


import java.util.Date;
import java.util.Scanner;

public class Inheritance_RealWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double side1, side2, side3;

        while(true) {  //Simple while loop to get valid triangle sides
            System.out.print("Enter 3 sides of a triangle in decimal format: ");

            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();

            if((side1 + side2 > side3) && (side2 + side3 > side1) &&
               (side3 + side1 > side2)) {
                break;
            }
            else {
                System.out.println("\nInvalid sides for a triangle, try again.");
            }
        }
        input.nextLine();

        System.out.print("Now type a color for the triangle: ");
        String userColor = input.nextLine();
        System.out.print("Is the triangle filled?  1 (Yes) or 2 (No): ");
        int userIntInput = input.nextInt();
        boolean userIsFilled = false;
        if(userIntInput == 1) {
            System.out.println("The triangle is filled.");
            userIsFilled = true;
        }
        else if(userIntInput == 2) {
            System.out.println("The triangle is *not* filled.");
            userIsFilled = false;
        }
        else {
            System.out.println("\nInvalid input. Exiting...");
            System.exit(1);
        }

        Triangle userTriangle = new Triangle(side1, side2, side3, userColor, userIsFilled);

        System.out.println("Your shape is as follows: \n" + userTriangle.toString());
        System.out.println("The area is: " + userTriangle.getArea());
        System.out.println("The perimeter is: " + userTriangle.getPerimeter());
        System.out.println("The color is: " + userTriangle.getColor());
        System.out.println("Status of the triangle being filled: " + userTriangle.isFilled());

    }
}


//GeometricObject Superclass
class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
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

    public String toString() {
        return "Color: " + color + ", Filled: " + filled + ", Date Created: " + dateCreated;
    }
}



//Triangle subclass of GeometricObject
class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() {

    }

    Triangle(double side1, double side2, double side3) {
        this(side1, side2, side3, "white", false);
    }

    Triangle(double side1, double side2, double side3, String color) {
        this(side1, side2, side3, color, false);
    }

    Triangle(double side1, double side2, double side3, String color, boolean filled) {
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

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 +
                ", created on " + super.getDateCreated();
    }
}
