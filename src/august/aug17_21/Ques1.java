/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 7:11 PM
 *   File: Ques1.java
 */

package august.aug17_21;

import java.util.ArrayList;
import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Test test = new Test();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String word = in.next();
        String[] threes = test.makeThreeSome(word);
        for (String s : threes) {
            System.out.println(s);
        }
    }

    static class Test {
        public String[] makeThreeSome(String word) {
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                if (i + 2 < word.length()) {
                    String temp = word.substring(i, i + 3);
                    res.add(temp);
                }
            }
            return res.toArray(new String[0]);
        }
    }
}

