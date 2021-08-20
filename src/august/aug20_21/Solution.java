/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 20-Aug-21
 *   Time: 7:32 PM
 *   File: Solution.java
 */

package august.aug20_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        if (a.length == 1) {
            System.out.println(1);
        } else {
            long[] f = new long[n];
            f[0] = a[0];
            for (int i = 1; i < n; i++) {
                f[i] = gcd(f[i - 1], a[i]);
            }
            long[] b = new long[n];
            b[b.length - 1] = a[a.length - 1];
            for (int i = a.length - 2; i >= 0; i--) {
                b[i] = gcd(b[i + 1], a[i]);
            }
            long[] h = new long[n];
            h[0] = b[1];
            h[n - 1] = f[n - 2];
            for (int i = 1; i < n - 1; i++) {
                h[i] = gcd(f[i - 1], b[i + 1]);
            }
            long aaa = Long.MAX_VALUE;
            long s;
            for (int i = 0; i < n; i++) {
                s = ((sum - a[i]) / h[i]) + 1;
                aaa = Math.min(s, aaa);
            }
            System.out.println(aaa);
        }
    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}

