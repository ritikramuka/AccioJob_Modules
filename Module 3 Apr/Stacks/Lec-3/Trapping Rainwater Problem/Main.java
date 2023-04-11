import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
  //   public void TappingWater(int[] arr, int n) {
  //       //Write code here and print output

		// // step 1: get lmax[]
		// int[] lmax = new int[n];
		// int lb = Integer.MIN_VALUE;
		// for (int i = 0; i < n; i++) {
		// 	lmax[i] = lb;
		// 	lb = Math.max(lb, arr[i]);
		// }

		// // step 2: get rmax[]
		// int[] rmax = new int[n];
		// int rb = Integer.MIN_VALUE;
		// for (int i = n - 1; i >= 0; i--) {
		// 	rmax[i] = rb;
		// 	rb = Math.max(rb, arr[i]);
		// }

		// // step 3: calc. water above each building
		// int totalWater = 0;
		// for (int i = 0; i < n; i++) {
		// 	int hw = Math.min(lmax[i], rmax[i]);
		// 	if (arr[i] < hw) {
		// 		int ahw = hw - arr[i];
		// 		totalWater += (ahw * 1);
		// 	}
		// }

		// System.out.println(totalWater);
  //   }

	// TC: O(N), SC: O(1)
	public void TappingWater(int[] arr, int n) {
        int LB = arr[0];
		int RB = arr[n - 1];

		int l = 1;
		int r = n - 2;

		int totalWater = 0;
		while (l <= r) {
			if (LB <= RB) {
				int hw = LB;
				if (hw > arr[l]) {
					int ahw = hw - arr[l];
					totalWater += (ahw * 1);
				}
				LB = Math.max(LB, arr[l]);
				l++;
			} else {
				int hw = RB;
				if (hw > arr[r]) {
					int ahw = hw - arr[r];
					totalWater += (ahw * 1);
				}
				RB = Math.max(RB, arr[r]);
				r--;
			}
		}

		System.out.println(totalWater);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}