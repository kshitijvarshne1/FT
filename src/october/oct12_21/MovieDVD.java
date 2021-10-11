/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:47 PM
 *   File: MovieDVD.java
 */

package october.oct12_21;

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
}

