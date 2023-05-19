import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	boolean isPossible(int[] books, int B, long maxPages) {
		int studentNumber = 1;
		long numberOfPages = 0;

		for (int pages : books) {
			if (numberOfPages + pages <= maxPages) {
				numberOfPages += pages;
			} else {
				studentNumber++;
				numberOfPages = pages;
			}
		}

		return studentNumber <= B;
	}

	// TC: O(N * log (N)), SC: O(1)
    public long MinimumPages(int[] A, int B) {
        //Write your code here
		if (A.length < B) {
			return -1;
		}
		
		long si = 0;
		long ei = 0;

		for (int Pages : A) {
			si = Math.max(si, Pages);
			ei += Pages;
		}

		long pans = -1;

		while (si <= ei) {
			long mid = (si + ei) / 2;

			if (isPossible(A, B, mid) == true) {
				pans = mid;
				// minimize
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
    }
}

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}