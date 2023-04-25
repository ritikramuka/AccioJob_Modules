import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	static boolean isPossible(int[] A, int B, long maxCapacity) {
		int numberOfDays = 1;
		long weightOnShipOnCurrentDay = 0;

		for (int weight : A) {
			if (weightOnShipOnCurrentDay + weight <= maxCapacity) {
				weightOnShipOnCurrentDay += weight;
			} else {
				numberOfDays++;
				weightOnShipOnCurrentDay = weight;
			}
		}

		return numberOfDays <= B;
	}
	
    public static long solve(int[] A, int B) {
        long si = 0;
		long ei = 0;
		for (int weight : A) {
			si = Math.max(si, weight);
			ei += weight;
		}

		long pans = -1;
		while (si <= ei) {
			long mid = (si + ei) / 2;

			if (isPossible(A, B, mid) == true) {
				pans = mid;
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