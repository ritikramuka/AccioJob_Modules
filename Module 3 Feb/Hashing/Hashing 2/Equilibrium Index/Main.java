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
    //     // Write code here

    //     int n = a.length;

    //     if (n == 1) {
    //         return 0;
    //     }

    //     int[] lsum = new int[n];
    //     lsum[0] = a[0];
    //     for (int i = 1; i < n; i++) {
    //         lsum[i] = lsum[i - 1] + a[i];
    //     }

    //     int[] rsum = new int[n];
    //     rsum[n - 1] = a[n - 1];
    //     for (int i = n - 2; i >= 0; i--) {
    //         rsum[i] = rsum[i + 1] + a[i];
    //     }

    //     for (int i = 0; i < n; i++) {
    //         if (i == 0) {
    //             if (rsum[i + 1] == 0) {
    //                 return i;
    //             }
    //         } else if (i == n - 1) {
    //             if (lsum[i - 1] == 0) {
    //                 return i;
    //             }
    //         } else {
    //             if (lsum[i - 1] == rsum[i + 1]) {
    //                 return i;
    //             }
    //         }
    //     }

    //     return -1;
    // }

    // TC: O(N), SC: O(1)
    static int findEquilibriumIndex(int[] a) {
        // Write code here
        int n = a.length;

        if (n == 1) {
            return 0;
        }

        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }

        int lsum = 0;
        for (int i = 0; i < n; i++) {
            int rsum = totalSum - a[i] - lsum;
            if (lsum == rsum) {
                return i;
            }
            lsum += a[i];
        }

        return -1;
    }
}