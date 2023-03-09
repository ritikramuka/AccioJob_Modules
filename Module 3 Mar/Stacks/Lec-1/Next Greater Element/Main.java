import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // TC: O(N), SC: O(N)
    // public static long[] nextLargerElement(long[] arr, int n) {
    // // stack will have potential next greater element on right side
    // Stack<Long> stack = new Stack<>();

    // // potential next greater element lies on right side of the array
    // // so let's compute potential next greater element for each element before
    // // reaching it, so move from right to left

    // long[] nger = new long[arr.length];

    // for (int i = arr.length - 1; i >= 0; i--) {
    // long ele = arr[i];
    // // check peek element of stack, if they are smaller than me them they can't
    // be
    // // my nger, so remove them
    // while (stack.size() > 0 && stack.peek() <= ele) {
    // stack.pop();
    // }

    // // peek element is my nger
    // if (stack.size() > 0) {
    // nger[i] = stack.peek();
    // } else {
    // nger[i] = -1;
    // }

    // // add myself to potentially nger for left people
    // stack.push(ele);
    // }

    // return nger;
    // }


    // TC: O(N), SC: O(N)
    public static long[] nextLargerElement(long[] arr, int n) {
        // Stack has people looking for there next greater element on right
        Stack<Integer> stack = new Stack<>();

        long[] nger = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            long ele = arr[i];

            // can I be anyone's nger
            while (stack.size() > 0 && ele > arr[stack.peek()]) {
                int idx = stack.peek();
                stack.pop();
                nger[idx] = ele;
            }

            // now I will also looking for my nger
            stack.push(i);
        }

        // people left in stack doesn't have their next nger
        while (stack.size() > 0) {
            int idx = stack.pop();
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