/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 16-Aug-21
 *   Time: 7:28 PM
 *   File: Ques3.java
 */

package august.aug17_21;

public class Ques3 {
    public static void main(String[] args) {
        Count count = new Count();
        String[] names = {"abe", "babe", "strobe"};

        Integer[] intObjs = {1, 6, 3, 6, 5, 6, 7, 8};
        System.out.println(count.count(names, "strobe"));
        System.out.println(count.count(intObjs, 6));


    }

    static class Count {
        public int count(Object[] arr, Object obj) {
            int count = 0;
            for (Object o : arr) {
                if (o.equals(obj)) {
                    count++;
                }
            }

            return count;
        }
    }
}

