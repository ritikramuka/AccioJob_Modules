import java.io.*;
import java.util.*;

class Solution {
  long mod = 1000000007;

  public long minSubarraySum(int n, int a[]) {
    // write code here
    Stack<Integer> st = new Stack<>();

    long sum = 0;
    for (int i = 0; i < n; i++) {
      int ele = a[i];
      while (st.size() > 0 && ele < a[st.peek()]) {
        int rb = i;
        int cidx = st.pop();

        int lb = -1;
        if (st.size() > 0) {
          lb = st.peek();
        }

        long numberOfSubarrays = ((cidx - lb) * (rb - cidx)) % mod;
        long currSum = (numberOfSubarrays * a[cidx]) % mod;
        sum = (sum + currSum) % mod;
      }

      st.push(i);
    }

    while (st.size() > 0) {
      int rb = n;
      int cidx = st.pop();

      int lb = -1;
      if (st.size() > 0) {
        lb = st.peek();
      }

      long numberOfSubarrays = ((cidx - lb) * (rb - cidx)) % mod;
      long currSum = (numberOfSubarrays * a[cidx]) % mod;
      sum = (sum + currSum) % mod;
    }

    return sum % mod;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.minSubarraySum(n, a));
  }
}
