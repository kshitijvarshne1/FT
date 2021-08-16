/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 10:09 AM
 *   File: Car.java
 */

package august.aug16_21;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Car {
    public static void main(String[] args) throws IOException {

        // for output the result
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug16_21\\output2.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug16_21\\input2.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int check = 0;
            int i = 0;
            int t = 0;
            int n = 0;
            int k = 0;
            String[] arr = null;
            while ((st = br.readLine()) != null) {
                if (check == 0) {
                    check = 1;
                    t = Integer.parseInt(st);
                } else if (i == 0) {
                    n = Integer.parseInt(st);
                    arr = new String[n];
                    i++;
                } else if (i == 1) {
                    arr[k] = st;
                    k++;
                    i = 1;
                    if (k == n) {
                        i = 0;
                        int [] res=cars(arr, n);
                        k = 0;
                        for (int re : res) {
                            pw.print(re+" ");
                        }
                        pw.println();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
    }


    private static int[] cars(String[] arr, int n) {
        int[] ans = new int[n];
        HashMap<String, Integer> mp = new HashMap<>();
        // count the occurences of strings
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i]) == true) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            // check for similar apperances
            if (mp.containsKey(arr[i]) == true) {
                ans[i] += mp.get(arr[i]) - 1;
            }
            //try to flip every single bit once


            char[] temp = arr[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {

                // flip
                if (temp[j] == '1') {
                    temp[j] = '0';
                } else {
                    temp[j] = '1';
                }
                String check = String.valueOf(temp);


                if (mp.containsKey(check)) {
                    ans[i] += mp.get(check);
                }
                temp = check.toCharArray();
                // reflip
                if (temp[j] == '1') {
                    temp[j] = '0';
                } else {
                    temp[j] = '1';
                }
            }

        }
        return ans;
    }

}


