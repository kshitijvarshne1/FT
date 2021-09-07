/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 07-Sep-21
 *   Time: 7:02 PM
 *   File: Main.java
 */

package september.sep07_21;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\output1.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        InputStream inputStream = new FileInputStream("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\intput1.txt");
        Scanner sc = new Scanner(inputStream);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            while (sc.hasNextLine()) {
                long n = Long.parseLong(sc.nextLine());
                pw.println(solve(n));
            }
        }
        pw.close();
    }

    private static String solve(long n) {
        int a = 0, b = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0)
                a = a * 10 + s.charAt(i) - '0';
            else
                b = b * 10 + s.charAt(i) - '0';
        }
        return String.valueOf((a + 1) * (b + 1) - 2);
    }
}

