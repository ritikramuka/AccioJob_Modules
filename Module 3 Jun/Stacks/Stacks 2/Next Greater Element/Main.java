import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	// method 1
	// TC: O(N), SC: O(N)
  //   public static long[] nextLargerElement(long[] arr, int n)
  //   { 
  //       // Write code here and print output

		// // stack: potential nger
		// Stack<Long> st = new Stack<>();

		// long[] nger = new long[n];

		// for (int i = n - 1; i >= 0; i--) {
		// 	// remove smaller people in stack, as they can't be my nger, and I will cover for them so they are not usefull
		// 	while (st.size() > 0 && st.peek() <= arr[i]) {
		// 		st.pop();
		// 	}

		// 	if (st.size() > 0) {
		// 		nger[i] = st.peek();
		// 	} else {
		// 		nger[i] = -1;
		// 	}

		// 	st.push(arr[i]);
		// }

		// return nger;
  //   } 


	// Method 2
	// TC: O(N), SC: O(N)
	public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Write code here and print output

		// Stack: people looking for there nger
		Stack<Integer> st = new Stack<>();

		long[] nger = new long[n];

		for (int i = 0; i < n; i++) {
			long ele = arr[i];

			while (st.size() > 0 && arr[st.peek()] < ele) {
				int idx = st.pop();
				nger[idx] = ele;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			nger[idx] = -1;
		}

		return nger;
    } 
}

class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}