import java.util.*;

class Solution {
    static int ceilValue(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;

        int ceil = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Is arr[mid] == k
            if (arr[mid] == k) {
                // ceil value for this k, in the array is himself
                return arr[mid];
            } else if (arr[mid] > k) {
                // found a potential ceil value, now search for more closer people
                ceil = arr[mid];
                // for more closer people dec your hi
                hi = mid - 1;
            } else {
                // inc your lower limit
                lo = mid + 1;
            }
        }

        return ceil;
    }

    static int floorValue(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;

        int floor = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Is arr[mid] == k
            if (arr[mid] == k) {
                // floor value for this k, in the array is himself
                return arr[mid];
            } else if (arr[mid] < k) {
                // found a potential floor value, now search for more closer people
                floor = arr[mid];
                // for more closer people inc your lo
                lo = mid + 1;
            } else {
                // dec your higher limit
                hi = mid - 1;
            }
        }

        return floor;
    }

    // TC: O(log N), SC: O(1)
    public static int minDifference(int[] arr, int key) {
        // Write your code here
        int ceil = ceilValue(arr, key);
        int floor = floorValue(arr, key);

        int distFromCeil = ceil - key;
        int distFromFloor = key - floor;

        if (distFromCeil < distFromFloor) {
            return ceil;
        } else {
            return floor;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.minDifference(a, k));
    }
}
