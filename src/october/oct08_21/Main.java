/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 08-Oct-21
 *   Time: 11:50 AM
 *   File: Main.java
 */

package october.oct08_21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // get the file path
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\october\\oct08_21\\mypet.txt");
        // Creating an object of BuffferedReader class
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

