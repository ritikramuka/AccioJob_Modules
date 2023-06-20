import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	// TC: O(N), SC: O(1)
	public boolean isPossible(int[] books, int maxStudents, long limit) {
		int studentNumber = 1;
		long numOfPages = 0;

		for (int pages : books) {
			if (pages + numOfPages <= limit) {
				numOfPages += pages;
			} else {
				studentNumber++;
				numOfPages = pages;
			}
		}

		return studentNumber <= maxStudents;
	}

	// TC: O(N * log N), SC: O(1)
    public long MinimumPages(int[] books, int students) {
		if (students > books.length) {
			return -1;
		}
		
        // si -> max pages in a book 
		long si = 0;
		// ei -> sum of all the pages
		long ei = 0;

		for (int pages : books) {
			si = Math.max(si, pages);
			ei += pages;
		}

		long pans = -1;
		while (si <= ei) {
			long mid = (si + ei) / 2;

			// is it possible to have these books distributed among these students with 'mid' as the limit to max pages to a student
			if (isPossible(books, students, mid) == true) {
				pans = mid;
				// reduce limit
				ei = mid - 1;
			} else {
				// inc limit
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