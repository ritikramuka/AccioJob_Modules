import java.util.*;
import java.io.*;

class Solution {
    static boolean isPossibleTo(int[] arr, int m, int capValue) {
        int numberOfOperations = 0;
        for (int ele : arr) {
            if (ele > capValue) {
                int currOperations = ele / capValue;

                if (ele % capValue == 0) {
                    currOperations -= 1;
                }

                numberOfOperations += currOperations;
            }
        }

        return numberOfOperations <= m;
    }

    public static int solve(int n, int m, int arr[]) {
        // Write your code here
        int lo = 1;
        int hi = 0;

        for (int ele : arr) {
            hi = Math.max(hi, ele);
        }

        int potentialAns = 0;
        while (lo <= hi) {
            int capValue = (lo + hi) / 2;
            if (isPossibleTo(arr, m, capValue) == true) {
                potentialAns = capValue;
                hi = capValue - 1;
            } else {
                lo = capValue + 1;
            }
        }

        return potentialAns;
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