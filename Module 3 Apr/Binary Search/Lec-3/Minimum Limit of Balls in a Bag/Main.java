import java.util.*;
import java.io.*;
class Solution
{
	static boolean isPossible(int[] arr, int maxOpt, int maxBalls) {
		int numOfOpt = 0;
		for (int bag : arr) {
			if (bag > maxBalls) {
				int opt = 0;
				if (bag % maxBalls == 0) {
					opt = bag / maxBalls - 1;
				} else {
					opt = bag / maxBalls;
				}
				numOfOpt += opt;
			}
		}

		return numOfOpt <= maxOpt;
	}

	// TC: O(N*logN), SC: O(1)
    public static int solve(int n,int m,int arr[])
    {
        // Write your code here
		int si = 1;
		int ei = 0;
		for (int bag : arr) {
			ei = Math.max(ei, bag);
		}

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (isPossible(arr, m, mid) == true) {
				pans = mid;
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