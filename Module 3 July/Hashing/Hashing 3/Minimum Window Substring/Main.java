import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(26) ~ O(1)
    public String minWindow(String s, String t) {
		// write code here

		HashMap<Character, Integer> fmap2 = new HashMap();
		for (char ch : t.toCharArray()) {
			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
		}

		int mcnt = t.length();
		int dmcnt = 0;

		HashMap<Character, Integer> fmap1 = new HashMap();

		int inc = -1;
		int exc = -1;

		String ans = "";

		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;
			
			if (inc + 1 < s.length() && mcnt > dmcnt) {
				inc++;

				char ch = s.charAt(inc);
				fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

				if (fmap1.get(ch) <= fmap2.getOrDefault(ch, 0)) {
					dmcnt++;
				}

				flag1 = true;
			}

			if (exc < inc && mcnt == dmcnt) {
				String window = s.substring(exc + 1, inc + 1);
				if(ans == "" || ans.length() > window.length()) {
					ans = window;
				}
				
				exc++;

				char ch = s.charAt(exc);
				fmap1.put(ch, fmap1.get(ch) - 1);

				if (fmap2.containsKey(ch) && fmap1.get(ch) < fmap2.get(ch)) {
					dmcnt--;
				}

				if (fmap1.get(ch) == 0) {
					fmap1.remove(ch);
				}

				flag2 = true;
			}

			if (flag1 == false && flag2 == false) {
				break;
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}