/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Aug-21
 *   Time: 10:19 PM
 *   File: Solution.java
 */

package august.aug09_21;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[2 * n - 1];
            for (int i = 0; i < 2 * n - 1; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(sol(arr, n));
        }
    }

    private static int sol(int[] arr, int n) {
        int sum = 0;
        if (n % 2 == 1) {
            for (int i = 0; i < 2 * n - 1; i++) {
                sum += Math.abs(arr[i]);
            }
        } else {
            int neg = 0;
            for (int i = 0; i < 2 * n - 1; i++) {
                if (arr[i] < 0) {
                    neg++;
                }
            }
            if (neg % 2 == 1) {
                int mini = Integer.MIN_VALUE;
                for (int i = 0; i < 2 * n - 1; i++) {
                    if (arr[i] < 0) {
                        mini = Math.max(mini, arr[i]);
                    }
                }
                boolean find = true;
                for (int i = 0; i < 2 * n - 1; i++) {
                    if (find == true && arr[i] == mini) {
                        find = false;
                        continue;
                    }
                    sum += Math.abs(arr[i]);
                }
                sum -= Math.abs(mini);

            } else {
                for (int i = 0; i < 2 * n - 1; i++) {
                    sum += Math.abs(arr[i]);
                }
            }
        }
        return sum;
    }
}

