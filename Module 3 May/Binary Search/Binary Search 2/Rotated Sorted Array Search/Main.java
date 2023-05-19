import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int N = sc.nextInt();
	  int[] A = new int[N];
	  for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
      }
	  int B = sc.nextInt();
	  Solution ob = new Solution();
    System.out.println(ob.search(A,B));
		
	}
}

class Solution{
	// TC: O(log N), SC: O(1)
    public int search(final int[] a, int target) {
        //Write code here

		int si = 0;
		int ei = a.length - 1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (a[mid] == target) {
				return mid;
			} else if (a[si] <= a[mid]) {
				// left part is sorted
				if (a[si] <= target && a[mid] > target) {
					// move towards sorted range
					// move left
					ei = mid - 1;
				} else {
					// move right
					si = mid + 1;
				}
			} else {
				// right part is sorted
				if (a[mid] < target  && a[ei] >= target) {
					// move towards sorted range
					// move right
					si = mid + 1;
				} else {
					// move left
					ei = mid - 1;
				}
			}
		}

		return -1;
    }
}