/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Aug-21
 *   Time: 10:47 PM
 *   File: TestCaseGenerator.java
 */

package august.aug09_21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCaseGenerator {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug09_21\\input2.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        int minT = 1;
        int maxT = 1000;
        int rangeT = maxT - minT + 1;
        int t = (int) (Math.random() * rangeT) + minT;
        pw.println(t);
        for (int i = 0; i < t; i++) {
            int minN = 5;
            int maxN = 100;
            int rangeN = maxN - minN + 1;
            int n = (int) (Math.random() * rangeN) + minN;
            pw.println(n);
            for (int i1 = 0; i1 < 2 * n - 1; i1++) {
                int ele = ((int) (Math.random() * 1000) + 1)-500;
                pw.print(ele + " ");
            }
            pw.println();
        }
        pw.close();

    }
}