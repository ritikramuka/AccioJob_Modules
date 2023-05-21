/**
 * https://course.acciojob.com/idle?question=b0f153cb-c7ab-47f2-b282-ee2318e18a6b
 */

import java.util.*;

public class Main {

	// TC: O(log N), SC: O(1)
    public static int AdisArray(int n, int target, int[] nums) {
        int si = 0;
		int ei = n - 1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[si] <= nums[mid]) {
				if (nums[si] <= target && target < nums[mid]) {
					// move left
					ei = mid - 1;
				} else {
					// move right
					si = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[ei]) {
					// move right
					si = mid + 1;
				} else {
					// move left
					ei = mid - 1;
				}
			}
		}

		return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[] arr = new int[n];

        for(int i=0;i<n;++i){
            arr[i] = scn.nextInt();
        }

        int ans = AdisArray(n,k,arr);
        System.out.println(ans);
    }
}