import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(K)
    public boolean arrayPairs(int[] arr, int k) {
		// write code here
		HashMap<Integer, Integer> fmap = new HashMap<>();
		
		// step 1: create a fmap of rem
		for (int ele : arr) {
			int rem = ele % k;
			fmap.put(rem, fmap.getOrDefault(rem, 0) + 1);
		}

		// step 2: verify, that do you have equal number of comp rem to neutralize yourself
		for (int rem : fmap.keySet()) {
			int compRem = k - rem;

			if (rem == 0) {
				if (fmap.get(rem) % 2 != 0) {
					// you have odd number of people with rem 0
					return false;
				}
			} else {
				if (fmap.get(rem) != fmap.getOrDefault(compRem, 0)) {
					return false;
				}
			}
		}

		return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
		k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
    }
}