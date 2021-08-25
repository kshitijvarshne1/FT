/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 25-Aug-21
 *   Time: 6:53 PM
 *   File: Solution.java
 */

package august.aug24_21;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        for (int i = 0; i < n - 2; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[n - 1] = 1;
        int[][] DP = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int l = 0; l + k < n; l++) {
                int h = l + k;
                for (int m = l + 1; m < h; m++) {
                    DP[l][h] = Math.max(DP[l][h], newNums[l] * newNums[m] * newNums[h] + DP[l][m] + DP[m][h]);
                }
            }
        }
        return DP[0][n - 1];
    }
}

