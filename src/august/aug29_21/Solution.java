/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 29-Aug-21
 *   Time: 1:17 PM
 *   File: Solution.java
 */

package august.aug29_21;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sol sol = new Sol();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] tasks = new int[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = sc.nextInt();
            }
            int sessionTime = sc.nextInt();
            System.out.println(sol.minSessions(tasks, sessionTime));
        }
    }

    static class Sol {
        int res;
        int maxSessionTime;
        int[] tasks;
        int[] sessions;

        public int minSessions(int[] tasks, int sessionTime) {
            reverseSort(tasks);
            this.res = tasks.length;
            this.maxSessionTime = sessionTime;
            this.tasks = tasks;
            this.sessions = new int[tasks.length];
            dfs(0, 0);
            return res;
        }

        private void dfs(int taskID, int sessionCount) {
            if (sessionCount > res) return; //prune, if we didn't use prune, it will be 2200ms, if lucky you get ac
            if (taskID == tasks.length) {
                res = Math.min(res, sessionCount);
                return;
            }
            for (int i = 0; i < sessionCount; i++)
                if (sessions[i] + tasks[taskID] <= maxSessionTime) { //put task into old session bucket
                    sessions[i] += tasks[taskID];
                    dfs(taskID + 1, sessionCount);
                    sessions[i] -= tasks[taskID];
                }
            sessions[sessionCount] += tasks[taskID]; //put task into new empty session bucket
            dfs(taskID + 1, sessionCount + 1);
            sessions[sessionCount] -= tasks[taskID];
        }

        //optional, it just speed up from 68ms to 1ms
        private void reverseSort(int[] tasks) {
            Arrays.sort(tasks);
            int[] a = new int[tasks.length];
            for (int i = 0; i < tasks.length; i++)
                a[i] = tasks[tasks.length - 1 - i];
            for (int i = 0; i < tasks.length; i++)
                tasks[i] = a[i];
        }

    }
}

