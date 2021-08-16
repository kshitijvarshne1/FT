/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 9:57 AM
 *   File: TestCaseGen.java
 */

package august.aug16_21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestCaseGen {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug16_21\\input1.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        int minT = 1;
        int maxT = 50;
        int rangeT = maxT - minT + 1;
        int t = (int) (Math.random() * rangeT) + minT;
        pw.println(t);
        for (int i = 0; i < t; i++) {
            int minN = 5;
            int maxN = 10;
            int rangeN = maxN - minN + 1;
            int n = (int) (Math.random() * rangeN) + minN;
            pw.println(n);
            int len = (int) (Math.random() * 10) + 3;
            for (int i1 = 0; i1 < n; i1++) {
                for (int j = 0; j < len; j++) {
                    Random random = new Random();
                    boolean res = random.nextBoolean();
                    pw.print(res == true ? 1 : 0 );
                }
                pw.println();
            }
        }
        pw.close();

    }
}



