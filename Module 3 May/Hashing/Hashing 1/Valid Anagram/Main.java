import java.util.*;

class Solution {

   // // TC: O(N log N), SC: O(N)
   // static boolean areAnagram(String c1, String c2) {
   //     //Write your code here

	  //  char[] arr = c1.toCharArray();
	  //  Arrays.sort(arr);
	  //  c1 = new String(arr);

	  //  arr = c2.toCharArray();
	  //  Arrays.sort(arr);
	  //  c2 = new String(arr);

	  //  if (c1.equals(c2) == true) {
		 //   return true;
	  //  } else {
		 //   return false;
	  //  }
   //  }

	// TC: O(N), SC: O(N)
	static boolean areAnagram(String c1, String c2) {
		if (c1.length() != c2.length()) {
			return false;
		}
		
	    // fmap for c1
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < c1.length(); i++) {
			char ch = c1.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < c2.length(); i++) {
			char ch = c2.charAt(i);
			if (fmap.containsKey(ch) == false) {
				return false;
			} else {
				fmap.put(ch, fmap.get(ch) - 1);
				if (fmap.get(ch) == 0) {
					fmap.remove(ch);
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
