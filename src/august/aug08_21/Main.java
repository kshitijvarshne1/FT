/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 06-Aug-21
 *   Time: 4:06 PM
 *   File: Main.java
 */

package august.aug08_21;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(cookieDist(arr, k));
        }
    }

    static boolean isValid(int[] a, int n, int mid, int k) {
        int cokkie = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum > mid) {
                cokkie++;
                sum = a[i];
            }
            if (cokkie > k) {
                return false;
            }
        }
        return true;
    }

    static int cookieDist(int[] a, int k) {
        int n = a.length;
        if (n < k) {
            return -1;
        }
        int sum = 0;
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, a[i]);
            sum += a[i];
        }
        int s = maxi;
        int e = sum;
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(a, n, mid, k) == true) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }
}