/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:26 PM
 *   File: Media.java
 */

package october.oct12_21;

public abstract class Media {
    private int id;
    private String title;
    private int yearPublished;

    public Media(int id, String title, int yearPublished) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
    }
}

