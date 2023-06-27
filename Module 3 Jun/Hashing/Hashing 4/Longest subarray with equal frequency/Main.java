import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
    public static int longestSubarray(int[] arr){
        // write code here

		int cnt0 = 0;
		int cnt1 = 0;
		int cnt2 = 0;

		HashMap<String, Integer> map = new HashMap<>();

		String code = (cnt1 - cnt0) + "," + (cnt2 - cnt1);
		map.put(code, -1);

		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				cnt0++;
			} else if (arr[i] == 1) {
				cnt1++;
			} else if (arr[i] == 2) {
				cnt2++;
			}

			code = (cnt1 - cnt0) + "," + (cnt2 - cnt1);

			if (map.containsKey(code) == true) {
				int len = i - map.get(code);
				maxLen = Math.max(maxLen, len);
			} else {
				map.put(code, i);
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
