
// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    static int findMin(int arr[], int low, int high) {
        // Write your code here
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid + 1] < arr[mid]) {
                return arr[mid + 1];
            } else if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            } else if (arr[low] <= arr[mid]) {
                // if left side is sorted that means right side is unsorted hence move towards right side
                low = mid + 1;
            } else {
                // if left side is not sorted move towards left side
                high = mid - 1;
            }
        }

        return -1;
    }
}

class Main {

    // Driver Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}