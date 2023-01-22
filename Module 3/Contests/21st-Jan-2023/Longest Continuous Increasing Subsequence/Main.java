import java.util.*;

class Solution {
    public static int minDifference(int[] arr, int key) {
        // Write your code here

        int ceil = -1;
        int floor = -1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] > key) {
                // here arr[mid] > key, hence this can be your potentail just greater value
                ceil = arr[mid];
                hi = mid - 1;
            } else {
                // here arr[mid] < key, hence this can be your potential just smaller value
                floor = arr[mid];
                lo = mid + 1;
            }
        }

        if (ceil == -1) {
            return floor;
        }

        if (floor == -1) {
            return ceil;
        }

        int d1 = key - floor;
        int d2 = ceil - key;

        if (d1 < d2) {
            return floor;
        } else {
            return ceil;
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
