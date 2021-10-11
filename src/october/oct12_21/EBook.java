/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 6:32 PM
 *   File: EBook.java
 */

package october.oct12_21;

public class EBook extends Media{
    private int numberOfChapter;

    public EBook(int id, String title, int yearPublished, int numberOfChapter) {
        super(id, title, yearPublished);
        this.numberOfChapter = numberOfChapter;
    }
}

