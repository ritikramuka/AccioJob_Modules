import java.io.*;
import java.security.Key;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
        HashMap<Integer, Integer> mymap = new HashMap<>();

        for (int num : nums) {
            // if (mymap.containsKey(num)) {
            // mymap.put(num, mymap.get(num) + 1);
            // } else {
            // mymap.put(num, 1);
            // }

            mymap.put(num, mymap.getOrDefault(num, 0) + 1);

            if (mymap.get(num) == k) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(-1);
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