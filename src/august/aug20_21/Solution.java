/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 20-Aug-21
 *   Time: 7:32 PM
 *   File: Solution.java
 */

package august.aug20_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        HashMap<Character, Integer> g = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (g.containsKey(s.charAt(i)) == true) {
                g.put(s.charAt(i), g.get(s.charAt(i)) + 1);
            } else {
                g.put(s.charAt(i), 1);
            }
        }
        int dist = g.size();
        int mask = 0;
        ArrayList<Pair> order = new ArrayList<>();
        for (int i = n - 1; i >= 0; --i) {
            if ((mask & (1 << (s.charAt(i) - 'a'))) == 0) {
                mask |= (1 << (s.charAt(i) - 'a'));
                order.add(new Pair(i, s.charAt(i)));
            }
        }

        Collections.reverse(order);
        int sze = 0;
        for (int i = 1; i <= dist; ++i) {
            if (g.get(order.get(i - 1).b) % i == 1) {
                System.out.println("-1");
                return;
            }
            sze += g.get(order.get(i - 1).b) / i;
        }

        String ans = s.substring(0, sze);
        String chk = ans;
        String t = "";
        for (int i = 0; i < dist; ++i) {
            t += chk;
            String tmp = "";
            for (int j = 0; j < chk.length(); ++j) {
                if (chk.charAt(j) != order.get(i).b) {
                    tmp += String.valueOf(chk.charAt(i));
                }
            }

            chk = tmp;
        }

        if (s != t) {
            System.out.println(-1);
            return;
        }
        String ordr = "";
        for (int i = 0; i < dist; ++i) {
            ordr += (order.get(i).b);
        }
        System.out.println(ans + " " + ordr);
    }

    static class Pair {
        int a;
        char b;

        public Pair(int a, char b) {
            this.a = a;
            this.b = b;
        }
    }
}

