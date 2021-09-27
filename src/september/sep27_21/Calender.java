/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Sep-21
 *   Time: 3:44 PM
 *   File: Calender.java
 */

package september.sep27_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calender {
    ArrayList<Integer> years;
    String[] months;
    ArrayList<Integer> days;
    HashMap<Integer, Date> dates;

    public Calender() {
        years = new ArrayList<>();
        months = new String[12];
        days = new ArrayList<>();
        dates = new HashMap<>();
        for (int i = 1910; i < 2050; i++) {
            years.add(i);
        }
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 1; i <= 30; i++) {
            days.add(i);
        }
        int k = 1;
        for (Integer i : years) {
            for (int j = 0; j < months.length; j++) {
                Iterator<Integer> it = days.iterator();
                while (it.hasNext()) {
                    dates.put(k++, new Date(i, months[j], it.next()));
                }
            }
        }
    }


    public void printCalender() {
        for (Map.Entry<Integer, Date> i : dates.entrySet()) {
            System.out.println(i.getValue().getDate());
        }
    }

}

