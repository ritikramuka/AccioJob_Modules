// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int low, int high)
    {
        // array is not rotated
		if (arr[low] < arr[high]) {
			return arr[low];
		}

		int si = low;
		int ei = high;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (arr[mid - 1] > arr[mid]) {
				// found pivot
				return arr[mid];
			} else if (arr[si] <= arr[mid]) {
				// left side is sorted
				// move right
				si = mid + 1;
			} else {
				// left side is not sorted
				// move left
				ei = mid - 1;
			}
		}

		// will never reach this condition
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