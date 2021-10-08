/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 08-Oct-21
 *   Time: 11:50 AM
 *   File: Main.java
 */

package october.oct08_21;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // get the file path
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\october\\oct08_21\\mypet.txt");
        // Creating an object of BuffferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        // creating arraylist of Dog type
        ArrayList<Dog> dogs= new ArrayList<>();
        PrintWriter pWirter =null;
        pWirter = new PrintWriter(new File("D:\\testout.txt"));
        writer1.close();
        String st;
        while ((st = br.readLine()) != null)

    }
}

