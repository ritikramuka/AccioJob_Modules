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
        // define range
        int si = 0;
        int ei = a.length - 1;

        while (si <= ei) {
            // get mid
            int mid = (si + ei) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[si] <= a[mid]) {
                // left part is sorted
                // case 1: in the sorted region?
                // case 2: if not in sorted region, then move towards unsorted

                // range -> a[si] to a[mid]
                if (target >= a[si] && target <= a[mid]) {
                    // move left
                    ei = mid - 1;
                } else {
                    // move towards unsorted region, i.e. right side
                    si = mid + 1;
                }
            } else {
                // right part is sorted
                // case 1: in the sorted region?
                // case 2: if not in sorted region, then move towards unsorted

                // range -> a[mid] to a[ei]
                if (target >= a[mid] && target <= a[ei]) {
                    // move right
                    si = mid + 1;
                } else {
                    // move towards unsorted region, i.e. left side
                    ei = mid - 1;
                }
            }
        }

        return -1;
    }
}