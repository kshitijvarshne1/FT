/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 12-Aug-21
 *   Time: 10:55 PM
 *   File: SortAnArrayUsingRecursion.java
 */

package august.recursion;

public class SortAnArrayUsingRecursion {
    public static void main(String[] args) {
        // array
        int[] arr = {5, 1, 8, 3, 4, 7, 22, 444, 2, -1};

        // print the unsorted array
        System.out.println("UnSsorted Array :- ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // call the sort array method
        sortArray(arr, 0, arr.length - 1);

        // print the sorted array
        System.out.println("Sorted Array :- ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortArray(int[] arr, int start, int end) {
        // base Condition
        if (start == end) {
            return;
        }
        int maxIndex = findMax(arr, start, end);
        // swap the maxIndex value with high index value
        // move highest value to the end of array
        swap(arr, maxIndex, end);
        // Recursively call the sortArray method
        sortArray(arr, start, end - 1);
    }

    // method for swapping the value
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // method to find the index of highest value
    public static int findMax(int[] arr, int start, int end) {
        int max = arr[start];
        int index = start;
        for (; start <= end; start++)
            if (max < arr[start]) {
                max = arr[start];
                index = start;
            }
        return index;
    }
}