/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 03-Aug-21
 *   Time: 7:11 PM
 *   File: BinarySearchTree.java
 */

package august.aug03_21;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    // instance variable
    public Node root;

    // constructor for initialise the root to null BYDEFAULT
    public BinarySearchTree() {
        this.root = null;
    }
    // insert method to insert the new Date
    public void insert(int newData){
        this.root=insert(root, newData);
    }

    private Node insert(Node root, int newData) {
        // Base Case: root is null or not
        if (root == null) {
            // Insert the first node, if root is null.
            root = new Node(newData);
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.getData() >= newData) {
           // if current root data is greater than the new data then now process the left sub-tree
            root.setLeft(insert(root.getLeft(), newData));
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.setRight(insert(root.getRight(), newData));
        }
        return root;
    }

    public void bfs(){
        if(root!=null){
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp!=null){
                    System.out.print(temp.getData()+" ");
                    if(temp.getLeft()!=null){
                        q.add(temp.getLeft());
                    }
                    if(temp.getRight()!=null){
                        q.add(temp.getRight());
                    }
                }
                else if(!q.isEmpty() && temp==null){
                    q.add(null);
                    System.out.println();
                }
            }
        }
        System.out.println();
    }


}

