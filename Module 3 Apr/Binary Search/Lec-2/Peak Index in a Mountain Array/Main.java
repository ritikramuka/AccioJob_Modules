import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
	    // Your code here.
		int si = 0;
		int ei = A.length - 1;

		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (mid + 1 == A.length) {
				if (A[mid] > A[mid - 1]) {
					return mid;
				} else {
					// move left, as I don't have a right
					ei = mid - 1;
				}
			} else if (mid - 1 < 0) {
				if (A[mid] > A[mid + 1]) {
					return mid;
				} else {
					si = mid + 1;
				}
			} else {
				if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
					return mid;
				} else if (A[mid] > A[mid + 1]) {
					// move left
					ei = mid - 1;
				} else {
					si = mid + 1;
				}	
			}
		}

		return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}