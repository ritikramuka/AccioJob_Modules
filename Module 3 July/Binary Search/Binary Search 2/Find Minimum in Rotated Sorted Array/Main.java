// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int low, int high)
    {
        //Write your code here

		// base case
		if (arr[low] < arr[high]) {
			return arr[low];
		}

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid - 1] > arr[mid]) {
				return arr[mid];
			} else if (mid + 1 < arr.length && arr[mid + 1] < arr[mid]) {
				return arr[mid + 1];
			} else if (arr[low] <= arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
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