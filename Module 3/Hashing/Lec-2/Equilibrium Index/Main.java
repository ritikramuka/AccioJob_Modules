import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    // TC: O(N), SC: O(N)
    // static int findEquilibriumIndex(int[] a) {
    // // Write code here
    // int n = a.length;

    // int[] lSum = new int[n];
    // lSum[0] = a[0];
    // for (int i = 1; i < n; i++) {
    // lSum[i] = a[i] + lSum[i - 1];
    // }

    // int[] rSum = new int[n];
    // rSum[n - 1] = a[n - 1];
    // for (int i = n - 2; i >= 0; i--) {
    // rSum[i] = a[i] + rSum[i + 1];
    // }

    // for (int i = 0; i < n; i++) {
    // if (lSum[i] == rSum[i]) {
    // return i;
    // }
    // }

    // return -1;
    // }

    // TC: O(N), SC: O(1)
    static int findEquilibriumIndex(int[] a) {
        // Write code here
        int n = a.length;

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
        }

        int lSum = 0;
        for (int i = 0; i < n; i++) {
            lSum += a[i];
            int rSum = totalSum - lSum + a[i];

            if (rSum == lSum) {
                return i;
            }
        }

        return -1;
    }
}