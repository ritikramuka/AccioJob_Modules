import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static boolean isPossible(int[] packages, int maxDays, long maxCapacity) {
		int dayNum = 1;
		long loadOnShip = 0;

		for (int w : packages) {
			if (loadOnShip + w <= maxCapacity) {
				loadOnShip += w;
			} else {
				dayNum++;
				loadOnShip = w;
			}
		}

		return dayNum <= maxDays;
	}

	// TC: O(N * log N), SC: O(1)
    public static long solve(int[] A, int B) {
        //Write your code here  
		long si = 0;
		long ei = 0;

		for (int w : A) {
			ei += w;
			si = Math.max(w, si);
		}

		long pans = -1;
		while (si <= ei) {
			long mid = (si + ei) / 2;
			if (isPossible(A, B, mid) == true) {
				pans = mid;
				// move left
				ei = mid - 1;
			} else {
				// move right
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