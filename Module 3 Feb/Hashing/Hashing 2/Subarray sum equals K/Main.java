import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    static int solve(int N, int[] Arr, int K) {
        // Write your code here
        int result = 0;

        // runningSum, freq
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int runningSum = 0;
        for (int num : Arr) {
            runningSum += num;

            int x = runningSum;
            int y = runningSum - K;

            if (map.containsKey(y) == true) {
                result += map.get(y);
            }

            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        System.out.println(Solution.solve(n, arr, k));
    }
}