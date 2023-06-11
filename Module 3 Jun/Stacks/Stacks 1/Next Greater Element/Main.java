import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	// method 1
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Write code here and print output

		// stack: potential nger
		Stack<Long> st = new Stack<>();

		long[] nger = new long[n];

		for (int i = n - 1; i >= 0; i--) {
			// remove smaller people in stack, as they can't be my nger, and I will cover for them so they are not usefull
			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}

			if (st.size() > 0) {
				nger[i] = st.peek();
			} else {
				nger[i] = -1;
			}

			st.push(arr[i]);
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