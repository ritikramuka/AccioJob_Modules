// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
	// TC: O(log N), SC: O(1)
    static int findMin(int arr[], int low, int high)
    {
        //Write your code here
		int si = low;
		int ei = high;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (arr[mid] < arr[mid - 1]) {
				return arr[mid];
			} else if (arr[mid] > arr[mid + 1]) {
				return arr[mid + 1];
			} else if (arr[si] <= arr[mid]) {
				// left side is sorted, so move right
				si = mid + 1;
			} else {
				// left part is unsorted, so move left
				ei = mid - 1;
			}
		}

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