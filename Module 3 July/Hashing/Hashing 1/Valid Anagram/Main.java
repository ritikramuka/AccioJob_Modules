import java.util.*;

class Solution {
	// TC: O(N), SC: O(N) 
	static boolean areAnagram(String c1, String c2) {
       // Write your code here

	   // TC: O(N), SC: O(N)
	   HashMap<Character, Integer> fmap1 = new HashMap();
	   for (char ch : c1.toCharArray()) {
		   fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);
	   }

	   // TC: O(N), SC: O(N)
	   HashMap<Character, Integer> fmap2 = new HashMap();
	   for (char ch : c2.toCharArray()) {
		   fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
	   }

	   // TC: O(26) ~ O(1), SC: O(1)
	   for (int i = 0; i < 26; i++) {
		   char ch = (char)('a' + i);
		   if (fmap1.getOrDefault(ch, 0) != fmap2.getOrDefault(ch, 0)) {
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
