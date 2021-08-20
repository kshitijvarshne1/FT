/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Aug-21
 *   Time: 8:13 PM
 *   File: BinarySearchTree.java
 */

package august.aug06_21;

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
    // method to get maximum value in the binary search tree
    // we are assured the maximum value is present is in root data if root is null otherwise
    // it is in right subtree of the binary search tree

    public int findMaximum() {
       if(root==null){
           return -1;
       }
       // processing the right sub tree
        Node current = this.root;
        while (current.right != null) {
            current = current.right;
        }
        return (current.data);
    }

    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(8);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(9);
        System.out.println(bst.findMaximum());
    }
}





