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

// TC: O(N*logN) SC: O(1)
class Solution {
    static boolean isPossible(int[] arr, int n, int minGoodsToProduce, long days) {
        long goodsProduced = 0;
        for (int i = 0; i < n; i++) {
            long goodsByThisFactory = days / arr[i];
            goodsProduced += goodsByThisFactory;
        }

        return goodsProduced >= minGoodsToProduce;
    }

    static long efficientManufacturing(int n, int k, int arr[]) {
        // write code here
        long lo = 1;
        long hi = Long.MAX_VALUE;

        long res = -1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(arr, n, k, mid) == true) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}