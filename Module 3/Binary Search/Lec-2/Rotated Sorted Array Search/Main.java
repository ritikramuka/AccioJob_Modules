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
    public int search(final int[] a, int target) {
        // Write code here
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // is a[mid] == target -> you found the target
            if (a[mid] == target) {
                return mid;
            }
            // is left part sorted
            else if (a[lo] <= a[mid]) {
                // check, am I in sorted range i.e left part
                if (a[lo] <= target && target < a[mid]) {
                    // so move towards left
                    hi = mid - 1;
                } else {
                    // I'm not in sorted range, i.e left part
                    // so move towards right
                    lo = mid + 1;
                }
            }
            // right part is sorted
            else {
                // check, am I in sorted range i.e right part
                if (a[mid] < target && target <= a[hi]) {
                    // so move towards right
                    lo = mid + 1;
                } else {
                    // I'm not in sorted range, i.e right part
                    // so move towards left
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}