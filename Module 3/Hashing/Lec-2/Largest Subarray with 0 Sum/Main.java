import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int maxLen(int arr[]) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int mlen = 0;
        map.put(0, -1);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                mlen = Math.max(mlen, len);
            } else {
                map.put(sum, i);
            }
        }

        return mlen;
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
