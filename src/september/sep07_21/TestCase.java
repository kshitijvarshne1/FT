/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 07-Sep-21
 *   Time: 7:27 PM
 *   File: TestCase.java
 */

package september.sep07_21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCase {
    public static void main(String[] args) throws IOException {
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\input.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);
        pw.println(787);
        for(int i=0;i<787;i++){
            int x= (int) ((Math.random()*1000000)+5);
            pw.println(x);
        }
        pw.close();
    }
}

