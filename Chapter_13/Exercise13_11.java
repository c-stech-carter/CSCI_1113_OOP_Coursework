/**
 * Author Charles T. Carter
 * Date: 09/23/2024
 *
 * This program creates Octagons by extending the GeometricObject class.   In addition,
 * it implements Clonable by cloning one Octagon into another, and Comparable to allow
 * basic comparing of the Area of the Octagons.
 */

import java.util.Date;

public class Exercise13_11 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon octagon1 = new Octagon(4);
        Octagon octagon2 = (Octagon)octagon1.clone();

        System.out.println("Two octagons have been created, 'Octagon1' & 'Octagon2'");
        System.out.println("Octagon1 has been cloned to Octagon2");
        System.out.println("Octagons compared: ");

        if (octagon1.compareTo(octagon2) == 1) {
            System.out.println("Octagon1 has greater area than Octagon2.");
        } else if(octagon1.compareTo(octagon2) == -1) {
            System.out.println("Octagon1 has less area than Octagon2.");
        } else if(octagon1.compareTo(octagon2) == 0) {
            System.out.println("The octagons have the same area.");
        } //This could be simply an 'else' statement and still work.  I just wanted to be precise.

        System.out.printf("Area of Octagon 1: %.5f\n" , octagon1.getArea());
        System.out.printf("Area of Octagon 2: %.5f" , octagon2.getArea());
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



//Octagon class
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side = 1;

    public Octagon() {
    }

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2 + 4/Math.sqrt(2)) * side * side;
    }
    public double getPerimeter() {
        return side * 8;
    }


    //compareTo method for comparing two Octagons
    @Override
    public int compareTo(Octagon o) {
        if (getArea() < o.getArea()) {
            return -1;
        } else if (getArea() > o.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }


    //method to clone an Octagon
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
