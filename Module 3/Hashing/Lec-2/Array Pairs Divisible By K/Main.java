import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(K)
    public boolean arrayPairs(int[] arr, int k) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int rem : map.keySet()) {
            if (rem == 0) {
                continue;
            }

            int compRem = k - rem;

            if (map.containsKey(compRem) == false) {
                // compRem is not present
                return false;
            } else if (map.get(compRem) != map.get(rem)) {
                // compRem freq != rem freq
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