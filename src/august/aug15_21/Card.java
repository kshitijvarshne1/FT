/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 15-Aug-21
 *   Time: 1:28 PM
 *   File: Card.java
 */

package august.aug15_21;

import java.io.*;

public class Card {
    public static void main(String[] args) throws IOException {
        // for output the result
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug15_21\\output2.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug15_21\\input2.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int check = 0;
            int i = 0;
            int t = 0;
            int n = 0;
            int k = 0;
            int[] arr = null;
            while ((st = br.readLine()) != null) {
                if (check == 0) {
                    check = 1;
                    t = Integer.parseInt(st);
                } else if (i == 0) {
                    n = Integer.parseInt(st);
                    i++;
                } else if (i == 1) {
                    arr = new int[n];
                    String[] a = st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1] = Integer.parseInt(a[i1]);
                    }
                    i++;
                } else if (i == 2) {
                    k = Integer.parseInt(st);
                    i = 0;
                    int out = card(arr, n, k);
                    pw.println(out);

                    // send the data to the method
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
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

