/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 03-Aug-21
 *   Time: 7:10 PM
 *   File: Main.java
 */

package august.aug03_21;

public class Main {
    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(100);
        bst.insert(90);
        bst.insert(110);
        bst.insert(80);
        bst.insert(95);
        bst.insert(105);
        bst.insert(115);
        bst.bfs();
    }
}