import java.util.*;
import java.io.*;
class Solution
{
	public static boolean isPossible(int[] arr, int maxOpt, int penalty) {
		int optUsed = 0;
		for (int bag : arr) {
			if (bag > penalty) {
				if (bag % penalty == 0) {
					optUsed += (bag / penalty) - 1;
				} else {
					optUsed += (bag / penalty);
				}
			}
		}

		return optUsed <= maxOpt;
	}

	// TC: O(N * log N), SC: O(1)
    public static int solve(int n,int m,int arr[])
    {
        // Write your code here
		int si = 1;
		int ei = 0;
		for (int balls : arr) {
			ei = Math.max(ei, balls);
		}

		int pans = -1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (isPossible(arr, m, mid) == true) {
				pans = mid;
				// minimize
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}