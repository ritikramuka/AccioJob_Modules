import java.util.*;
import java.io.*;

class Solution {
    static boolean isPossible(int[] arr, int p, int maxOpt) {
        int numberOfOpt = 0;
        for (int x : arr) {
            if (x > p) {
                int opt = 0;
                if (x % p == 0) {
                    opt = (x / p) - 1;
                } else {
                    opt = x / p;
                }
                numberOfOpt += opt;
            }
        }

        return numberOfOpt <= maxOpt;
    }

    // TC: O(N * log N), SC: O(1)
    public static int solve(int n, int m, int arr[]) {
        // Write your code here

        int lo = 1;

        int hi = 0;
        for (int a : arr) {
            hi = Math.max(hi, a);
        }

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(arr, mid, m) == true) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();
        System.out.println(Solution.solve(n, m, arr));
    }
}