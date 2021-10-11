/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 7:04 PM
 *   File: Manager.java
 */

package october.oct12_21;

import java.io.*;
import java.util.ArrayList;

public class Manager {
    private final ArrayList<Media> mediaArrayList;

    public Manager() {
        mediaArrayList = new ArrayList<>();
    }

    // method to load media object
    public void loadMediaObject(Media media) throws IOException {
        mediaArrayList.add(media);
    }

    // method to show the media data
    public void showData() {
        for (Media media : mediaArrayList) {
            System.out.println(media.toString());
        }
    }
}



