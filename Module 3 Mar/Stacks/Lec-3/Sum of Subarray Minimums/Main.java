import java.io.*;
import java.util.*;

class Solution {
    long mod = 1000000007;

    public long minSubarraySum(int n, int a[]) {
        // write code here

        // next smaller on right
        Stack<Integer> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int ele = a[i];
            while (st.size() > 0 && ele < a[st.peek()]) {
                int rb = i;
                int lb = -1;
                int idx = st.pop();
                if (st.size() > 0) {
                    lb = st.peek();
                }

                long numberOfSubarrays = ((rb - idx) * (idx - lb)) % mod;
                long sol = (numberOfSubarrays * a[idx]) % mod;
                ans = (ans + sol) % mod;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int rb = n;
            int lb = -1;
            int idx = st.pop();
            if (st.size() > 0) {
                lb = st.peek();
            }

            long numberOfSubarrays = ((rb - idx) * (idx - lb)) % mod;
            long sol = (numberOfSubarrays * a[idx]) % mod;
            ans = (ans + sol) % mod;
        }

        return ans;
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