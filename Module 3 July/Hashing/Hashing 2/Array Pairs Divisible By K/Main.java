import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		// write code here

		HashMap<Integer, Integer> fmap = new HashMap();
		for (int num : arr) {
			int r = num % k;
			fmap.put(r, fmap.getOrDefault(r, 0) + 1);
		}

		for (int r : fmap.keySet()) {
			if (r == 0) {
				if (fmap.get(r) % 2 != 0) {
					return false;
				}
			} else {
				int cr = k - r;
				if (fmap.get(r) != fmap.getOrDefault(cr, 0)) {
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