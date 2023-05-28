/**
 * https://course.acciojob.com/idle?question=372f13c7-4b94-475a-a839-8844593b0a1e
 */

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
		System.out.println(new Solution().longestConsecutive(n,a));
	}
}
class Solution {
	// TC: O(N), SC: O(n)
    public int longestConsecutive(int n,int[] nums) {
        //Write code here
		HashSet<Integer> set = new HashSet();
		for (int num : nums) {
			set.add(num);
		}

		int maxLen = 0;
		for (int key : set) {
			if (set.contains(key - 1) == true) {
				continue;
			} else {
				// you are a starting point
				int len = 1;
				int start = key;
				while (set.contains(start + 1) == true) {
					start++;
					len++;
				}
				maxLen = Math.max(maxLen, len);
			}
		}

		return maxLen;
    }
}