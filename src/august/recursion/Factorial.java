/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 12-Aug-21
 *   Time: 8:12 PM
 *   File: Factorial.java
 */

package august.recursion;

public class Factorial {
    public static void main(String[] args) {
        // find factorial of a number
        int n1 = 1;
        System.out.println("factorial of " + n1 + " is : " + factorial(n1));
        int n2 = 5;
        System.out.println("factorial of " + n2 + " is : " + factorial(n2));
        int n3 = 11;
        System.out.println("factorial of " + n3 + " is : " + factorial(n3));
    }

    private static int factorial(int n) {
        //base condition
        if(n<=1){
            return 1;
        }
        // recursively call the method with n-1
        return n*factorial(n-1);
    }
}

