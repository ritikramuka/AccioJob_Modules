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
	// TC: O(N), SC: O(1)
    static int findEquilibriumIndex(int[] a) {
  //       int totalSum = 0;
		// for (int ele : a) {
		// 	totalSum += ele;
		// }

		// int lsum = 0;
		// for (int i = 0; i < a.length; i++) {
		// 	int rsum = totalSum - lsum - a[i];
		// 	if (rsum == lsum) {
		// 		return i;
		// 	}
		// 	lsum += a[i];
		// }

		// return -1;

		int si = 0;
		int ei = a.length - 1;

		int lsum = a[0];
		int rsum = a[a.length - 1];

		while (si <= ei) {
			if (si + 1 == ei) {
				if (lsum == rsum && (a[si] == 0 || a[ei] == 0)) {
					 return a[si] == 0 ? si : ei;
				}
			}
			
			if (si == ei) {
				if (lsum == rsum) {
					return si;
				}
			}
			
			if (lsum < rsum) {
				si++;
				lsum += a[si];
			} else if (lsum >= rsum) {
				ei--;
				rsum += a[ei];
			}
		}

		return -1;
    }
}