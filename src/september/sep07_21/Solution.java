/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 07-Sep-21
 *   Time: 6:58 PM
 *   File: Solution.java
 */

package september.sep07_21;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            System.out.println(solve(x));
        }
    }

    private static String solve(int n) {
        int a = 0, b = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0)
                a = a * 10 + s.charAt(i) - '0';
            else
                b = b * 10 + s.charAt(i) - '0';
        }
        return  String.valueOf((a + 1) * (b + 1) - 2);
    }
}

