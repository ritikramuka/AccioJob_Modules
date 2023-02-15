import java.util.*;

class Solution {

    static boolean isPossibleToPlace(int[] a, int cows, int capDist) {
        int lastPostionPlaced = 0;
        int numberOfCowsPlaced = 1;

        for (int i = 1; i < a.length; i++) {
            int distBetweenNewStallAndPrevStall = a[i] - a[lastPostionPlaced];
            if (distBetweenNewStallAndPrevStall >= capDist) {
                numberOfCowsPlaced++;
                lastPostionPlaced = i;
            }
        }

        return numberOfCowsPlaced >= cows;
    }

    // TC: O(N * log N), SC: O(1)
    public static int aggressiveCows(int a[], int cows) {
        // Write your code here
        Arrays.sort(a);

        int maxDist = a[a.length - 1] - a[0];
        int minDist = 1;

        int lo = minDist;
        int hi = maxDist;
        int ans = 0;
        while (lo <= hi) {
            int capDist = (lo + hi) / 2;

            if (isPossibleToPlace(a, cows, capDist) == true) {
                ans = capDist;
                lo = capDist + 1;
            } else {
                hi = capDist - 1;
            }
        }
        return ans;
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
