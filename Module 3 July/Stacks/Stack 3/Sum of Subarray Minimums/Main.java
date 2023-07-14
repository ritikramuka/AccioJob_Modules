import java.io.*;
import java.util.*;

class Solution{
	// TC: O(N), SC: O(N)
	long mod = 1000000007;
	public long minSubarraySum(int n, int a[]){
		// stack: people looking for next smaller element in right
		Stack<Integer> st = new Stack<>();
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int ele = a[i];
			while (st.size() > 0 && a[st.peek()] > ele) {
				int idx = st.pop();
				
				int rb = i;
				int lb = -1;
				if (st.size() > 0) {
					lb = st.peek();
				}
				
				long numberOfSubarrays = ((rb - idx) * (idx - lb)) % mod;
				long sum = (numberOfSubarrays * a[idx]) % mod;
				ans = (ans + sum) % mod;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
				
			int rb = n;
			int lb = -1;
			if (st.size() > 0) {
				lb = st.peek();
			}
				
			long numberOfSubarrays = ((rb - idx) * (idx - lb)) % mod;
			long sum = (numberOfSubarrays * a[idx]) % mod;
			ans = (ans + sum) % mod;
		}

		return ans % mod;
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