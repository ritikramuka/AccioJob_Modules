import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // public static long[] nextLargerElement(long[] arr, int n)
    // {
    // //Write code here and print output

    // // potential next greater elements on right
    // Stack<Long> st = new Stack<>();
    // long[] nger = new long[n];

    // for (int i = n - 1; i >= 0; i--) {
    // // do you have people in stack
    // // if there are people in stack, are they big enough to be mine next greater
    // on right
    // // if not remove them
    // while (st.size() > 0 && st.peek() <= arr[i]) {
    // st.pop();
    // }

    // if (st.size() == 0) {
    // nger[i] = -1;
    // } else {
    // nger[i] = st.peek();
    // }

    // // I can also be a potential nger for left people
    // st.push(arr[i]);
    // }

    // return nger;
    // }

    // TC: O(N), SC: O(N)
    public static long[] nextLargerElement(long[] arr, int n) {
        // Write code here and print output

        // pool of people looking for next greater element on right
        Stack<Integer> st = new Stack<>();
        long[] nger = new long[n];

        for (int i = 0; i < n; i++) {
            // are there people in stack
            // can I be there nger
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int idx = st.pop();
                nger[idx] = arr[i];
            }

            // now I'm finding my nger
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