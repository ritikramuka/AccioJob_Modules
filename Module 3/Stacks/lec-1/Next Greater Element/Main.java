import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Approach 1 : TC: O(N), SC: O(N)
    // public static long[] nextLargerElement(long[] arr, int n) {
    //     // Write code here and print output
    //     long[] nger = new long[n];
    //     Stack<Long> st = new Stack<>();

    //     for (int i = n - 1; i >= 0; i--) {
    //         if (st.size() == 0) {
    //             nger[i] = -1;
    //         } else {
    //             while (st.size() > 0 && st.peek() <= arr[i]) {
    //                 st.pop();
    //             }

    //             if (st.size() == 0) {
    //                 nger[i] = -1;
    //             } else {
    //                 nger[i] = st.peek();
    //             }
    //         }

    //         st.push(arr[i]);
    //     }

    //     return nger;
    // }

    // Approach 2: 
    public static long[] nextLargerElement(long[] arr, int n) {
        // Write code here and print output
        long[] nger = new long[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                nger[idx] = arr[i];
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(inputLine[i]);
        long[] res = new Solution().nextLargerElement(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
        System.out.println();
    }
}