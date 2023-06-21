import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here

		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int ele : nums) {
			if (fmap.containsKey(ele) == true) {
				int prevFreq = fmap.get(ele);
				fmap.put(ele, prevFreq + 1);
			} else {
				fmap.put(ele, 1);
			}

			if(fmap.get(ele) == k) {
				System.out.println(ele);
				return;
			}
		}

		System.out.println(-1);
		return;
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