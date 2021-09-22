/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 22-Sep-21
 *   Time: 5:52 PM
 *   File: Main.java
 */

package september.sep22_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // creating the object of Scanner class for input the data
        Scanner sc = new Scanner(System.in);
        // creating the array of Animal type
        Animal[] animals = new Animal[6];
        Animal animal1 = new Animal("sami", "cat", 2, false);
        Animal animal2 = new Animal("john", "dog", 3, true);
        Animal animal3 = new Animal("duffle", "dog");
        Animal animal4 = new Animal("kiki", "cat");
        Animal animal5 = new Animal();
        Animal animal6 = new Animal("diki", "cat", 1, true);
        animals = new Animal[]{animal1, animal2, animal3, animal4, animal5, animal6};
        System.out.println("Hello and welcome to the Animal Shelter.");
        System.out.println("Are you interested in adopting a cat? If so enter true, if not enter false");
        boolean option = sc.nextBoolean();
        String type = "cat";
        if (option == false) {
            type = "dog";
        }
        System.out.println("Here is the list of " + type + " for adoption");
        if (option) {
            for (int i = 0; i < animals.length; i++) {
                if (animals[i].getType().equalsIgnoreCase("cat")) {
                    System.out.println(animals[i]);
                }
            }
        } else {
            for (int i = 0; i < animals.length; i++) {
                if (animals[i].getType().equalsIgnoreCase("dog")) {
                    System.out.println(animals[i]);
                }
            }
        }
    }
}

