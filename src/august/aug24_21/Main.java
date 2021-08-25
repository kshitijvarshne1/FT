/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 25-Aug-21
 *   Time: 6:59 PM
 *   File: Main.java
 */

package august.aug24_21;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // For output
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug24_21\\output2.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug24_21\\input2.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int check = 0;
            int i = 0;
            int t = 0;
            int n = 0;
            int[] arr = null;
            while ((st = br.readLine()) != null) {
                if (check == 0) {
                    check = 1;
                    t = Integer.parseInt(st);
                } else if (i == 0) {
                    n = Integer.parseInt(st);
                    i = 1;
                } else if (i == 1) {
                    arr = new int[n];
                    String[] a = st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1] = Integer.parseInt(a[i1]);
                    }
                    i = 0;
                    long out = solve(arr);
                    pw.println(out);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
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