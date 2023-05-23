import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
	public int maxLen(int arr[])
	{
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();

		int psum = 0;
		map.put(psum, -1);

		int maxLen = 0;

		for (int i = 0; i < arr.length; i++) {
			psum += arr[i];

			if (map.containsKey(psum) == true) {
				int firstOcc = map.get(psum);
				int len = i - firstOcc;
				maxLen = Math.max(maxLen, len);
			} else {
				map.put(psum, i);
			}
		}

		return maxLen;
	}
}

class Main {
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution Obj = new Solution();
		System.out.println(Obj.maxLen(nums));
	}
}
