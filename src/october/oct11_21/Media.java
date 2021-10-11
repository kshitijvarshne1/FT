/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 5:37 PM
 *   File: Media.java
 */

package october.oct11_21;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

abstract class Media {
    // attributes
    private final int id;
    private String title;
    private int year;

    // constructor
    public Media(int id, String title, int year) {

        this.id = id;
        this.title = title;
        this.year = year;

    }

    // get methods
    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // set methods
    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // calculate rental fee; for generic media it is flat fee $1.50
    public double calculateRentalFee() {
        return 1.50;
    }
}

class Ebook extends Media {

    // local attributes
    private int numChapters;

    // constructor
    public Ebook(int id, String title, int year, int chapters) {
        super(id, title, year);
        this.numChapters = chapters;
    }

    // get methods
    public int getNumChapters() {
        return numChapters;

    }

    // set methods
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    // override parent's calculateRentalFee method
    @Override
    public double calculateRentalFee() {
        double fee = numChapters * 0.10 + 1; // basic fee

        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        if (this.getYear() == currYear) fee += 1; // add $1.00 fee
        return fee;
    }

    @Override
    public String toString() {
        return "EBook [ id=" + getID() + ", title=" + getTitle() + ", year=" + getYear() + ", chapters=" + numChapters + "]";
    }
}

class MusicCD extends Media {

    // local attributes
    private int length;

    // constructor
    public MusicCD(int id, String title, int year, int length) {
        super(id, title, year);
        this.length = length;
    }

    // get method
    public int getLength() {
        return length;
    }

    // set method
    public void setLength(int length) {
        this.length += length;
    }

    // override parent's calculateRentalFee method
    @Override
    public double calculateRentalFee() {
        double fee = length * 0.02 + 1;
        int currYear = Calendar.getInstance().get(Calendar.YEAR);

        if (this.getYear() == currYear) fee += 2; // add $2.00 fee

        return fee;
    }

    @Override
    public String toString() {
        return "MusicCD [id=" + getID() + ", title=" + getTitle() + ", year=" + getYear() + ", length=" + length + "min]";
    }
}

class MovieDVD extends Media {

    // local attributes
    private double size; // value in MB

    // constructor
    public MovieDVD(int id, String title, int year, double size) {
        super(id, title, year);
        this.size = size;
    }

    // get method
    public double getSize() {
        return size;
    }

    // set method
    public void setSize(double size) {
        this.size = size;
    }

    // override parent's calculateRentalFee method
    @Override
    public double calculateRentalFee() {
        double fee = 3.25;
        int currYear = Calendar.getInstance().get(Calendar.YEAR);

        if (this.getYear() == currYear) fee = 5; // $5.00 fee

        return fee;
    }

    @Override
    public String toString() {
        return "MovieDVD [ id=" + getID() + ", title=" + getTitle() + ", year="
                + getYear() + ", size=" + size + "MB]";
    }
}

class Manager {

    ArrayList<Media> media = new ArrayList<>();

    public void readData() throws IOException {
        File file = new File("E:\\FavTutorJava\\src\\PRJ4Rentals.txt");
        // Creating an object of BuffferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String st;
        while ((st = br.readLine()) != null) {
            String[] data = null;
            boolean check = true;
            try {
                data = st.split(",");
            } catch (Exception e) {
                check = false;
            }
            if (check && data.length == 7) {
                if (data[2].equals("E")) {

                }
            }
        }
    }
}


//        27631, false, E, The Higher They Fall, 2012, 15, 4.00
//        87324, false, C, Dinner Sounds, 1995, 62, 3.74
//        83924, false, D, The Furious Crew, 2019, 1, 4.75
//        98342, false, E, Never Mind the Clutter, 2018, 45, 7.00
//        37261, false, C, Wake Up Team, 2020, 103, 4.56
//        18725, false, D, Holiday Scene, 2021, 1, 6.50
