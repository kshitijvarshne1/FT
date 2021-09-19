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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of row and number of seats in one row");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Enter the theater name");
        String tName = sc.next();
        Theater theater = new Theater(n, m, tName);
    }

}

class Theater {
    private final double[][] seats;
    private final String eventName;

    public Theater(int n, int m, String e) {
        this.seats = new double[n][m];
        this.eventName = e;
    }

    public double[][] getSeats() {
        return seats;
    }

    public String getEventName() {
        return eventName;
    }
}

