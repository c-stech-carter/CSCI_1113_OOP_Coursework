/**
 * Author: Charles T. Carter
 * Date: 08/22/2024
 * 
 * This program displays a list of feet to meters, and meters to feet; it uses the class "Convert" to provide methods used in the main class.
 */


class Convert {

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return meter * 3.279;
    }

}

public class Exercise06_09 {
    public static void main(String[] args) {
         // Print header
         System.out.printf("%-10s%-15s%-10s%-15s%n", "Feet", "Meters", "Meters", "Feet");
         System.out.println("--------------------------------------------");
        
        
        double currentFoot = 1.0;
        double currentMeter = 20.0;
        for (int i = 0; i < 10; i++) {
            //Print Feet to Meters section
            System.out.printf("%-10.1f%-15.3f", currentFoot, Convert.footToMeter(currentFoot));
            //Print Meters to feet section
            System.out.printf("%-10.1f%-15.3f%n", currentMeter, Convert.meterToFoot(currentMeter));
            currentFoot += 1.0;
            currentMeter += 5.0;
        }
    }
    
}
