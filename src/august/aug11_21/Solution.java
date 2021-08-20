/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 10-Aug-21
 *   Time: 3:07 PM
 *   File: Solution.java
 */

package august.aug11_21;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug11_21\\output1.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug11_21\\input1.txt");
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
                    arr = new int[2 * n];
                    String[] a = st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1] = Integer.parseInt(a[i1]);
                    }
                    i = 0;
                    String out = solve(arr, n);
                    pw.println(out);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
    }

    public static String solve(int[] a, int n) {
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
        String res = "";
        if (o == e) {
            res = "YES";
        } else {
            res = "NO";
        }
        return res;
    }
}

