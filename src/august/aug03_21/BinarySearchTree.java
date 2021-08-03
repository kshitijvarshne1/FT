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
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }
    public void insert(int newData){
        this.root=insert(root, newData);
    }

    private Node insert(Node root, int newData) {
        if (root == null) {
            root = new Node(newData);
            return root;
        } else if (root.getData() >= newData) {
            root.setLeft(insert(root.getLeft(), newData));
        } else {
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
    }


}

