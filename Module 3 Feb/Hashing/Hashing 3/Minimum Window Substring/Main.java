import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String str1, String str2) {
        // create freqmap for str2;
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (char ch : str2.toCharArray()) {
            freq2.put(ch, freq2.getOrDefault(ch, 0) + 1);
        }

        // get desired match count
        int dmcnt = str2.length();

        // people I have matched till now
        int mcnt = 0;

        // smallest substring window
        String ans = "";

        // HashMap for each char -> freq in str1
        HashMap<Character, Integer> freq1 = new HashMap<>();

        int inc = -1;
        int exc = -1;

        while (true) {
            boolean f1 = false;

            // when including
            while (inc + 1 < str1.length() && mcnt < dmcnt) {
                // move inc to the index which has to be included
                inc = inc + 1;

                char ch = str1.charAt(inc);
                freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);

                if (freq2.containsKey(ch) == true && freq1.get(ch) <= freq2.get(ch)) {
                    mcnt++;
                }

                f1 = true;
            }

            boolean f2 = false;

            // when excluding
            while (exc < inc && mcnt == dmcnt) {
                // got a potential ans
                String pans = str1.substring(exc + 1, inc + 1);
                if (ans.length() == 0 || ans.length() > pans.length()) {
                    ans = pans;
                }

                // got to index to exc
                exc = exc + 1;

                char ch = str1.charAt(exc);
                freq1.put(ch, freq1.get(ch) - 1);

                if (freq2.containsKey(ch) && freq1.get(ch) < freq2.get(ch)) {
                    mcnt--;
                }

                if (freq1.get(ch) == 0) {
                    freq1.remove(ch);
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