import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            // if (freqMap.containsKey(num) == true) {
            // int currFreq = freqMap.get(num);
            // freqMap.put(num, currFreq + 1);
            // } else {
            // freqMap.put(num, 1);
            // }

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (freqMap.get(num) == k) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(-1);
        return;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums, n, k);
        System.out.println();
    }
}