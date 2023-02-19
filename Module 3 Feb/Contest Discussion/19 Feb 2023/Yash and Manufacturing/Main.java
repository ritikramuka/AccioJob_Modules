import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = Solution.efficientManufacturing(n, k, arr);
        System.out.println(ans);
    }
}

class Solution {
    static boolean isPossible(int[] factory, int reqProducts, long days) {
        long productProduced = 0;
        for (int i = 0; i < factory.length; i++) {
            long productProducedByThisFactory = days / factory[i];
            productProduced += productProducedByThisFactory;
        }
        return productProduced >= reqProducts;
    }

    // TC: O(N*log N), SC: O(1)
    static long efficientManufacturing(int n, int k, int arr[]) {
        // write code here
        long slowestFactory = 0;
        for (int days : arr) {
            slowestFactory = Math.max(days, slowestFactory);
        }

        // minimum days to produce k Products can be 1 day
        long lo = 1;

        // maximum days to producs k
        long hi = slowestFactory * k;

        long ans = -1;
        while (lo <= hi) {

            long days = (lo + hi) / 2;
            // is possible to produce k products from the given factories in given days
            if (isPossible(arr, k, days) == true) {
                ans = days;
                hi = days - 1;
            } else {
                lo = days + 1;
            }
        }

        return ans;
    }
}