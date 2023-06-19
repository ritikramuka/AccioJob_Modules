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

class Solution {
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
				// left side is sorted
				// range of left side [a[si], a[mid]]
				if (target >= a[si] && target < a[mid]) {
					// move towards left
					ei = mid - 1;
				} else {
					// move away from sorted region, i.e towards right
					si = mid + 1;
				}
			} else {
				// right side is sorted
				// range of right side [a[mid], a[ei]]
				if (target > a[mid] && target <= a[ei]) {
					// move towards right
					si = mid + 1;
				} else {
					// move away from sorted region, i.e towards left
					ei = mid - 1;
				}
			}
		}

		return -1;
    }
}