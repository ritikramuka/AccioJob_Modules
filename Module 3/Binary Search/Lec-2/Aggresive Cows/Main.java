import java.io.*;
import java.util.*;
import java.util.*;

class Solution {

    static boolean possibleToPlace(int[] a, int minDist, int cows) {
        int cowsPlaced = 1;
        int lastPositionPlaced = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] - lastPositionPlaced >= minDist) {
                cowsPlaced++;
                lastPositionPlaced = a[i];
            }
        }

        return cowsPlaced >= cows;
    }

    // TC: O(N*logN) SC: O(1)
    public static int aggressiveCows(int a[], int cows) {
        // Write your code here

        // sort the position so that we have clear picture of which cow has threat from
        // which cow, as cow at position x will be more prone to aggression with cow at
        // position near to that x
        Arrays.sort(a);

        // minimum distance between two stalls will be one
        int lo = 1;

        // maximum distance between two stalls will be dist between stall at smallest
        // pos to stall at higest pos
        int hi = a[a.length - 1] - a[0];

        // potential min dist between two cows, maximize it
        int res = 0;
        while (lo <= hi) {
            // lets have min distance between two cows as mid
            int mid = (lo + hi) / 2;

            if (possibleToPlace(a, mid, cows) == true) {
                // was able to place 'cows' with this distance between them, so this is
                // potential ans
                res = mid;

                // but now try to inc dist, and find new ans
                lo = mid + 1;
            } else {
                // not able to place with this dist, so decrease the dist
                hi = mid - 1;
            }
        }

        return res;
    }

}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k));

    }
}
