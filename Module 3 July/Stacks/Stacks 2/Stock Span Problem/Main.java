import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
	static int[] nextGreaterElementOnLeftIndexwise(int [] arr) {
		int n = arr.length;

		// stack: index of people looking for there ngel
		Stack<Integer> st = new Stack<>();

		int[] ngeli = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			int ele = arr[i];

			while (st.size() > 0 && ele > arr[st.peek()]) {
				int idx = st.pop();
				ngeli[idx] = i;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			ngeli[idx] = -1;
		}

		return ngeli;
	}

	// TC: O(N), SC: O(N)
    static int[] stockSpan(int[] a) {
        int[] ngeli = nextGreaterElementOnLeftIndexwise(a);

		int n = a.length;
		
		int[] span = new int[n];

		// span[i] = i - ngeli[i]

		for (int i = 0; i < n; i++) {
			span[i] = i - ngeli[i];
		}

		return span;
    }
}