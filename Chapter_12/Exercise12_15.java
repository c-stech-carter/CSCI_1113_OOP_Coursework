/**
 * Author: Charles T. Carter
 * Date: 9/16/2024
 *
 * This program creates a text file containing 100 random integers, then reads
 * the numbers back into a List then displays them in increasing order in
 * the terminal.
 */



//import statements
import java.util.*;
import java.io.*;

public class Exercise12_15 {
    public static void main(String[] args) throws java.io.IOException {
        File file = new File("Exercise12_15.txt");


        //Doesn't run program if file already exists
        if (file.exists()) {
            System.out.println("File exists");
            System.exit(0);
        }


        //Creating Printwriter 'output' with the File object
        PrintWriter output = new PrintWriter(new FileWriter(file));
        Random random = new Random();



        for (int i=0, j = 0; i < 100; i++) {
            output.printf("%3d ",random.nextInt(101));
            j++;
            if (j %20 == 0) {
                output.println();
            }
        }

        output.close();


        //Create List for sorting input
        List<Integer> numbers = new ArrayList<Integer>();
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                numbers.add(input.nextInt());
            }
        }

        //Sort List
        Collections.sort(numbers);

        //Display sorted list
        System.out.println("Sorted Integers from file: ");

        int line = 0;
        for(int count: numbers) {
            if (line % 20 == 0){  //This is only included for ease of use in reading in the terminal.
                System.out.println();
            }
            System.out.printf("%3d ", count);
            line++;
        }
    }
}
