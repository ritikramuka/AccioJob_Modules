import java.io.*;
import java.util.*;

class Solution{
	int[] nextSmallerElementOnLeftIndexwise (int[] arr, int n) {
		// Stack: people looking for nsel
		Stack<Integer> st = new Stack<>();

		int[] nseli = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				nseli[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
			nseli[st.pop()] = -1;
		}

		return nseli;
	}

	int[] nextSmallerElementOnRightIndexwise (int[] arr, int n) {
		// Stack: people looking for nser
		Stack<Integer> st = new Stack<>();

		int[] nseri = new int[n];

		for (int i = 0; i < n; i++) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				nseri[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
			nseri[st.pop()] = n;
		}

		return nseri;
	}

	long mod = 1000000007;
	// TC: O(N), SC: O(N)
	public long minSubarraySum(int n, int a[]){
		// write code here

		int[] nseli = nextSmallerElementOnLeftIndexwise(a, n);
		int[] nseri = nextSmallerElementOnRightIndexwise(a, n);

		long ans = 0;
		for (int i = 0; i < n; i++) {
			long numberOfSubarray = (i - nseli[i]) * (nseri[i] - i);
			long sum = ((numberOfSubarray % mod) * (a[i] % mod)) % mod;
			ans = (ans + sum) % mod ;
		}

		return ans;
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