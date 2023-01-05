import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
    }
}

class Solution {
    static int[] nextSmallerEleOnLeftIdx(long[] arr, int n) {
        int[] nseli = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
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

    static int[] nextSmallerEleOnRightIdx(long[] arr, int n) {
        int[] nseri = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
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
        // Your code here
        
        // TC: O(N), SC: O(N)
        int[] nseli = nextSmallerEleOnLeftIdx(hist, (int) n);

        // TC: O(N), SC: O(N)
        int[] nseri = nextSmallerEleOnRightIdx(hist, (int) n);

        // TC: O(N), SC: O(1)
        long maxArea = 0;
        for (int i = 0; i < (int) n; i++) {
            long height = hist[i];
            int width = nseri[i] - nseli[i] - 1;
            long area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
