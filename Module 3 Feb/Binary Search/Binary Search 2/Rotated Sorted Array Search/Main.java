import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A, B));

    }
}

class Solution {
    // TC: O(log N), SC: O(1)
    public int search(final int[] a, int target) {
        // Write code here

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            // step 1: get mid index
            int mid = (lo + hi) / 2;

            // step 2: check did I found target at mid
            if (a[mid] == target) {
                return mid;
            }
            // Check wheather left part is sorted
            else if (a[lo] <= a[mid]) {
                // is target in the range of sorted region
                if (a[lo] <= target && a[mid] > target) {
                    // move towards sorted region, so move left
                    hi = mid - 1;
                } else {
                    // target is not in sorted range, so move towards unsorted region, so move right
                    lo = mid + 1;
                }
            }
            // Right part is sorted
            else {
                // is target in the range of sorted region
                if (a[mid] < target && a[hi] >= target) {
                    // move towards sorted region, so move right
                    lo = mid + 1;
                } else {
                    // target is not in sorted range, so move towards unsorted region, so move left
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}