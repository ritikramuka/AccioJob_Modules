import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
  //   public void TappingWater(int[] arr, int n) {
  //       // TC: O(N), SC: O(N)
		// int[] lmax = new int[n];
		// lmax[0] = 0;
		// for (int i = 1; i < n; i++) {
		// 	lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
		// }

		// // TC: O(N), SC: O(N)
		// int[] rmax = new int[n];
		// rmax[n - 1] = 0;
		// for (int i = n - 2; i >= 0; i--) {
		// 	rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
		// }

		// int totalWater = 0;

		// for (int i = 0; i < n; i++) {
		// 	int heightOfBuilding = arr[i];

		// 	int maxHeightOfWaterAndBuilding = Math.min(lmax[i], rmax[i]);

		// 	if (maxHeightOfWaterAndBuilding > heightOfBuilding) {
		// 		int heightOfWater = maxHeightOfWaterAndBuilding - heightOfBuilding;
		// 		int amountOfWater = heightOfWater * 1;
		// 		totalWater += amountOfWater;
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
				 // left Boundry is limiting, hence working for array of lth index
				 if (LB > arr[l]) {
					 totalWater += (LB - arr[l]) * 1;
				 } else {
					 LB = arr[l];
				 }
				 l++;
			 } else {
				 // RB is limiting
				 if (RB > arr[r]) {
					 totalWater += (RB - arr[r]) * 1;
				 } else {
					 RB = arr[r];
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