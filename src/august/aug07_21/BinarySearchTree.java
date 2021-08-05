/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Aug-21
 *   Time: 8:28 PM
 *   File: BinarySearchTree.java
 */

package august.aug07_21;

public class BinarySearchTree {

    public class Node {
        //instance variable of Node class
        public int data;
        public Node left;
        public Node right;

        //constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // instance variable
    public Node root;

    // constructor for initialise the root to null BYDEFAULT
    public BinarySearchTree() {
        this.root = null;
    }

    // insert method to insert the new Date
    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, int newData) {
        // Base Case: root is null or not
        if (root == null) {
            // Insert the new data, if root is null.
            root = new Node(newData);
            // return the current root to his sub tree
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.data >= newData) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
        return root;
    }
    // method to get minimum value in the binary search tree
    // we are assured the minimum value is present is in root data if root is null otherwise
    // it is in left subtree of the binary search tree

    public int findMinimum() {
        if(root==null){
            return -1;
        }
        // processing the left sub tree
        Node current = this.root;
        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }

    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
       BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(100);
        bst.insert(90);
        bst.insert(110);
        bst.insert(80);
        bst.insert(95);
        bst.insert(105);
        bst.insert(115);
        System.out.println(bst.findMinimum());
    }
}


