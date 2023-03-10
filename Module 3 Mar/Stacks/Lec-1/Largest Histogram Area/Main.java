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
    // static int[] nseliSolve(long[] a, int n) {
    // // Your code here
    // Stack<Integer> stack = new Stack<Integer>();
    // int[] nseli = new int[n];

    // for (int i = n - 1; i >= 0; i--) {
    // long ele = a[i];
    // while (stack.size() > 0 && ele < a[stack.peek()]) {
    // int idx = stack.pop();
    // nseli[idx] = i;
    // }

    // stack.push(i);
    // }

    // while (stack.size() > 0) {
    // int idx = stack.pop();
    // nseli[idx] = -1;
    // }

    // return nseli;
    // }

    // static int[] nseriSolve(long[] a, int n) {
    // // Your code here
    // // stack has people looking for there nseri
    // Stack<Integer> stack = new Stack<Integer>();
    // int[] nseri = new int[n];

    // for (int i = 0; i < n; i++) {
    // long ele = a[i];
    // while (stack.size() > 0 && ele < a[stack.peek()]) {
    // int idx = stack.pop();
    // nseri[idx] = i;
    // }

    // stack.push(i);
    // }

    // while (stack.size() > 0) {
    // int idx = stack.pop();
    // nseri[idx] = n;
    // }

    // return nseri;
    // }

    // // TC: O(N), SC: O(N)
    // public static long maximumArea(long hist[], long n) {
    // // next smaller element on left side index
    // int[] nseli = nseliSolve(hist, (int) n);

    // // next smaller element on right side index
    // int[] nseri = nseriSolve(hist, (int) n);

    // // step 3: get width and max Area
    // long maxArea = 0;

    // for (int i = 0; i < (int) n; i++) {
    // long height = hist[i];
    // int width = nseri[i] - nseli[i] - 1;
    // long area = height * width;
    // maxArea = Math.max(maxArea, area);
    // }

    // return maxArea;
    // }


    // TC: O(N), SC: O(N) : Single pass
    public static long maximumArea(long hist[], long n) {
        Stack<Integer> stack = new Stack<Integer>();
        long maxArea = 0;
        for (int i = 0; i < (int) n; i++) {
            long ele = hist[i];
            while (stack.size() > 0 && ele < hist[stack.peek()]) {
                int idx = stack.pop();
                int rb = i;
                int lb = -1;
                if (stack.size() > 0) {
                    lb = stack.peek();
                }
                int width = rb - lb - 1;
                long area = hist[idx] * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (stack.size() > 0) {
            int idx = stack.pop();
            int rb = (int) n;
            int lb = -1;
            if (stack.size() > 0) {
                lb = stack.peek();
            }
            int width = rb - lb - 1;
            long area = hist[idx] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
