/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 25-Aug-21
 *   Time: 6:47 PM
 *   File: TestCaseGen.java
 */

package august.aug24_21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCaseGen {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug24_21\\input.txt");
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
        }
        pw.close();
    }
}