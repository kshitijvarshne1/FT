/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Sep-21
 *   Time: 11:30 AM
 *   File: Exercise5.java
 */

package september.sep02_21;

public class Exercise5 {

    public static void main(String[] args) {
        processCLArgument(args);
    }

    public static void processCLArgument(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage : java Exercise5 inputFile outputFile");
            System.exit(1);
        } else {
            System.out.println("Input will be read From: " + args[0] + "\nOutput will be written into: " + args[1]);
            System.out.println();
        }
    }
}

