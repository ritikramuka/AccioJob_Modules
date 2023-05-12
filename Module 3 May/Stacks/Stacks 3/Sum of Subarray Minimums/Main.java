import java.io.*;
import java.util.*;

class Solution{
	// TC: O(N), SC: O(N)
	long mod = 1000000007;
	public long minSubarraySum(int n, int a[]){
		// write code here

		// stack: people looking got nseli
		Stack<Integer> st = new Stack<>();

		long sum = 0;

		// right to left
		for (int i = n - 1; i >= 0; i--) {
			while (st.size() > 0 && a[i] <= a[st.peek()]) {
				int idx = st.pop();
				int LB = i;
				int RB = n;
				if (st.size() > 0) {
					RB = st.peek();
				}

				int numberOfLeftSubarray = idx - LB;
				int numberOfRightSubarray = RB - idx;

				long totalSubarray = (numberOfLeftSubarray * numberOfRightSubarray) % mod;
				sum = (sum + (totalSubarray * a[idx]) % mod) % mod;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			int LB = -1;
			int RB = n;
			if (st.size() > 0) {
				RB = st.peek();
			}

			int numberOfLeftSubarray = idx - LB;
			int numberOfRightSubarray = RB - idx;

			long totalSubarray = (numberOfLeftSubarray * numberOfRightSubarray) % mod;
			sum = (sum + (totalSubarray * a[idx]) % mod) % mod;
		}

		return sum;
	}
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}