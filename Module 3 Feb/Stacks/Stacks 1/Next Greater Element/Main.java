import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  //   public static long[] nextLargerElement(long[] arr, int n) {
  //     //Write code here and print output
  //     Stack<Long> st = new Stack<>();
  //     long[] nger = new long[n];

  //     // traverse from right to left
  //     // because I want info about potential nge
  //     for (int i = n - 1; i >= 0; i--) {
  //       // remove smaller potential nge from stack
  //       // as I'm covering for them
  //       while (st.size() > 0 && st.peek() <= arr[i]) {
  //         st.pop();
  //       }

  //       if (st.size() == 0) {
  //         nger[i] = -1;
  //       } else {
  //         nger[i] = st.peek();
  //       }

  //       st.push(arr[i]);
  //     }

  //     return nger;
  //   }

  public static long[] nextLargerElement(long[] arr, int n) {
    //Write code here and print output
    Stack<Integer> st = new Stack<>();
    long[] nger = new long[n];

    // traverse from left to right
    // because I want to create a pool of people looking for nge
    for (int i = 0; i < n; i++) {
      long ele = arr[i];

      // I can be a nge
      // go and see in pool, who all intrested
      while (st.size() > 0 && arr[st.peek()] < ele) {
        nger[st.peek()] = ele;
        st.pop();
      }

      //   I'm also looking for my nge
      st.push(i);
    }

    // people still looking for nge, will have it as -1
    while (st.size() > 0) {
      nger[st.peek()] = -1;
      st.pop();
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
    for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
    long[] res = new Solution().nextLargerElement(arr, n);
    for (int i = 0; i < n; i++) System.out.print(res[i] + " ");
    System.out.println();
  }
}
