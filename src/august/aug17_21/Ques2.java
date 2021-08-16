/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 7:18 PM
 *   File: Ques2.java
 */

package august.aug17_21;

import java.util.HashMap;
import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        System.out.println("Enter a word: ");
        String word = new Scanner(System.in).next();
        String vowelNumber = "";
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('a', '1');
        mp.put('e', '2');
        mp.put('i', '3');
        mp.put('o', '4');
        mp.put('u', '5');
        for (int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i));
            ch = ch.toLowerCase();
            if (mp.containsKey(ch.charAt(0))) {
                vowelNumber += mp.get(ch.charAt(0));
            } else {
                vowelNumber += word.charAt(i);
            }
        }

        System.out.println("VowelNumbered is: " + vowelNumber + " :");
    }
}

