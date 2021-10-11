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
    private ArrayList<Media> mediaArrayList;

    public Manager() {
        mediaArrayList = new ArrayList<>();
    }

    // method to load media object
    public void loadMediaObject(ArrayList<Media> mediaList) throws IOException {
        setMediaArrayList(mediaList);
    }

    // getter and setter
    public ArrayList<Media> getMediaArrayList() {
        return mediaArrayList;
    }

    public void setMediaArrayList(ArrayList<Media> mediaArrayList) {
        this.mediaArrayList = mediaArrayList;
    }

    // method to show the media data
    public void showData() {
        System.out.printf("%-15s %-30s %-15s %-15s \n", "Ids", "Title", "Year", "Rental Fee");

        for (Media media : mediaArrayList) {
            System.out.printf("%-15s %-30s %-15s %-15s \n", media.getId(), media.getTitle(), media.getYearPublished(), media.calculateRentalFee());
        }
    }

    public void addMedia(String type, int id, String name, int year, int scope) {
        if (type.equalsIgnoreCase("E")) {
            mediaArrayList.add(new EBook(id, name, year, scope));
        } else if (type.equalsIgnoreCase("C")) {
            mediaArrayList.add(new MusicCD(id, name, year, scope));
        } else if (type.equalsIgnoreCase("D")) {
            mediaArrayList.add(new MovieDVD(id, name, year, scope));
        }
    }

    // method to find media
    public void findMedia(int findId) {
        for (Media m : mediaArrayList) {
            if (m.getId() == findId) {
                Media media = m;
                System.out.printf("%-15s %-30s %-15s %-15s \n", "Ids", "Title", "Year", "Rental Fee");
                System.out.printf("%-15s %-30s %-15s %-15s \n", media.getId(), media.getTitle(), media.getYearPublished(), media.calculateRentalFee());
                return;
            }
        }
        System.out.println("Not found");
    }


    // method to delete the media by id
    public void deleteId(int deleteId) {
        int index = -1;
        int i = 0;
        for (Media m : mediaArrayList) {
            if (m.getId() == deleteId) {
                index = i;
                break;
            }
            i++;
        }
        if (index != -1) {
            mediaArrayList.remove(index);
            System.out.println("Deleted !!!!");
        } else {
            System.out.println("Not found !!!!)");
        }
    }

    public int modify(int idd) {
        int k = 0;
        for (Media m : mediaArrayList) {
            if (m.getId() == idd) {
                return k;
            }
            k++;
        }
        return -1;
    }

    public int rent(int in2) {
        int k = 0;
        for (Media m : mediaArrayList) {
            if (m.getId() == in2) {
                return k;
            }
            k++;
        }
        return -1;
    }
}



