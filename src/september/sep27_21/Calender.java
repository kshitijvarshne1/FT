/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Sep-21
 *   Time: 3:44 PM
 *   File: Calender.java
 */

package september.sep27_21;

import java.util.ArrayList;
import java.util.HashMap;

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
    }
}

