/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Sep-21
 *   Time: 3:39 PM
 *   File: Data.java
 */

package september.sep27_21;

public class Date {
    private long year;
    private String month;
    private int day;

    public Date(long year, String month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDate(){
        return this.month+" "+this.day+", "+this.year;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

