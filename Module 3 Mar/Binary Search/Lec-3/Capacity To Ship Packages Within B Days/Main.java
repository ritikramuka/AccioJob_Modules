import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static boolean isPossible(int[] A, long cap, int B) {
        int dayNumber = 1;
        long weightOnThisDay = 0;

        for (int w : A) {
            if (weightOnThisDay + w <= cap) {
                weightOnThisDay += w;
            } else {
                dayNumber++;
                weightOnThisDay = w;
            }
        }

        return dayNumber <= B;
    }

    // TC: O(N * log N), SC: O(1)
    public static long solve(int[] A, int B) {
        // Write your code here

        // si -> max weight pkg
        long si = 0;
        // ei -> sum of weight of pkg
        long ei = 0;

        for (int weight : A) {
            si = Math.max(si, weight);
            ei += weight;
        }

        long pans = -1;
        while (si <= ei) {
            long mid = si + (ei - si) / 2;

            if (isPossible(A, mid, B) == true) {
                pans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}