/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 11-Oct-21
 *   Time: 7:25 PM
 *   File: Main.java
 */

package october.oct12_21;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int size = 6;

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        ArrayList<Media> mediaArrayList = new ArrayList<>();
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
                mediaArrayList.add(new EBook(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
            } else if (mediaModel[k].equalsIgnoreCase("C")) {
                mediaArrayList.add(new MusicCD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
            } else if (mediaModel[k].equalsIgnoreCase("D")) {
                mediaArrayList.add(new MovieDVD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
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
                        rentStatus[index3] = currentStatus;
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
                            EBook e = new EBook(idd, title[index1], Integer.parseInt(yearPublished[index1]), scopeMedia[index1]);
                            calculatedFee[index1] = e.calculateRentalFee();
                            System.out.println("Modify Fee " + calculatedFee[index1]);
                        } else if (type1.equalsIgnoreCase("C")) {
                            MusicCD cd = new MusicCD(idd, title[index1], Integer.parseInt(yearPublished[index1]), scopeMedia[index1]);
                            calculatedFee[index1] = cd.calculateRentalFee();
                            System.out.println("Modify Fee " + calculatedFee[index1]);
                        } else if (type1.equalsIgnoreCase("D")) {
                            MovieDVD d = new MovieDVD(idd, title[index1], Integer.parseInt(yearPublished[index1]), scopeMedia[index1]);
                            calculatedFee[index1] = d.calculateRentalFee();
                            System.out.println("Modify Fee " + calculatedFee[index1]);
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
                        Media media = mediaArrayList.get(0);
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
            for (int k = 0; k < size; k++) {
                // store in arrayList
                if (mediaModel[k].equalsIgnoreCase("E")) {
                    mediaArrayList.add(new EBook(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
                } else if (mediaModel[k].equalsIgnoreCase("C")) {
                    mediaArrayList.add(new MusicCD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
                } else if (mediaModel[k].equalsIgnoreCase("D")) {
                    mediaArrayList.add(new MovieDVD(Integer.parseInt(mediaId[k]), title[k], Integer.parseInt(yearPublished[k]), scopeMedia[k]));
                }
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
}

