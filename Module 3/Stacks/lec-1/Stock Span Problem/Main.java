import java.io.*;
import java.util.*;

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
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
        Solution s = new Solution();
        int ans[] = s.stockSpan(a);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    static int[] nextGreaterEleOnLeftIdx(int[] a, int n) {
        int[] ngeli = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(i);
            } else {
                while (st.size() > 0 && a[st.peek()] < a[i]) {
                    int idx = st.pop();
                    ngeli[idx] = i;
                }

                st.push(i);
            }
        }

        while (st.size() > 0) {
            int idx = st.pop();
            ngeli[idx] = -1;
        }

        return ngeli;
    }

    static int[] stockSpan(int[] a) {
        int[] ngeli = nextGreaterEleOnLeftIdx(a, a.length);
        int[] span = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            span[i] = i - ngeli[i];
        }
        return span;
    }
}