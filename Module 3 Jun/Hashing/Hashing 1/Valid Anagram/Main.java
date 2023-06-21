import java.util.*;

class Solution {
	// TC: O(N * log N), SC: O(N)
   // static boolean areAnagram(String c1, String c2) {
       //Write your code here
	   // char[] arr1 = c1.toCharArray();
	   // char[] arr2 = c2.toCharArray();

	   // Arrays.sort(arr1);
	   // Arrays.sort(arr2);

	   // c1 = new String(arr1);
	   // c2 = new String(arr2);

	   // return c1.equals(c2);
    // }

	// TC: O(N), SC: O(N)
	static boolean areAnagram(String c1, String c2) {
	    HashMap<Character, Integer> fmap1 = new HashMap<>();
		for (int i = 0; i < c1.length(); i++) {
			char ch = c1.charAt(i);
			if (fmap1.containsKey(ch) == true) {
				int prevFreq = fmap1.get(ch);
				fmap1.put(ch, prevFreq + 1);
			} else {
				fmap1.put(ch, 1);
			}
		}

		HashMap<Character, Integer> fmap2 = new HashMap<>();
		for (int i = 0; i < c2.length(); i++) {
			char ch = c2.charAt(i);
			if (fmap2.containsKey(ch) == true) {
				int prevFreq = fmap2.get(ch);
				fmap2.put(ch, prevFreq + 1);
			} else {
				fmap2.put(ch, 1);
			}
		}

		if (fmap1.size() != fmap2.size()) {
			return false;
		}

		for (Character key : fmap1.keySet()) {
			if (fmap2.containsKey(key) == true) {
				if (fmap2.get(key) == fmap1.get(key)) {
					continue;
				} else {
					return false;
				}
			} else {
				return false;
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
