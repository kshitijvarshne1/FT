/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:26 PM
 *   File: Media.java
 */

package october.oct12_21;

public abstract class Media {
    // instance variable
    private final int id;
    private String title;
    private int yearPublished;

    // constructor
    public Media(int id, String title, int yearPublished) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    // getter and setter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }


    // calculate rental fee; for generic media it is flat fee $1.50
    public double calculateRentalFee() {
        return 1.50;
    }
}

