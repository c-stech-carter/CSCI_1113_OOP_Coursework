/**
 * Author: Charles T. Carter
 * Date: 9/19/2024
 *
 * This program is intended to test using interfaces.   The program creates some GeometricObject
 * objects and initializes them as Triangle objects.
 *
 * It displays Triangles in order, and their area.
 * Additionally, it also displays the howToColor() method from the Colorable interface that is implemented
 * in the Triangle class to display how to color the object.   In this case there are only Triangles
 * but if other objects existed it could be implemented further.
 */


import java.util.Date;

public class Interfaces_RealWorld {
    public static void main(String[] args) {

        //Creating the GeometricObjects as Triangles
        GeometricObject[] shapeArray = new GeometricObject[5];
        shapeArray[0] = new Triangle(3.5, 2.5, 3);
        shapeArray[1] = new Triangle(3, 3, 3, "blue", false);
        shapeArray[2] = new Triangle(5, 5, 5, "red", true);
        shapeArray[3] = new Triangle(3, 3, 3, "green", false);
        shapeArray[4] = new Triangle(7, 8, 7, "yellow", true);


        //Loop for displaying the objects
        for (int i = 0; i < shapeArray.length; i++) {
            if (shapeArray[i] instanceof Triangle) {
                System.out.println("Triangle " + (i + 1) + ": ");
                System.out.printf("\tArea: %.5f\n" , shapeArray[i].getArea());
            }

            if (shapeArray[i] instanceof Colorable) {
                System.out.print("\tHow to color: ");
                ((Colorable) shapeArray[i]).howToColor();
                System.out.println();
            }
        }

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
class Triangle extends GeometricObject implements Colorable{

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


    //howToColor() method for Triangles
    @Override
    public void howToColor() {
        System.out.print("Color all three sides.");
    }
}


//Colorable interface
interface Colorable {
    public void howToColor();
}