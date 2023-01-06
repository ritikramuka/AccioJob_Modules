import java.io.*;
import java.util.*;

class Solution {
    int mod = 1000000007;

    // TC: O(N), SC: O(N)
    public long minSubarraySum(int n, int a[]) {
        // write code here
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && a[i] < a[st.peek()]) {
                int cidx = st.pop();
                int r = i;
                int l = -1;
                if (st.size() > 0) {
                    l = st.peek();
                }

                long numberOfSubarrayWithMinimumAsCurr = ((r - cidx) * (cidx - l)) % mod;
                sum += (numberOfSubarrayWithMinimumAsCurr * a[cidx]) % mod;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int cidx = st.pop();
            int r = n;
            int l = -1;
            if (st.size() > 0) {
                l = st.peek();
            }

            long numberOfSubarrayWithMinimumAsCurr = ((r - cidx) * (cidx - l)) % mod;
            sum += (numberOfSubarrayWithMinimumAsCurr * a[cidx]) % mod;
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