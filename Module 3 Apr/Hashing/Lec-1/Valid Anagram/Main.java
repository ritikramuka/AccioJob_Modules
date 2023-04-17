import java.util.*;

class Solution {
	static boolean areAnagram(String c1, String c2) {
	    if (c1.length() != c2.length()) {
			return false;
		}

		HashMap<Character, Integer> fmap1 = new HashMap<>();
		for (int i = 0; i < c1.length(); i++) {
			char ch = c1.charAt(i);
			fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);
		}

		HashMap<Character, Integer> fmap2 = new HashMap<>();
		for (int i = 0; i < c2.length(); i++) {
			char ch = c2.charAt(i);
			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
		}

		for (char ch : fmap1.keySet()) {
			if (fmap2.containsKey(ch) == false) {
				// ch is present as a key in fmap1, but not present as key in fmap2
				return false;
			} else {
				// ch is present as a key in fmap1 and fmap2
				if (fmap1.get(ch) != fmap2.get(ch)) {
					// freq ch in fmap1 != freq of ch in fmap2
					return false;
				}
			}
		}

		return true;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
