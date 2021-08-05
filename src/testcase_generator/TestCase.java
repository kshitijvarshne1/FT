/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 05-Aug-21
 *   Time: 4:38 PM
 *   File: TestCase.java
 */

package testcase_generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCase {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\testcase_generator\\input2.txt");
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
            for (int i1 = 0; i1 < n; i1++) {
                int ele = (int) (Math.random() * 100) + 1;
                pw.print(ele+" ");
            }
            pw.println();
            int k = (int) (Math.random() * 10) + 1;
            pw.println(k);
        }
        pw.close();

    }
}

