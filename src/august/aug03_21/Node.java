/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 03-Aug-21
 *   Time: 7:11 PM
 *   File: Node.java
 */

package august.aug03_21;

public class Node {
    //instance variable of Node class
    private int data;
    private Node left;
    private Node right;

    //constructor
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //All getter and setter methods of the instance variable
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}




