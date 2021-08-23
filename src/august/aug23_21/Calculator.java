/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 23-Aug-21
 *   Time: 12:05 PM
 *   File: Calculator.java
 */

package august.aug23_21;

import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String[] operations = {"", "addition", "subtraction", "multiply", "division"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to John Doe Handy Calculator");

        while (true) {
            // show calculator options
            showOptions();
            int option = 0;
            boolean repeat1 = true;
            // input for option
            while (repeat1) {
                try {
                    option = sc.nextInt();
                    repeat1 = false;
                } catch (Exception e) {
                    System.out.println("You have entered an invalid choice, please re-enter your choice:");
                    sc.next();
                    repeat1 = true;
                }
            }
            float val1 = 0.0f;
            float val2 = 0.0f;
            if (option <= 4) {
                System.out.println("Please enter two float number to " + operations[option] + " separated by space");

                // input for value 1 for operation
                boolean repeat2 = true;
                while (repeat2) {
                    try {
                        val1 = sc.nextFloat();
                        repeat2 = false;
                    } catch (Exception e) {
                        System.out.println("You have entered wrong format value");
                        sc.next();
                        repeat2 = true;
                    }
                }
                boolean repeat3 = true;
                // input for value 3 for operation
                while (repeat3) {

                    try {
                        val2 = sc.nextFloat();
                        repeat3 = false;
                    } catch (Exception e) {
                        System.out.println("You have entered wrong format value");
                        sc.next();
                        repeat3 = true;
                    }
                }
                // if value 2 is 0.0 and operation is division
                // again input for both values
                if (operations[option].equalsIgnoreCase("division") && val2 == 0.0) {
                    System.out.println("You have entered invalid floats please re -enter");
                    repeat2 = true;
                    while (repeat2) {
                        try {
                            val1 = sc.nextFloat();
                            repeat2 = false;
                        } catch (Exception e) {
                            System.out.println("You have entered wrong format value");
                            sc.next();
                            repeat2 = true;
                        }
                    }
                    repeat3 = true;

                    while (repeat3) {

                        try {
                            val2 = sc.nextFloat();
                            repeat3 = val2 == 0.0;
                        } catch (Exception e) {
                            System.out.println("You have entered wrong format value");
                            sc.next();
                            repeat3 = true;
                        }
                    }
                }
            }
            // distinguish the option according to requirement
            switch (option) {
                case 1:
                    float result1 = val1 + val2;
                    System.out.print("Result of addition of " + val1 + "  and " + val2 + " is ");
                    System.out.printf("%.2f\n", result1);
                    break;
                case 2:
                    float result2 = val1 - val2;
                    System.out.print("Result of subtraction from " + val1 + "  to " + val2 + " is ");
                    System.out.printf("%.2f\n", result2);
                    break;
                case 3:
                    float result3 = val1 * val2;
                    System.out.print("Result of multiply of " + val1 + "  and " + val2 + " is ");
                    System.out.printf("%.2f\n", result3);
                    break;
                case 4:
                    float result4 = val1 / val2;
                    System.out.print("Result of division of " + val1 + "  and " + val2 + " is ");
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

