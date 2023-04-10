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
	static int[] getNSELI(long[] arr, int n) {
		// stack will have people looking for nseli
		Stack<Integer> st = new Stack<>();

		int[] nseli = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			long ele = arr[i];
			while (st.size() > 0 && ele < arr[st.peek()]) {
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

	static int[] getNSERI(long[] arr, int n) {
		// stack will have people looking for nseri
		Stack<Integer> st = new Stack<>();

		int[] nseri = new int[n];
		for (int i = 0; i < n; i++) {
			long ele = arr[i];
			while (st.size() > 0 && ele < arr[st.peek()]) {
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

	// TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n) {
		// get nseli
		int[] nseli = getNSELI(hist, (int) n);

		// get nseri
		int[] nseri = getNSERI(hist, (int) n);

		// get max area
		long maxArea = 0;
		for (int i = 0; i < (int) n; i++) {
			long h = hist[i];
			int w = nseri[i] - nseli[i] - 1;
			long area = h * w;

			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
    }
}