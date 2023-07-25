import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean isPossible(int[] pkgs, int B, long maxCap) {
		int currDayNum = 1;
		long loadOnShipToday = 0;

		for (int pkg : pkgs) {
			if (loadOnShipToday + pkg <= maxCap) {
				loadOnShipToday += pkg;
			} else {
				currDayNum++;
				loadOnShipToday = pkg;
			}
		}

		return currDayNum <= B;
	}

	// TC: O(N * log N), SC: O(1)
    public static long solve(int[] A, int B) {
        //Write your code here     
		long lo = 0;
		long hi = 0;

		for (int pkg : A) {
			lo = Math.max(lo, pkg);
			hi += pkg;
		}

		long pans = -1;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;

			if (isPossible(A, B, mid) == true) {
				pans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
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