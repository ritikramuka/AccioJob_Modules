import java.util.*;

public class Main {

    // TC: O(log N), SC: O(1)
    public static int AdisArray(int n, int target, int[] nums) {
        // write your code

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Am I equal to arr[mid]
            if (nums[mid] == target) {
                return mid;
            }

            // is left part sorted
            if (nums[lo] <= nums[mid]) {
                // yes left part is sorted

                // Am I in the sorted range?
                if (nums[lo] <= target && nums[mid] > target) {
                    // move towards sorted region, i.e. move left
                    hi = mid - 1;
                }
                // I'm not in range so, move to other side, i.e. move right
                else {
                    lo = mid + 1;
                }
            }
            // right part is sorted
            else {
                // Am I in the sorted range?
                if (nums[mid] < target && nums[hi] >= target) {
                    // move towards sorted region, i.e. move right
                    lo = mid + 1;
                }
                // I'm not in sorted region so, move other side, i.e. move left
                else {
                    hi = mid - 1;
                }
            }
        }

        // not able to find target in the nums array
        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scn.nextInt();
        }

        int ans = AdisArray(n, k, arr);
        System.out.println(ans);
    }
}