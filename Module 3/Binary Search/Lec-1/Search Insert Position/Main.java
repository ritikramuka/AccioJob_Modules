import java.util.*;

public class Main {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        int ceil = nums.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                ceil = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(searchInsert(arr, key));
        sc.close();
    }
}