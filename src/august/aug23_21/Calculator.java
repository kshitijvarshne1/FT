/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 23-Aug-21
 *   Time: 12:05 PM
 *   File: Calculator.java
 */

package august.aug23_21;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to John Doe Handy Calculator");
        showOptions();
        int option =0;
        while (true){
            String inp = sc.next();
            try{
                option= Integer.parseInt(inp);
            }
            catch (Exception e){
                System.out.println("You have entered an invalid choice, please re-enter your choice:");
            }
            switch (option){
                case 1:
                    System.out.println("Please enter two float number to addition separated by space");
                    break;
                case 2:
                    System.out.println("Please enter two float number to subtraction separated by space");
                    break;
                case 3:
                    System.out.println("Please enter two float number to multiply separated by space");
                    break;
                case 4:
                    System.out.println("Please enter two float number to division separated by space");
                    break;
                case 5:
                    System.out.println("Thank you for using John Doe Handy Calculator");
                    System.exit(0);
                default:
                    System.out.println("please enter the correct input");
            }
        }
    }

    public static void showOptions() {
        System.out.println("1. Addition \n" +
                "2. Subtraction \n" +
                "3. Multiplication \n" +
                "4. Division \n" +
                "5. Exit");
        System.out.println("What would you like to do?");
    }
}

