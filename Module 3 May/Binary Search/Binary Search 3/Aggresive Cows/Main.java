import java.io.*;
import java.util.*;
import java.util.*;

class Solution{

	static boolean isPossible(int[] pos, int numberOfCows, int minDist) {
		int lastPosPlaced = pos[0];
		int cowsPlaced = 1;

		for (int i = 1; i < pos.length; i++) {
			if (pos[i] - lastPosPlaced >= minDist) {
				cowsPlaced++;
				lastPosPlaced = pos[i];
			} 
		}

		return cowsPlaced >= numberOfCows;
	}

	// TC: O(N * log N), SC: O(1)
    public static int aggressiveCows(int a[],int cows){
	    //Write your code here
		Arrays.sort(a);

		int si = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int dist = a[i + 1] - a[i];
			si = Math.min(si, dist);
		}

		int ei = a[a.length - 1] - a[0];

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (isPossible(a, cows, mid) == true) {
				pans = mid;
				// move right
				si = mid + 1;
			} else {
				// move left
				ei = mid - 1;
			}
		}

		return pans;
    }
	
}

class Main {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));

    }
}
