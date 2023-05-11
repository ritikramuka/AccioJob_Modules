import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{
	// // TC: O(N), SC: O(N)
	// static int[] nextSmallerElementOnLeftIndexwise(long[] a, int n) {
	// 	// Stack: people looking for nsel
	// 	Stack<Integer> st = new Stack<>();

	// 	int[] nseli = new int[n];

	// 	// right to left
	// 	for (int i = n - 1; i >= 0; i--) {
	// 		long ele = a[i];

	// 		while (st.size() > 0 && ele < a[st.peek()]) {
	// 			int idx = st.pop();
	// 			nseli[idx] = i;
	// 		}

	// 		st.push(i);
	// 	}

	// 	while (st.size() > 0) {
	// 		int idx = st.pop();
	// 		nseli[idx] = -1;
	// 	}

	// 	return nseli;
	// }

	// static int[] nextSmallerElementOnRightIndexwise(long[] a, int n) {
	// 	// Stack: people looking for nser
	// 	Stack<Integer> st = new Stack<>();

	// 	int[] nseri = new int[n];

	// 	// left to right
	// 	for (int i = 0; i < n; i++) {
	// 		long ele = a[i];

	// 		while (st.size() > 0 && ele < a[st.peek()]) {
	// 			int idx = st.pop();
	// 			nseri[idx] = i;
	// 		}

	// 		st.push(i);
	// 	}

	// 	while (st.size() > 0) {
	// 		int idx = st.pop();
	// 		nseri[idx] = n;
	// 	}

	// 	return nseri;
	// }

	// // TC: O(N), SC: O(N)
 //    public static long maximumArea(long hist[], long n){
	// 	//Your code here   

	// 	int[] nseli = nextSmallerElementOnLeftIndexwise(hist, (int) n);

	// 	int[] nseri = nextSmallerElementOnRightIndexwise(hist, (int) n);

	// 	// width = rb - lb - 1
	// 	// area = height * width

	// 	long maxArea = 0;
	// 	for (int i = 0; i < (int) n; i++) {
	// 		long h = hist[i];

	// 		long w = nseri[i] - nseli[i] - 1;

	// 		long area = h * w;

	// 		maxArea = Math.max(maxArea, area);
	// 	}

	// 	return maxArea;
 //    }


	// // TC: O(N), SC: O(N)
 //    public static long maximumArea(long hist[], long n){
	// 	//Your code here   

	// 	int[] nseli = new int[(int) n];
	// 	int[] nseri = new int[(int) n];

	// 	Stack<Integer> st = new Stack<>();

	// 	// right to left
	// 	for (int i = (int) n - 1; i >= 0; i--) {
	// 		long ele = hist[i];

	// 		while (st.size() > 0 && ele < hist[st.peek()]) {
	// 			int idx = st.pop();
	// 			nseli[idx] = i;

	// 			// person on top of stack is nseri
	// 			if (st.size() > 0) {
	// 				nseri[idx] = st.peek();
	// 			} else {
	// 				nseri[idx] = (int) n;
	// 			}
	// 		}

	// 		st.push(i);
	// 	}

	// 	while (st.size() > 0) {
	// 		int idx = st.pop();
	// 		nseli[idx] = -1;

	// 		// person on top of stack is nseri
	// 		if (st.size() > 0) {
	// 			nseri[idx] = st.peek();
	// 		} else {
	// 			nseri[idx] = (int) n;
	// 		}
	// 	}

	// 	// width = rb - lb - 1
	// 	// area = height * width

	// 	long maxArea = 0;
	// 	for (int i = 0; i < (int) n; i++) {
	// 		long h = hist[i];

	// 		long w = nseri[i] - nseli[i] - 1;

	// 		long area = h * w;

	// 		maxArea = Math.max(maxArea, area);
	// 	}

	// 	return maxArea;
 //    }

	// TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n){
		long maxArea = 0;

		Stack<Integer> st = new Stack<>();

		// right to left
		for (int i = (int) n - 1; i >= 0; i--) {
			long ele = hist[i];

			while (st.size() > 0 && ele < hist[st.peek()]) {
				int idx = st.pop();
				
				int lb = i;
				int rb = (int) n;

				// person on top of stack is nseri
				if (st.size() > 0) {
					rb= st.peek();
				}

				long area = hist[idx] * (rb - lb - 1);
				maxArea = Math.max(maxArea, area);
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
				
			int lb = -1;
			int rb = (int) n;

			// person on top of stack is nseri
			if (st.size() > 0) {
				rb= st.peek();
			}

			long area = hist[idx] * (rb - lb - 1);
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
    }
}



