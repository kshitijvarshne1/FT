/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 12-Aug-21
 *   Time: 7:28 PM
 *   File: PrintNumber.java
 */

package august.recursion;

public class PrintNumber {
    public static void main(String[] args) {
        // Print the numbers from 1 to n using recursion
        int n= 50;
        printNumbersInIncreasingOrder(n);
        System.out.println();
        // Print the numbers from n to 1 using recursion
        printNumbersInDecreasingOrder(n);
    }


    private static void printNumbersInIncreasingOrder(int n) {
        // Base Condition
        if(n<1){
            return ;
        }
        // recursively call the function
        printNumbersInIncreasingOrder(n-1);
        // print the number
        System.out.print(n+" ");
    }
    private static void printNumbersInDecreasingOrder(int n) {
        // Base Condition
        if(n<1){
            return ;
        }
        // print the number
        System.out.print(n+" ");
        // recursively call the function
        printNumbersInDecreasingOrder(n-1);
    }
}

