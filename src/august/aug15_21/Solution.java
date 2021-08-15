/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 15-Aug-21
 *   Time: 1:15 PM
 *   File: Solution.java
 */

package august.aug15_21;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(card(arr, n, k));
        }
    }

    private static int card(int[] arr, int n, int k) {
        int res = 0;
        for (int start = n - k, i = start, win = 0; i < n + k; ++i) {
            win += arr[i % n];
            if (i - start >= k) {
                win -= arr[(i - k) % n];
            }
            res = Math.max(win, res);
        }
        return res;
    }

}

