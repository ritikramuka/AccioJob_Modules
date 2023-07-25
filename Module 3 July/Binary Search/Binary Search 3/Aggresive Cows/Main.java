import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
	public static boolean isPossible(int[] pos, int minCows, int minDist) {
		int posOfLastCowPlaced = pos[0];
		int numberOfCowsPlaced = 1;

		for (int i = 1; i < pos.length; i++) {
			if (pos[i] - posOfLastCowPlaced >= minDist) {
				posOfLastCowPlaced = pos[i];
				numberOfCowsPlaced += 1;
			}
		}

		return numberOfCowsPlaced >= minCows;
	}

	// TC: O(N * log N), SC: O(1)
    public static int aggressiveCows(int a[],int cows){
	    //Write your code here
		Arrays.sort(a);

		int hi = a[a.length - 1] - a[0];
		int lo = Integer.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
			int dist = a[i] - a[i - 1];
			lo = Math.min(lo, dist);
		}

		int pans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (isPossible(a, cows, mid) == true) {
				pans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
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
