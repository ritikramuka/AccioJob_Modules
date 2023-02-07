import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine().trim());
    String inputLine[] = br.readLine().trim().split(" ");
    long[] arr = new long[(int) n];
    for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
    System.out.println(new Solution().maximumArea(arr, n));
  }
}

class Solution {

  //   static int[] getNSELI(long[] arr, int n) {
  //     int[] nseli = new int[n];
  //     Stack<Integer> st = new Stack<>();

  //     for (int i = n - 1; i >= 0; i--) {
  //       long ele = arr[i];

  //       while (st.size() > 0 && arr[st.peek()] > ele) {
  //         nseli[st.peek()] = i;
  //         st.pop();
  //       }

  //       st.push(i);
  //     }

  //     while (st.size() > 0) {
  //       nseli[st.peek()] = -1;
  //       st.pop();
  //     }

  //     return nseli;
  //   }

  //   static int[] getNSERI(long[] arr, int n) {
  //     int[] nseri = new int[n];
  //     Stack<Integer> st = new Stack<>();

  //     for (int i = 0; i < n; i++) {
  //       long ele = arr[i];

  //       while (st.size() > 0 && arr[st.peek()] > ele) {
  //         nseri[st.peek()] = i;
  //         st.pop();
  //       }

  //       st.push(i);
  //     }

  //     while (st.size() > 0) {
  //       nseri[st.peek()] = n;
  //       st.pop();
  //     }

  //     return nseri;
  //   }

  //   // TC: O(N), SC: O(N)
  //   public static long maximumArea(long hist[], long n) {
  //     //Your code here

  //     // step 1: get next smaller element on left index
  //     int[] nseli = getNSELI(hist, (int) n);

  //     // step 2: get next smaller element on right index
  //     int[] nseri = getNSERI(hist, (int) n);

  //     // step 3: get each area and store maximum area
  //     long maximumArea = 0;
  //     for (int i = 0; i < (int) n; i++) {
  //       long height = hist[i];
  //       int width = nseri[i] - nseli[i] - 1;
  //       long area = height * width;
  //       maximumArea = Math.max(maximumArea, area);
  //     }

  //     return maximumArea;
  //   }

  //   Method 2: TC: O(N), SC: O(N)
  public static long maximumArea(long arr[], long size) {
    //Your code here
    int n = (int) size;

    long maximumArea = 0;
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      long ele = arr[i];

      while (st.size() > 0 && arr[st.peek()] > ele) {
        int idx = st.peek();

        int rb = i;
        st.pop();

        int lb = -1;
        if (st.size() > 0) {
          lb = st.peek();
        } else {
          lb = -1;
        }

        int width = rb - lb - 1;
        long height = arr[idx];

        long area = width * height;
        maximumArea = Math.max(maximumArea, area);
      }

      st.push(i);
    }

    while (st.size() > 0) {
      int idx = st.peek();

      int rb = n;
      st.pop();

      int lb = -1;
      if (st.size() > 0) {
        lb = st.peek();
      } else {
        lb = -1;
      }

      int width = rb - lb - 1;
      long height = arr[idx];

      long area = width * height;
      maximumArea = Math.max(maximumArea, area);
    }

    return maximumArea;
  }
}
