/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 05-Aug-21
 *   Time: 4:25 PM
 *   File: Cookies.java
 */

package august.aug08_21;

import java.io.*;

public class Cookie {
    public static void main(String[] args) throws IOException {
        // for output the result
        File fileOut = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\august\\aug08_21\\output2.txt");
        FileWriter fwout = new FileWriter(fileOut);
        PrintWriter pw = new PrintWriter(fwout);

        // For input the file data
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\testcase_generator\\input2.txt");
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
                    int out = cookieDist(arr,k);
                    pw.println(out);

                    // send the data to the method
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pw.close();
    }
    static boolean isValid(int[] a, int n, int mid, int k) {
        int cokkie = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum > mid) {
                cokkie++;
                sum = a[i];
            }
            if (cokkie > k) {
                return false;
            }
        }
        return true;
    }
    static int cookieDist(int[] a, int k) {
        int n = a.length;
        if (n < k) {
            return -1;
        }
        int sum = 0;
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, a[i]);
            sum += a[i];
        }
        int s = maxi;
        int e = sum;
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(a, n, mid, k) == true) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }
}

