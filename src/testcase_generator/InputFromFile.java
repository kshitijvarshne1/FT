/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 05-Aug-21
 *   Time: 4:56 PM
 *   File: InputFromFile.java
 */

package testcase_generator;

import java.io.*;


public class InputFromFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\testcase_generator\\input1.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

