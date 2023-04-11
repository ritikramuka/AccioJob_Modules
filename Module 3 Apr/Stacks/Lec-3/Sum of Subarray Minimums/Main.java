import java.io.*;
import java.util.*;

class Solution{
	public int[] getNSELI(int[] a, int n) {
		// people looking for nse left side
		Stack<Integer> st = new Stack<>();

		int[] nseli = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (st.size() > 0 && a[i] < a[st.peek()]) {
				int idx = st.pop();
				nseli[idx] = i;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			nseli[idx] = -1;
		} 

		return nseli;
	}

	public int[] getNSERI(int[] a, int n) {
		// people looking for nse right side
		Stack<Integer> st = new Stack<>();

		int[] nseri = new int[n];

		for (int i = 0; i < n; i++) {
			while (st.size() > 0 && a[i] <= a[st.peek()]) {
				int idx = st.pop();
				nseri[idx] = i;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			nseri[idx] = n;
		} 

		return nseri;
	}

	long mod = 1000000007;

	// TC: O(N), SC: O(N)
	public long minSubarraySum(int n, int a[]){
		// write code here

		// step 1: get nseli
		int[] nseli = getNSELI(a, n);

		// step 2: get nseri
		int[] nseri = getNSERI(a, n);

		// step 3: calc number of subarray where arr[i] is min, and then calc there sum
		long totalSum = 0;
		for (int i = 0; i < n; i++) {
			long num = ((i - nseli[i]) * (nseri[i] - i)) % mod;
			long sum = (num * a[i]) % mod;
			totalSum = (totalSum + sum) % mod;
		}

		return totalSum % mod;
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