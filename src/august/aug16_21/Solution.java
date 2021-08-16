/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 9:19 AM
 *   File: Solution.java
 */

package august.aug16_21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            int[] ans = cars(arr, n);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }

    private static int[] cars(String[] arr, int n) {
        int[] ans = new int[n];
        HashMap<String, Integer> mp = new HashMap<>();
        // count the occurences of strings
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i]) == true) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            // check for similar apperances
            if (mp.containsKey(arr[i]) == true) {
                ans[i] += mp.get(arr[i]) - 1;
            }
            //try to flip every single bit once


            char[] temp = arr[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {

                // flip
                if (temp[j] == '1') {
                    temp[j] = '0';
                } else {
                    temp[j] = '1';
                }
                String check = String.valueOf(temp);


                if (mp.containsKey(check)) {
                    ans[i] += mp.get(check);
                }
                temp = check.toCharArray();
                // reflip
                if (temp[j] == '1') {
                    temp[j] = '0';
                } else {
                    temp[j] = '1';
                }
            }

        }
        for (Map.Entry<String, Integer> s : mp.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }

        return ans;
    }
}

