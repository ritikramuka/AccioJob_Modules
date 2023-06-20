import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static boolean isPossible(int[] A, int B, long maxCap) {
		int dayNum = 1;
		long loadOnCurrDay = 0;

		for (int w : A) {
			if (w + loadOnCurrDay <= maxCap) {
				loadOnCurrDay += w;
			} else {
				dayNum++;
				loadOnCurrDay = w;
			}
		}

		return dayNum <= B;
	}

	// TC: O(N*log N), SC: O(1)
    public static long solve(int[] A, int B) {
        // max package weight
		long si = 0;
		// sum of packages weight
		long ei = 0;

		for (int w : A) {
			si = Math.max(si, w);
			ei += w;
		}

		long pans = -1;
		while (si <= ei) {
			long mid = (si + ei) / 2;

			if (isPossible(A, B, mid) == true) {
				pans = mid;
				// minmize
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
    }
}

class Main {
        public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
        	int[] A = new int[n];
        	for(int i=0;i<n;i++){
                        A[i] = sc.nextInt();
		}
                int B = sc.nextInt();
                System.out.println(Solution.solve(A,B));
	}
}