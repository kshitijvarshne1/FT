/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 26-Aug-21
 *   Time: 5:02 PM
 *   File: FizzBuzz.java
 */

package august.aug26_21;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // create a object of Scanner class for input the data from the console
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :- ");
        // Number till you want to print the FizzBuzz
        int n = sc.nextInt();
        //for loop executes until the condition i<=n becomes false
        for (int i = 1; i < n; i++) {
            //returns true if both the conditions return true
            if (i % 3 == 0 && i % 5 == 0) {
                //prints if the number is multiple of 3 and 5
                System.out.print("FizzBuzz");
            }
            //executes if the condition returns true
            else if (i % 3 == 0) {
                //prints if the number is multiple of 3
                System.out.print("Fizz");
            }
            //executes if the condition returns true
            else if (i % 5 == 0) {
                //prints if the number is multiple of 5
                System.out.print("Buzz");
            } else {
                //prints the number itself if the number is not divisible by both 3 and 5
                System.out.print(i);
            }
            //prints space
            System.out.print("," + " ");
        }
    }
}

