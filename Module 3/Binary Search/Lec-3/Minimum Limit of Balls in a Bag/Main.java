import java.util.*;
import java.io.*;

class Solution {
    static boolean isPossible(int n, int[] arr, int limit, int maxOpt) {
        int currOpt = 0;
        for (int i = 0; i < n; i++) {
            int currBalls = arr[i];
            int divider = currBalls / limit;
            if (currBalls % limit == 0) {
                divider--;
            }
            currOpt += divider;
        }

        return currOpt <= maxOpt;
    }

    public static int solve(int n, int m, int arr[]) {
        // Write your code here

        // if infinite operations, you can divide all balls to sepreate bags, hence max
        // in a bag will be 1
        int lo = 1;

        // if you have zero opt, then max in a bag in max in the array of bags
        int hi = 0;
        for (int balls : arr) {
            hi = Math.max(balls, hi);
        }

        int potetialAns = -1;
        while (lo <= hi) {
            // mid -> max balls you can in a bag after division
            int mid = (lo + hi) / 2;

            if (isPossible(n, arr, mid, m) == true) {
                potetialAns = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return potetialAns;
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