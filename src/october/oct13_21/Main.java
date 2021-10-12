/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 10:05 PM
 *   File: Main.java
 */

package october.oct13_21;


import october.oct12_21.Media;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static final int size = 6;

    public static void main(String[] args) throws IOException {
        october.oct12_21.Manager manager = new october.oct12_21.Manager();
        ArrayList<october.oct12_21.Media> mediaArrayList = new ArrayList<>();
        // creating array
        String[] mediaId = new String[size];
        Boolean[] rentStatus = new Boolean[size];
        String[] mediaModel = new String[size];
        String[] title = new String[size];
        String[] yearPublished = new String[size];
        int[] scopeMedia = new int[size];
        double[] calculatedFee = new double[size];
        // initialise the file path
        File file = new File("C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\october\\oct12_21\\PRJ4Rentals.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        String st;
        int i = 0;
        // reading the data
        while ((st = br.readLine()) != null) {
            st = st.replace(",", "----");
            String[] inp = st.split("----");
            for (int j = 0; j < inp.length; j++) {
                inp[j] = inp[j].trim();
            }
            // store in arrays
            mediaId[i] = inp[0];
            rentStatus[i] = Boolean.parseBoolean(inp[1]);
            mediaModel[i] = inp[2];
            title[i] = inp[3];
            yearPublished[i] = inp[4];
            scopeMedia[i] = Integer.parseInt(inp[5]);
            calculatedFee[i] = Double.parseDouble(inp[6]);
            i++;
        }
        int size = i;
        // print the data
        System.out.printf("%-15s %-15s %-15s %-30s %-15s %-15s %-15s \n", "ID", "Rent", "Type", "Title", "Pub", "Scope", "Rental Fee");
        for (int k = 0; k < size; k++) {
            System.out.printf("%-15s %-15s %-15s %-30s %-15s %-15s %-15s \n", mediaId[k], rentStatus[k], mediaModel[k], title[k], yearPublished[k], scopeMedia[k], calculatedFee[k]);
            // store in arrayList
            if (mediaModel[k].equalsIgnoreCase("E")) {
                mediaArrayList.add(new october.oct12_21.EBook(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
            } else if (mediaModel[k].equalsIgnoreCase("C")) {
                mediaArrayList.add(new october.oct12_21.MusicCD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
            } else if (mediaModel[k].equalsIgnoreCase("D")) {
                mediaArrayList.add(new october.oct12_21.MovieDVD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
            }
        }
        // load the Media object by Manager class
        manager.loadMediaObject(mediaArrayList);
        // creating the object of Scanner class to input the data
        Scanner sc = new Scanner(System.in);
        // creating the menu selection program
        while (true) {
            showOption();
            int option = sc.nextInt();
            // switch case to choose specific option
            switch (option) {
                case 1:
                    System.out.println("Enter the type of Media");
                    sc.nextLine();
                    String type = sc.nextLine();
                    System.out.println("Enter the id");
                    int id = sc.nextInt();
                    System.out.println("Enter the Name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter the year");
                    int year = sc.nextInt();
                    System.out.println("Enter the scope according to type");
                    int scope = sc.nextInt();
                    manager.addMedia(type, id, name, year, scope);
                    System.out.println("Media is added");
                    break;
                case 2:
                    System.out.println("Enter the id");
                    int findId = sc.nextInt();
                    manager.findMedia(findId);
                    break;
                case 3:
                    System.out.println("Enter the id");
                    int deleteId = sc.nextInt();
                    manager.deleteId(deleteId);
                    break;
                case 4:
                    System.out.println("Enter the id");
                    int in2 = sc.nextInt();
                    System.out.println("Enter the current Status");
                    boolean currentStatus = sc.nextBoolean();
                    int index3 = manager.rent(in2);
                    if (index3 == -1) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Status updated");
                    }
                    break;
                case 5:
                    System.out.println("Enter the id");
                    int idd = sc.nextInt();
                    System.out.println("Enter the scope value");
                    int scopeValue = sc.nextInt();
                    System.out.println("Enter the type");
                    sc.nextLine();
                    String type1 = sc.nextLine();
                    int index1 = manager.modify(idd);
                    if (index1 != -1) {
                        if (type1.equalsIgnoreCase("E")) {
                            october.oct12_21.Media eee= mediaArrayList.get(index1);
                            System.out.println("Modify Fee " + eee.calculateRentalFee());
                        } else if (type1.equalsIgnoreCase("C")) {
                               october.oct12_21.MusicCD cd= (october.oct12_21.MusicCD) mediaArrayList.get(index1);
                            System.out.println("Modify Fee " + cd.calculateRentalFee());

                        } else if (type1.equalsIgnoreCase("D")) {
                            MovieDVD d= (MovieDVD) mediaArrayList.get(index1);
                            System.out.println("Modify Fee " + d.calculateRentalFee());
                        }

                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 6:
                    System.out.println("Enter 1 for display one item only else enter any number");
                    int in = sc.nextInt();
                    if (in == 1) {
                        System.out.printf("%-15s %-30s %-15s %-15s \n", "Ids", "Title", "Year", "Rental Fee");
                        october.oct12_21.Media media = mediaArrayList.get(0);
                        System.out.printf("%-15s %-30s %-15s %-15s \n", media.getId(), media.getTitle(), media.getYearPublished(), media.calculateRentalFee());
                    } else {
                        manager.showData();
                    }
                    break;
                case 7:
                    System.out.println("Thanks for here");
                    System.exit(1);
                    break;
            }
            manager.loadMediaObject(mediaArrayList);
        }
    }


    public static void showOption() {
        System.out.println("1. Add\n" +
                "2. Find\n" +
                "3. Remove\n" +
                "4. Rent\n" +
                "5. Modify\n" +
                "6. Display\n" +
                "7. Exit");
    }

    abstract class Media {
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

    class MusicCD extends october.oct12_21.Media {
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

    class MovieDVD extends october.oct12_21.Media {
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

    class EBook extends october.oct12_21.Media {
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

        // calculateRentalFee method
        public double calculateRentalFee() {
            double fee = this.numberOfChapter * 0.10 + 1.00; // basic fee
            int currYear = Calendar.getInstance().get(Calendar.YEAR);
            // add $1.00 fee if current year is same as published year
            if (this.getYearPublished() == currYear) {
                fee += 1.00;
            }
            return fee;
        }

        @Override
        public String toString() {
            return "EBook [ id=" + getId() + ", title=" + getTitle() + ", year=" + getYearPublished() + ", chapters=" + getNumberOfChapter() + "]";
        }
    }

    class Manager {
        private ArrayList<october.oct12_21.Media> mediaArrayList;

        public Manager() {
            mediaArrayList = new ArrayList<>();
        }

        // method to load media object
        public void loadMediaObject(ArrayList<october.oct12_21.Media> mediaList) throws IOException {
            setMediaArrayList(mediaList);
        }

        // getter and setter
        public ArrayList<october.oct12_21.Media> getMediaArrayList() {
            return mediaArrayList;
        }

        public void setMediaArrayList(ArrayList<october.oct12_21.Media> mediaArrayList) {
            this.mediaArrayList = mediaArrayList;
        }

        // method to show the media data
        public void showData() {
            System.out.printf("%-15s %-30s %-15s %-15s \n", "Ids", "Title", "Year", "Rental Fee");

            for (october.oct12_21.Media media : mediaArrayList) {
                System.out.printf("%-15s %-30s %-15s %-15s \n", media.getId(), media.getTitle(), media.getYearPublished(), media.calculateRentalFee());
            }
        }

        public void addMedia(String type, int id, String name, int year, int scope) {
            if (type.equalsIgnoreCase("E")) {
                mediaArrayList.add(new october.oct12_21.EBook(id, name, year, scope));
            } else if (type.equalsIgnoreCase("C")) {
                mediaArrayList.add(new october.oct12_21.MusicCD(id, name, year, scope));
            } else if (type.equalsIgnoreCase("D")) {
                mediaArrayList.add(new october.oct12_21.MovieDVD(id, name, year, scope));
            }
        }

        // method to find media
        public void findMedia(int findId) {
            for (october.oct12_21.Media m : mediaArrayList) {
                if (m.getId() == findId) {
                    october.oct12_21.Media media = m;
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
            for (october.oct12_21.Media m : mediaArrayList) {
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
            for (october.oct12_21.Media m : mediaArrayList) {
                if (m.getId() == idd) {
                    return k;
                }
                k++;
            }
            return -1;
        }

        public int rent(int in2) {
            int k = 0;
            for (october.oct12_21.Media m : mediaArrayList) {
                if (m.getId() == in2) {
                    return k;
                }
                k++;
            }
            return -1;
        }
    }
}

