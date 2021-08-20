/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 07-Aug-21
 *   Time: 7:24 PM
 *   File: BinarySearchTree.java
 */

package august.aug10_21;

public class BinarySearchTree {
    public static class Node {
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

    /*
     * Case 1:- No child
     * Case 2:- 1 child
     * case 3:- 2 child
     * */
    public void deleteANode(Node node) {
        deleteNode(this.root, node);
    }

    private Node deleteNode(Node root, Node node) {
        // check for node initially
        if (root == null) {
            return null;
        } else if (node.data < root.data) {
            // process the left sub tree
            root.left = deleteNode(root.left, node);
        } else if (node.data > root.data) {
            // process the right sub tree
            root.right = deleteNode(root.right, node);
        } else if(root.data==node.data){
            // case 3: 2 child
            if (root.left != null && root.right != null) {
                int lmax = findMaxData(root.left);
                root.data = lmax;
                root.left = deleteNode(root.left, new Node(lmax));
                return root;
            }
            //case 2: one child
            // case i-> has only left child
            else if (root.left != null) {
                return root.left;
            }
            // case ii-> has only right child
            else if (root.right != null) {
                return root.right;
            }
            //case 1:- no child
            else {
                return null;
            }
        }
        return root;
    }

    // inorder successor of given node
    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.data;
        }
    }

    public void preorder(){
        preorder(root);
        System.out.println();
    }
    public void preorder(Node node){
        if(node!=null){
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }


    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(8);
        bst.insert(5);
        bst.insert(9);
        bst.insert(3);
        bst.insert(7);
        bst.preorder();
        bst.deleteANode(new Node(9));
        bst.preorder();
    }
}


