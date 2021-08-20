/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 20-Aug-21
 *   Time: 8:27 PM
 *   File: Main.java
 */

package august.aug20_21;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // for output the result
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug20_21\\output1.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug20_21\\input1.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int check = 0;
            int i = 0;
            int t = 0;
            int n = 0;
            long[] arr = null;
            while ((st = br.readLine()) != null) {
                if (check == 0) {
                    check = 1;
                    t = Integer.parseInt(st);
                } else if (i == 0) {
                    n = Integer.parseInt(st);
                    i = 1;
                } else if (i == 1) {
                    arr = new long[n];
                    String[] a = st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1] = Long.parseLong(a[i1]);
                    }
                    i = 0;
                    long out = solve(arr, n);
                    pw.println(out);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
    }

    public static long solve(long[] a, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        long aaa = Long.MAX_VALUE;
        if (a.length == 1) {
            aaa = 1;
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

            long s;
            for (int i = 0; i < n; i++) {
                s = ((sum - a[i]) / h[i]) + 1;
                aaa = Math.min(s, aaa);
            }
        }
        return aaa;
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