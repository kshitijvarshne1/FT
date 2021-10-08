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
        ArrayList<Dog> dogs = new ArrayList<>();
        // creating the object of PrintWiter class to print the data in the file
        PrintWriter pWirter = null;
        // set the file path for output the data
        pWirter = new PrintWriter(new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\october\\oct08_21\\output.txt"));
        String st;
        while ((st = br.readLine()) != null) {
            String[] data = null;
            boolean check = true;
            try {
                data = st.split(" ");
            } catch (Exception e) {
                check = false;

            }
            if (check && data.length == 5) {
                dogs.add(new Dog(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Boolean.parseBoolean(data[4])));
            } else {
                dogs.add(null);
            }
            check = true;
        }
        for (Dog dog : dogs) {
            if (dog == null) {
                pWirter.println("One entry was skipped due to a format error.");
            } else {
                String s = dog.getName() + " " + dog.getBreed() + " " + dog.getAge() + " " + dog.getAKCnumber() + " " + dog.isVaccinated();
                pWirter.println(s);
            }
        }
        pWirter.close();

    }
}

