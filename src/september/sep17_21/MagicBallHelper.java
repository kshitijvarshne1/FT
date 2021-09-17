/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 17-Sep-21
 *   Time: 11:23 AM
 *   File: MagicBallHelper.java
 */

package september.sep17_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MagicBallHelper {
    public static void main(String[] args) throws FileNotFoundException {
        String[] ans = new String[1000];
        int count = readAnswers(ans);
        for (int i = 0; i < count; i++) {
            System.out.println(ans[i]);
        }
        System.out.println(count);

    }

    public static int readAnswers(String[] answers) {
        int count = 0;
        Scanner file = null;
        try {
            file = new Scanner(new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep17_21\\answer.txt"));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                answers[count] = line;
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Data file Not found");
        }


        return count;
    }
}

