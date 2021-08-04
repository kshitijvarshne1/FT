/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Aug-21
 *   Time: 11:21 AM
 *   File: BinarySearchTree.java
 */

package august.aug04_21;

public class BinarySearchTree {
    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Node root;
    public BinarySearchTree(){
        this.root=null;
    }

    public static void main(String[] args) {

    }
}

