import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	// method 1
  //   public static long[] nextLargerElement(long[] arr, int n)
  //   { 
  //       //Write code here and print output

		// // stack is having potential next greater element on right
		// Stack<Long> st = new Stack<>();

		// long[] nger = new long[n];

		// // going from right to left, because we no nger for rightmost person is -1
		// for (int i = n - 1; i >= 0; i--) {
		// 	// are there some potential nger in stack smaller than you, if yes remove them
		// 	// I'm comvering all the range for them
		// 	while (st.size() > 0 && arr[i] >= st.peek()) {
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

	public static long[] nextLargerElement(long[] arr, int n)
    { 
        //Write code here and print output

		// Stack: people looking for next greater element on right
		Stack<Integer> st = new Stack<>();

		long[] nger = new long[n];

		// left to right
		for (int i = 0; i < n; i++) {
			long ele = arr[i];

			while (st.size() > 0 && ele > arr[st.peek()]) {
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