/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 19-Sep-21
 *   Time: 10:18 AM
 *   File: Main.java
 */

package september.sep19_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a variable price
        final int price = 540;
        // scanner class to input the data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of row and number of seats in one row");
        // input the dimension of theater
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Enter the theater name");
        // input the theater name
        String tName = sc.next();
        // create the object of Theater class and initialize the instance variable of Theater class
        Theater theater = new Theater(n, m, tName);
        // initialize all the seats with the price
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                theater.getSeats()[i][i1] = price;
            }
        }
        while (true) {
            // method to show the options
            show();
            // input the option
            int option = sc.nextInt();
            switch (option) {
                // case 1:
                // check for price
                case 1:
                    System.out.println("Seat price for all seats is:-  " + price);
                    break;
                // case 2:
                // check for seat number. Is seat is vacant or not
                case 2:
                    System.out.println("Enter the seat number x? and y?");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if (x < n && y < m) {
                        if(theater.getSeats()[x][y]==0){
                            System.out.print("Booked ");
                        }
                        else if(theater.getSeats()[x][y]==-1){
                            System.out.print("Not available");
                        }
                        else{
                            System.out.print("Vacant ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Seat number is invalid");
                    }
                    break;
                // case 3:
                // check the how many seats we can booked in specific price
                case 3:
                    System.out.println("Enter the price");
                    int p = sc.nextInt();
                    if (p >= price) {
                        System.out.println(p / price + " seat available for this price");
                    }
                    break;
                // case 4:
                // booking the seat
                case 4:
                    System.out.println("Enter the no of ticket you want ");
                    int ti = sc.nextInt();
                    if (ti > 6) {
                        System.out.println("upper limit crossed!!!");
                    } else {
                        for (int i = 0; i < ti; i++) {
                            System.out.println("enter seat number");
                            // input the seat number
                            int xx = sc.nextInt();
                            int yy = sc.nextInt();
                            // checking the seat for booking , Is seat is available or not
                            if (xx - 1 >= 0 && yy - 1 >= 0 && xx + 1 < n && yy + 1 < m && theater.getSeats()[xx - 1][yy - 1] != 0 && theater.getSeats()[xx + 1][yy + 1] != 0) {
                                theater.getSeats()[xx][yy] = 0;
                                theater.getSeats()[xx - 1][yy - 1] = -1;
                                theater.getSeats()[xx + 1][yy + 1] = -1;

                            }
                            else{
                                System.out.println("Not available");
                            }
                        }
                    }
                    break;
                //case 5:
                // print the seat map with mentioned the seat is booked or not
                case 5:
                    for (int i = 0; i <n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(theater.getSeats()[i][j]==0){
                                System.out.print("X ");
                            }
                            else if(theater.getSeats()[i][j]==-1){
                                System.out.print("U ");
                            }
                            else{
                                System.out.print("O ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                // case 6:
                // exit the program
                case 6:
                    System.out.println("Thanks for here!!!!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid choice !!!!!!");
                    break;
            }
        }
    }

    // method to show the options
    public static void show() {
        System.out.println("1. show seat price\n" +
                "2. find the seat by sear number(row and column)\n" +
                "3. find available seats by price\n" +
                "4. purchase the tickets\n" +
                "5. print the seating chart\n" +
                "6. exit");
    }

}
// class called Theater
class Theater {
    // instance variable of the class
    private final double[][] seats;
    private final String eventName;

    // constructor
    public Theater(int n, int m, String e) {
        this.seats = new double[n][m];
        this.eventName = e;
    }

    // getter and setter method
    public double[][] getSeats() {
        return seats;
    }

    public String getEventName() {
        return eventName;
    }
}

