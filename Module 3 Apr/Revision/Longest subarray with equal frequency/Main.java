import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
    public static int longestSubarray(int[] arr){
        // write code here
		int n = arr.length;
		int x1 = 0, x2 = 0, x0 = 0;
		HashMap<String, Integer> map = new HashMap<>();
		String key = (x1 - x0) + "$" + (x2 - x1);
		map.put(key, -1);

		int maxLen = 0;
        for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				x0++;
			} else if (arr[i] == 1) {
				x1++;
			} else if (arr[i] == 2) {
				x2++;
			}

			key = (x1 - x0) + "$" + (x2 - x1);
			if (map.containsKey(key) == true) {
				int len = i - map.get(key);
				maxLen = Math.max(maxLen, len);
			} else {
				map.put(key, i);
			}
		} 

		return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
