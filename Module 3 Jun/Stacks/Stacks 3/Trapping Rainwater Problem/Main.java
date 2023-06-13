import java.io.*;
import java.util.*;

class Solution {
	// // TC: O(N^2), SC: O(1)
 //    public void TappingWater(int[] arr, int n) {
 //        //Write code here and print output
		
	// 	int amtOfWater = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		int lmax = 0;
	// 		// left side 0 -> i - 1
	// 		for (int j = 0; j <= i - 1; j++) {
	// 			lmax = Math.max(lmax, arr[j]);
	// 		}

	// 		int rmax = 0;
	// 		// right side i + 1 -> n - 1
	// 		for (int j = i + 1; j <= n - 1; j++) {
	// 			rmax = Math.max(rmax, arr[j]);
	// 		}

	// 		// height of water plus building
	// 		int totalHeight = Math.min(lmax, rmax);

	// 		if (totalHeight > arr[i]) {
	// 			int waterHeight = totalHeight - arr[i];
	// 			amtOfWater += (waterHeight * 1);
	// 		}
	// 	}

	// 	System.out.println(amtOfWater);
 //    }

	// TC: O(N), SC: O(N)
	// public void TappingWater(int[] arr, int n) {
 //        //Write code here and print output
		
	// 	// get rmax array
	// 	int [] rmax = new int [n];
	// 	rmax[n - 1] = 0;
	// 	for (int i = n - 2; i >= 0; i--) {
	// 		rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
	// 	}

	// 	// get lmax array
	// 	int [] lmax = new int [n];
	// 	lmax[0] = 0;
	// 	for (int i = 1; i < n; i++) {
	// 		lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
	// 	}

	// 	int amtOfWater = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		// height of water plus building
	// 		int totalHeight = Math.min(lmax[i], rmax[i]);

	// 		if (totalHeight > arr[i]) {
	// 			int waterHeight = totalHeight - arr[i];
	// 			amtOfWater += (waterHeight * 1);
	// 		}
	// 	}

	// 	System.out.println(amtOfWater);
 //    }

	// TC: O(N), SC: O(1)
	public void TappingWater(int[] arr, int n) {
        //Write code here and print output
		int LB = arr[0];
		int RB = arr[n - 1];
		int l = 1;
		int r = n - 2;

		int amtOfWater = 0;

		while (l <= r) {
			if (LB <= RB) {
				int totalHeight = LB;

				if (totalHeight > arr[l]) {
					int waterHeight = totalHeight - arr[l];
					amtOfWater += (waterHeight * 1);
				}

				LB = Math.max(arr[l], LB);
				l++;
			} else {
				int totalHeight = RB;

				if (totalHeight > arr[r]) {
					int waterHeight = totalHeight - arr[r];
					amtOfWater += (waterHeight * 1);
				}

				RB = Math.max(arr[r], RB);
				r--;
			}
		}

		System.out.println(amtOfWater);
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