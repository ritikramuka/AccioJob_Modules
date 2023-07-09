import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
  //   public static long[] nextLargerElement(long[] arr, int n)
  //   { 
  //       // stack holds potential nger
		// Stack<Long> st = new Stack<>();

		// long[] nger = new long[n];

		// for (int i = n - 1; i >= 0; i--) {
		// 	long ele = arr[i];

		// 	while (st.size() > 0 && st.peek() <= ele) {
		// 		st.pop();
		// 	}

		// 	if (st.size() == 0) {
		// 		nger[i] = -1;
		// 	} else {
		// 		nger[i] = st.peek();
		// 	}

		// 	st.push(ele);
		// }

		// return nger;
  //   } 

	public static long[] nextLargerElement(long[] arr, int n)
    { 
        // stack: people looking for nger
		Stack<Integer> st = new Stack<>();

		long[] nger = new long[n];

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