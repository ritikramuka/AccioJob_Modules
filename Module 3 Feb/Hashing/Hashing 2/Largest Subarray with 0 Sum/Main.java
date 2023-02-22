import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int maxLen(int arr[]) {
        // Write your code here

        // map -> unique runningSum, index of first occ
        HashMap<Integer, Integer> runningSumMap = new HashMap<>();
        runningSumMap.put(0, -1);

        int runningSum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];

            if (runningSumMap.containsKey(runningSum) == false) {
                runningSumMap.put(runningSum, i);
            } else {
                int len = i - runningSumMap.get(runningSum);
                maxLen = Math.max(maxLen, len);
            }
        }

        // if (runningSum == 0) {
        //     return arr.length;
        // }

        return maxLen;
    }
}

class Main {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxLen(nums));
    }
}
