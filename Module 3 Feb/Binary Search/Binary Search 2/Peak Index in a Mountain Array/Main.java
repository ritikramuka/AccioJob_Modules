import java.io.*;
import java.util.*;

class Solution {
    // TC: O(log N), SC: O(1)
    public int peakIndexInMountainArray(int[] A) {
        // Your code here.
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid - 1 < 0) {
                if (A[mid + 1] < A[mid]) {
                    // I'm the peak
                    return mid;
                } else {
                    // I don't have a left side, so move right
                    lo = mid + 1;
                }
            } else if (mid + 1 >= A.length) {
                if (A[mid - 1] < A[mid]) {
                    // I'm the peak
                    return mid;
                } else {
                    // I don't have right side, so move left
                    hi = mid - 1;
                }
            } else {
                // Am I the peak
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                }
                // cheack wheather liying on inc path
                if (A[mid - 1] <= A[mid]) {
                    // ans is towards right
                    lo = mid + 1;
                }
                // if not on inc path
                else {
                    // ans is towards left
                    hi = mid - 1;
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
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}