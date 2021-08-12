/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Aug-21
 *   Time: 10:54 PM
 *   File: Main.java
 */

package august.aug09_21;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // for output the result
        File fileOut = new File("C:\\\\Users\\\\kshitij varshney\\\\IdeaProjects\\\\FT\\\\src\\\\august\\\\aug09_21\\\\output1.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\\\Users\\\\kshitij varshney\\\\IdeaProjects\\\\FT\\\\src\\\\august\\\\aug09_21\\\\input1.txt");
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
                    i=1;
                } else if (i == 1) {
                    arr = new int[2*n-1];
                    String[] a = st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1] = Integer.parseInt(a[i1]);
                    }
                    i = 0;
                    int out = sol(arr, n);
                    pw.println(out);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
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