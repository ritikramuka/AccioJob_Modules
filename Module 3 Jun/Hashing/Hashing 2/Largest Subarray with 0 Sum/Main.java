import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
   public int maxLen(int arr[])
	{
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, -1);

		int sum = 0;
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum) == true) {
				int len = i - map.get(sum);
				maxLen = Math.max(len, maxLen);
			} else {
				map.put(sum, i);
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
