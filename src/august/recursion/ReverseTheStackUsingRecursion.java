/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 14-Aug-21
 *   Time: 8:26 PM
 *   File: ReverseTheStack.java
 */

package august.recursion;

import java.util.Stack;

public class ReverseTheStackUsingRecursion {
    public static void main(String[] args) {
        //Initialise the stack
        Stack<Integer> s = new Stack<>();
        //push some element
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // call the method reverseTheStack to reverse the stack
        reverseTheStack(s);
        // print the stack value after reversing the stack
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    private static void reverseTheStack(Stack<Integer> s) {
        // Base Condition
        if (s.size() == 0) {
            return;
        }
        // get the top most element from the stack
        int temp = s.peek();
        s.pop();
        // recursively call the method with stack s
        reverseTheStack(s);
        // call the method insertAtBottom
        // it is used to insert the temp value to the bottom of stack recursively
        insertAtBottom(s, temp);
        return;
    }


    private static void insertAtBottom(Stack<Integer> s, int ele) {
        // Base condition
        if (s.size() == 0) {
            // if stack is empty then simply push the ele into the stack
            s.push(ele);
            return;
        }
        // get the topmost element from the stack
        int temp = s.peek();
        // remove from stack
        s.pop();
        // recursively the call the method
        insertAtBottom(s, ele);
        s.push(temp);
    }
}

