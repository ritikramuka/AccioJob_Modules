import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public boolean isPossible(int[] books, int m, long limit) {
		int currStudNum = 1;
		long numberOfPagesToCurr = 0;

		for (int pages : books) {
			if (numberOfPagesToCurr + pages <= limit) {
				numberOfPagesToCurr += pages;
			} else {
				currStudNum++;
				numberOfPagesToCurr = pages;
			}
		}

		return currStudNum <= m;
	}

	// TC: O(N * log N), SC: O(1)
    public long MinimumPages(int[] A, int B) {
        //Write your code here
		if (A.length < B) {
			return -1;
		}
		
		long lo = 0;
		long hi = 0;

		for (int pages : A) {
			lo = Math.max(lo, pages);
			hi += pages;
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