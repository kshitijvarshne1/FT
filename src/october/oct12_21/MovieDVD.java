/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:47 PM
 *   File: MovieDVD.java
 */

package october.oct12_21;

import java.util.Calendar;

public class MovieDVD extends Media {
    // instance variable
    private double size;

    // constructor
    public MovieDVD(int id, String title, int yearPublished, double size) {
        super(id, title, yearPublished);
        this.size = size;
    }

    // getter and setter
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    //method to calculate renter fee
    public double calculateRentalFee() {
        double fee = 3.25;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        // add $5.00 fee if current year is same as published year
        if (this.getYearPublished() == currentYear) {
            fee = 5.00;
        }
        return fee;
    }
}

