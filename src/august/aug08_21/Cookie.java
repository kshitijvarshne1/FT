/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 05-Aug-21
 *   Time: 4:25 PM
 *   File: Cookies.java
 */

package august.aug08_21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Cookie {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\testcase_generator\\inp.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int check =0;
            int i=0;
            int t=0;
            int n=0;
            int k=0;
            int[] arr=null;
            while ((st = br.readLine()) != null) {
                if(check==0){
                    check=1;
                    t= Integer.parseInt(st);
                    System.out.println(t);
                }
                else if(i==0){
                    n= Integer.parseInt(st);
                    i++;
                }
                else if(i==1){
                    arr= new int[n];
                    String[] a =st.split(" ");
                    for (int i1 = 0; i1 < a.length; i1++) {
                        arr[i1]= Integer.parseInt(a[i1]);
                    }
                    i++;
                }
                else if(i==2){
                    k= Integer.parseInt(st);
                    i=0;

                    // send the data to the method
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

