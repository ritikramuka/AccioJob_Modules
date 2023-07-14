import java.io.*;
import java.util.*;

class Solution {
	// // TC: O(N), SC: O(N)
 //    public void TappingWater(int[] arr, int n) {
 //        // step 1: get lmax array
	// 	int[] lmax = new int[n];
	// 	lmax[0] = 0;
	// 	for (int i = 1; i < n; i++) {
	// 		lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
	// 	}

	// 	// step 2: get rmax array
	// 	int[] rmax = new int[n];
	// 	rmax[n - 1] = 0;
	// 	for (int i = n - 2; i >= 0; i--) {
	// 		rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
	// 	}

	// 	int amtOfWater = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		int heightOfBuilding = arr[i];

	// 		int totalHeight = Math.min(lmax[i], rmax[i]);

	// 		if (totalHeight > heightOfBuilding) {
	// 			int heightOfWater = totalHeight - heightOfBuilding;
	// 			amtOfWater += (heightOfWater * 1);
	// 		}
	// 	}

	// 	System.out.println(amtOfWater);
 //    }

	// TC: O(N), SC: O(1)
    public void TappingWater(int[] arr, int n) {
		int l = 1;
		int r = n - 2;

		int LB = 0;
		int RB = n - 1;

		int totalWater = 0;

		while (l <= r) {
			if (arr[LB] <= arr[RB]) {
				if (arr[l] < arr[LB]) {
					int w = arr[LB] - arr[l];
					totalWater += w;
				} else {
					LB = l;
				}
				l++;
			} else {
				if (arr[r] < arr[RB]) {
					int w = arr[RB] - arr[r];
					totalWater += w;
				} else {
					RB = r;
				}
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