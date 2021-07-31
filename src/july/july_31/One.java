/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 31-Jul-21
 *   Time: 6:52 AM
 *   File: One.java
 */

package july.july_31;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws IOException {
        //for input
        Scanner sc = new Scanner(System.in);
        System.out.println("You entered a valid integer: " + validInteger());
        System.out.println("You entered a valid integer: " + validDecimal());
        System.out.println("Enter data file of name and number of items purchases:");
        String fileName = sc.next();
        ArrayList<ArrayList<String>> res= getFileData(fileName);
        if(res.get(0).size()==0){
            System.out.println("can't find your input file:" + fileName);
        }
        else{
            ArrayList<String> lastName = res.get(0);
            ArrayList<String> noOfItems= res.get(1);
            showFilaData(lastName,noOfItems);
        }
        fileAnalysis(fileName);
    }

    public static int validInteger() {
        // for input
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an integer to test,more than -5:");
            String k = sc.next();
            try {
                // parsing the value if it is
                int n = Integer.parseInt(k);
                if (n > -5) {
                    return n;
                } else {
                    System.out.println("***Invalid entry - Try again");
                }
            } catch (Exception e) {
                System.out.println("***Invalid entry - Try again");
            }
        }
    }

    public static double validDecimal() {
        // for input
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an decimal to test:");
            String k = sc.next();
            try {
                // parsing the value if it is
                double n = Double.parseDouble(k);
                if (k.contains(".")) {
                    return n;
                } else {
                    System.out.println("***Invalid entry - Try again");
                }
            } catch (Exception e) {
                System.out.println("***Invalid entry - Try again");
            }
        }
    }

    public static ArrayList<ArrayList<String>> getFileData(String fileName) throws IOException {
        // file path
        String filePath = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\july\\july_31\\";
        File file = new File(filePath + fileName);
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> noOfItems= new ArrayList<>();
        try {
            // for input the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] temp = st.split(" ");
                lastName.add(temp[0]);
                noOfItems.add(temp[1]);
            }
        } catch (Exception e) {
            System.out.println("can't find your input file:" + fileName);
        }
        ArrayList<ArrayList<String>> res= new ArrayList<>();
        res.add(lastName);
        res.add(noOfItems);
        return res;
    }
    private static void showFilaData(ArrayList<String> lastName, ArrayList<String> noOfItems) {
        for(int i=0;i<lastName.size();i++){
            System.out.println(lastName.get(i)+" * "+noOfItems.get(i));
        }
    }

    private static void fileAnalysis(String fileName) {
        String filePath = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\july\\july_31\\";
        File file = new File(filePath + fileName);
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> noOfItems= new ArrayList<>();
        try {
            // for input the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int noOfDigits=0;
            int noOfLowerCase=0;
            int size=0;
            while ((st = br.readLine()) != null) {
                String[] temp = st.split(" ");
                noOfDigits+=temp[1].length();
                String s= temp[0];
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                        noOfLowerCase++;
                    }
                }
                byte[] utf16Bytes= temp[1].getBytes("UTF-16BE");
                size+=utf16Bytes.length;;
                utf16Bytes= temp[0].getBytes(StandardCharsets.UTF_8);
                size+=utf16Bytes.length;
            }
            System.out.println("Number of Digits:"+noOfDigits);
            System.out.println("Number of lower-case letter: "+noOfLowerCase);
            System.out.println("The file has "+size+" bytes");
            return;
        } catch (Exception e) {
            System.out.println("can't find your input file:" + fileName);
            return;
        }
    }
}

