import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // write code here
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        String ans = "";
        int dmcnt = t.length();
        int mcnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int inc = -1;
        int exc = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // inc
            while (inc < s.length() - 1 && mcnt < dmcnt) {
                inc++;
                char ch = s.charAt(inc);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) <= freq.getOrDefault(ch, 0)) {
                    mcnt++;
                }

                f1 = true;
            }

            // exc
            while (exc < inc && mcnt == dmcnt) {
                String currAns = s.substring(exc + 1, inc + 1);
                if (ans.length() == 0 || ans.length() > currAns.length()) {
                    ans = currAns;
                }

                exc++;
                char ch = s.charAt(exc);
                map.put(ch, map.getOrDefault(ch, 0) - 1);

                if (freq.containsKey(ch) && freq.get(ch) > map.get(ch)) {
                    mcnt--;
                }

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }

                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s, t));
    }
}