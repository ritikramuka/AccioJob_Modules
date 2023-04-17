import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
		
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int ele : nums) {
			fmap.put(ele, fmap.getOrDefault(ele, 0) + 1);
			if (fmap.get(ele) == k) {
				System.out.println(ele);
				return;
			}
		}

		System.out.println(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}