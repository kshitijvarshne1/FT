/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 10-Aug-21
 *   Time: 3:08 PM
 *   File: Main.java
 */

package august.aug11_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int [] a= new int[2*n];
            for (int i = 0; i < 2 * n; i++) {
                a[i]= sc.nextInt();
            }
            System.out.println(solve(a,n));
        }
    }

    public static String solve(int a[], int n) {
        Scanner sc = new Scanner(System.in);
        int o = 0;
        int e = 0;

        for (int i = 0; i < 2 * n; i++) {
            int k = a[i];
            if (k == 1) {
                o++;
            } else if (k % 2 == 0) {
                e++;
            } else {
                o++;
            }
        }
        String res="";
        if (o == e) {
            res="YES";
        } else {
            res="NO";
        }
        return res;
    }
}

