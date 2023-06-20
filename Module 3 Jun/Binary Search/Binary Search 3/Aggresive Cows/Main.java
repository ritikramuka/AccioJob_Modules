import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(1)
	public static boolean isPossible(int[] pos, int maxCows, int minDist) {
		int posOfLastCowPlaced = pos[0];
		int numberOfCowsPlaced = 1;

		for (int i = 1; i < pos.length; i++) {
			if (pos[i] - posOfLastCowPlaced >= minDist) {
				// yes you can place a cow at this pos
				numberOfCowsPlaced++;
				posOfLastCowPlaced = pos[i];
			}
		}

		return numberOfCowsPlaced >= maxCows;
	}

	// TC: O(N * log N), SC: O(1)
    public static int aggressiveCows(int pos[],int cows){
	    //Write your code here
		// TC: O(N*log N)
		Arrays.sort(pos);

		// min dist between two consecutive stables
		int si = Integer.MAX_VALUE;
		for (int i = 0; i < pos.length - 1; i++) {
			int dist = pos[i + 1] - pos[i];
			si = Math.min(si, dist);
		}
		
		// dist between first and last stable
		int ei = pos[pos.length - 1] - pos[0];

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (isPossible(pos, cows, mid) == true) {
				pans = mid;
				// inc min dist 
				si = mid + 1;
			} else {
				// reduce min dist
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
