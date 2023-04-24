import java.io.*;
import java.util.*;
import java.util.*;

class Solution{

	static boolean isPossible(int[] stalls, int cows, int minDist) {
		int lastPlacedIndex = 0;
		int numberOfCowsPlaced = 1;
		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - stalls[lastPlacedIndex] >= minDist) {
				numberOfCowsPlaced++;
				lastPlacedIndex = i;
			}
		}

		return numberOfCowsPlaced >= cows;
	}

	// TC: O(N*logN), SC: O(1)
    public static int aggressiveCows(int a[],int cows){
	    //Write your code here
		Arrays.sort(a);

		int ei = a[a.length - 1] - a[0];
		int si = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int dist = a[i + 1] - a[i];
			si = Math.min(dist, si);
		}

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (isPossible(a, cows, mid) == true) {
				pans = mid;
				si = mid + 1;
			} else {
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
