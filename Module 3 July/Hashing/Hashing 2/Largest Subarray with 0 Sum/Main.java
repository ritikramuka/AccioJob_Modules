import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
	public int maxLen(int arr[])
	{
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap();
		map.put(0, -1);

		int runningSum = 0;
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			runningSum += num;
			if (map.containsKey(runningSum) == false) {
				map.put(runningSum, i);
			} else {
				int len = i - map.get(runningSum);
				maxLen = Math.max(maxLen, len);
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
