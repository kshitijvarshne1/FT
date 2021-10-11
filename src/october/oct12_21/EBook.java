/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:32 PM
 *   File: EBook.java
 */

package october.oct12_21;

import java.util.Calendar;

public class EBook extends Media {
    // instance variable
    private int numberOfChapter;

    // constructor
    public EBook(int id, String title, int yearPublished, int numberOfChapter) {
        super(id, title, yearPublished);
        this.numberOfChapter = numberOfChapter;
    }

    // getter and setter
    public int getNumberOfChapter() {
        return numberOfChapter;
    }

    public void setNumberOfChapter(int numberOfChapter) {
        this.numberOfChapter = numberOfChapter;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "numberOfChapter=" + numberOfChapter +
                '}';
    }

    // calculateRentalFee method
    public double calculateRentalFee() {
        double fee = this.numberOfChapter * 0.10 + 1; // basic fee
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        // add $1.00 fee if current year is same as published year
        if (this.getYearPublished() == currYear) {
            fee += 1;
        }
        return fee;
    }
}

