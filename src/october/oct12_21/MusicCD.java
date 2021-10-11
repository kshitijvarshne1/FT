/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:41 PM
 *   File: MusicCD.java
 */

package october.oct12_21;

import java.util.Calendar;

public class MusicCD extends Media {
    // instance variable
    private int length;

    // constructor
    public MusicCD(int id, String title, int yearPublished, int length) {
        super(id, title, yearPublished);
        this.length = length;
    }

    // getter and setter methods
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // method to calculate rental Fee
    public double calculateRentalFee() {
        double fee = length * 0.02 + 1.00;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // add $2.00 fee if current year is same as published year
        if (this.getYearPublished() == currentYear) {
            fee += 2.00;
        }
        return fee;
    }

    @Override
    public String toString() {
        return "MusicCD [ id=" + getId() + ", title=" + getTitle() + ", year=" + getTitle() + ", length=" + length + "min ]";

    }
}

