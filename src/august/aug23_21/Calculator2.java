/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 25-Aug-21
 *   Time: 10:21 PM
 *   File: Calculator2.java
 */

package august.aug23_21;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        String[] operations = {"", "addition", "subtraction", "multiply", "division"};
        // Scanner that will read the integer
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to John Doe Handy Calculator");

        while (true) {
            // show calculator options
            showOptions();
            int option = 0;
            // input for option
            do { // Loop until we have correct input
                try {
                    option = sc.nextInt();

                    break;

                } catch (final InputMismatchException e) {
                    System.out.println("You have entered an invalid choice, please re-enter your choice:");
                    sc.nextLine();
                    // discard non-float input
                    continue;
                    // keep looping until you found right one
                }
            } while (true);
            float myFloat1 = 0.0f;
            float myFloat2 = 0.0f;
            if (option <= 4) {
                System.out.println("Please enter two float number to " + operations[option] + " separated by space");

                // input for value 1 for operation
                do { // Loop until we have correct input
                    System.out.print("Enter two floats separated by a " +
                            "space: ");
                    try {
                        myFloat1 = sc.nextFloat();
                        // waits for user input
                        myFloat2 = sc.nextFloat();
                        // waits for user input
                        //if you are here, the floats were good, you
                        //are done, breadk out from loop
                        if (myFloat2 == 0.0 && operations[option].equalsIgnoreCase("division")) {
                            // if value 2 is 0.0 and operation is division
                            // again input for both values
                            System.out.println("You can't divide by 0.0 please re enter");
                            continue;
                        }
                        break;

                    } catch (final InputMismatchException e) {
                        System.out.println("You have " + "entered an invalid input. Try again.");
                        sc.nextLine();
                        // discard non-float input
                        continue;
                        // keep looping until you found right one
                    }
                } while (true);
                System.out.println("\nYou entered two valid floats: " + myFloat1 + " and " + myFloat2);
                System.out.println("Thank you for giving two floats");

            }
            // distinguish the option according to requirement
            switch (option) {
                case 1:
                    float result1 = myFloat1 + myFloat2;
                    System.out.print("Result of addition of " + myFloat1 + "  and " + myFloat2 + " is ");
                    System.out.printf("%.2f\n", result1);
                    break;
                case 2:
                    float result2 = myFloat1 - myFloat2;
                    System.out.print("Result of subtraction from " + myFloat1 + "  to " + myFloat2 + " is ");
                    System.out.printf("%.2f\n", result2);
                    break;
                case 3:
                    float result3 = myFloat1 * myFloat2;
                    System.out.print("Result of multiply of " + myFloat1 + "  and " + myFloat2 + " is ");
                    System.out.printf("%.2f\n", result3);
                    break;
                case 4:
                    float result4 = myFloat1 / myFloat2;
                    System.out.print("Result of division of " + myFloat1 + "  and " + myFloat2 + " is ");
                    System.out.printf("%.2f\n", result4);
                    break;
                case 5:
                    System.out.println("Thank you for using John Doe Handy Calculator");
                    System.exit(0);
                default:
                    System.out.println("please enter the correct input");
            }
            System.out.println("Press enter to continue");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // method to create show options
    public static void showOptions() {
        System.out.println("1. Addition \n" +
                "2. Subtraction \n" +
                "3. Multiplication \n" +
                "4. Division \n" +
                "5. Exit");
        System.out.println("What would you like to do?");
    }
}

