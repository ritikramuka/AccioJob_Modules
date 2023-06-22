import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		// write code here
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int ele : arr) {
			int rem = ele % k;
			fmap.put(rem, fmap.getOrDefault(rem, 0) + 1);
		}

		for (int rem : fmap.keySet()) {
			if (rem == 0) {
				if (fmap.get(rem) % 2 != 0) {
					return false;
				}
			} else {
				int compRem = k - rem;
				if (fmap.containsKey(compRem) == false) {
					return false;
				} else {
					if (fmap.get(rem) != fmap.get(compRem)) {
						return false;
					}
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