/**
 * https://course.acciojob.com/idle?question=fb442623-31f7-48b8-b60f-34076c3b3d5e
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.prisonerAndHeights(h));
        
    }
}

class Solution {
	// TC: O(N), SC: O(N)
    public int prisonerAndHeights(int[] h) {
		// Your code here
		Stack<Integer> st = new Stack<>();
		int[] canSee = new int[h.length];

		for (int i = h.length - 1; i >= 0; i--) {
			while (st.size() > 0 && h[i] > h[st.peek()]) {
				int idx = st.pop();
				canSee[idx] += 1;
			}

			if (st.size() > 0) {
				// curr index is not ngel and there is no one in between greater min height of curr and peek
				canSee[st.peek()] += 1;
			}

			st.push(i);
		}

		int release = 0;
		for (int i = 1; i < canSee.length; i++) {
			if (canSee[i] > canSee[release]) {
				release = i;
			}
		}

		return release;
    }
}