import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        // write code here

        // create a freq map for all remainders
        HashMap<Integer, Integer> remFreqMap = new HashMap<>();
        for (int num : arr) {
            int rem = num % k;

            // if (remFreqMap.containsKey(rem) == true) {
            // int freq = remFreqMap.get(rem);
            // remFreqMap.put(rem, freq + 1);
            // } else {
            // remFreqMap.put(rem, 1);
            // }

            remFreqMap.put(rem, remFreqMap.getOrDefault(rem, 0) + 1);
        }

        for (int rem : remFreqMap.keySet()) {
            // edge case of rem = 0
            if (rem == 0) {
                // no need to neutralize
                continue;
            }

            int compRem = k - rem;
            if (remFreqMap.containsKey(compRem) == false) {
                return false;
            } else if (remFreqMap.get(rem) != remFreqMap.get(compRem)) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if (Obj.arrayPairs(arr, k)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}