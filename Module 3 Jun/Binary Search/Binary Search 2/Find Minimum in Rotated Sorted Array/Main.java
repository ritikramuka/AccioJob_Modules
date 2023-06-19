// Java program to find minimum element in a sorted and
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
	// TC: O(log N), SC: O(1)
    static int findMin(int arr[], int low, int high)
    {
        // Write your code here
		if (arr[low] < arr[high]) {
			// array is not rotated
			return arr[low];
		}

		// define search region
		int si = low;
		int ei = high;

		// start searching
		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (arr[mid] < arr[mid - 1]) {
				// hence mid index is pivot index
				return arr[mid];
			} else if (arr[si] <= arr[mid]) {
				// left side is sorted
				// move towards right side (unsorted region)
				si = mid + 1;
			} else {
				// right side is sorted
				// move towards left side (unsorted region)
				ei = mid - 1;
			}
		}

		// will never be reached
		return -1;
    }
}
class Main {
    
 
    // Driver Program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}