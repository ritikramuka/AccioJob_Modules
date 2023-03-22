import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Your code here.
        int n = arr.length;

        int si = 0;
        int ei = n - 1;

        if (n == 1) {
            return 0;
        }

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mid == n - 1) {
                // left part is inc, then mid is peak
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    ei = mid - 1;
                }
            } else if (mid == 0) {
                // right part is dec, then mid is peak
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    si = mid + 1;
                }
            } else {
                // check is mid peak ele
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] < arr[mid]) {
                    // left side is inc,
                    // peak will be in right
                    si = mid + 1;
                } else {
                    // left part is dec,
                    // peak will be in left
                    ei = mid - 1;
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