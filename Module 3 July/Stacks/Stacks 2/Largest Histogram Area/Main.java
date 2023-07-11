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

class Solution {
	// static int[] nextSmallerElementOnRightIndexwise(long[] arr) {
	// 	int n = arr.length;

	// 	// Stack: people looking for nser
	// 	Stack<Integer> st = new Stack<>();

	// 	int[] nseri = new int[n]; 
		
	// 	for (int i = 0; i < n; i++) {
	// 		long ele = arr[i];

	// 		while (st.size() > 0 && ele < arr[st.peek()]) {
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

	// static int[] nextSmallerElementOnLeftIndexwise(long[] arr) {
	// 	int n = arr.length;

	// 	// Stack: people looking for nsel
	// 	Stack<Integer> st = new Stack<>();

	// 	int[] nseli = new int[n]; 
		
	// 	for (int i = n - 1; i >= 0; i--) {
	// 		long ele = arr[i];

	// 		while (st.size() > 0 && ele < arr[st.peek()]) {
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

	// // TC: O(N), SC: O(N)
 //    public static long maximumArea(long hist[], long n){
	// 	//Your code here  
	// 	int[] nseri = nextSmallerElementOnRightIndexwise(hist);
	// 	int[] nseli = nextSmallerElementOnLeftIndexwise(hist);

	// 	long maxArea = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		int w = nseri[i] - nseli[i] - 1;
	// 		long h = hist[i];
	// 		long area = h * w;
	// 		maxArea = Math.max(maxArea, area);
	// 	}

	// 	return maxArea;
 //    }

	
	// // TC: O(N), SC: O(N)
 //    public static long maximumArea(long hist[], long n){
	// 	//Your code here  
	// 	int[] nseri = new int[(int) n];
	// 	int[] nseli = new int[(int) n];

	// 	// people looking nsel
	// 	Stack<Integer> st = new Stack<>();

	// 	for (int i = (int)n - 1; i >= 0; i--) {
	// 		long ele = hist[i];

	// 		while (st.size() > 0 && ele < hist[st.peek()]) {
	// 			int idx = st.pop();
	// 			nseli[idx] = i;

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

	// 		if (st.size() > 0) {
	// 			nseri[idx] = st.peek();
	// 		} else {
	// 			nseri[idx] = (int) n;
	// 		}
	// 	}

	// 	long maxArea = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		int w = nseri[i] - nseli[i] - 1;
	// 		long h = hist[i];
	// 		long area = h * w;
	// 		maxArea = Math.max(maxArea, area);
	// 	}

	// 	return maxArea;
 //    }

	// TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n){
		//Your code here 
		long maxArea = 0;

		// people looking nsel
		Stack<Integer> st = new Stack<>();

		for (int i = (int)n - 1; i >= 0; i--) {
			long ele = hist[i];

			while (st.size() > 0 && ele < hist[st.peek()]) {
				int idx = st.pop();
				int LB = i;

				int RB = (int) n;
				if (st.size() > 0) {
					RB = st.peek();
				}

				int w = RB - LB - 1;
				long h = hist[idx];
				long area = h * w;
				maxArea = Math.max(maxArea, area);
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			int LB = -1;

			int RB = (int) n;
			if (st.size() > 0) {
				RB = st.peek();
			}

			int w = RB - LB - 1;
			long h = hist[idx];
			long area = h * w;
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
    }
}



