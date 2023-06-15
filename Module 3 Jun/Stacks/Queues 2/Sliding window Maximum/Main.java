import java.util.*;

class Solution{
	// TC: O(N), SC: O(K)
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here

		// removeLast, addLast
		Deque<Integer> dq = new ArrayDeque<>();

		int[] ans = new int[N - K + 1];
		int win_num = 0;

		for (int i = 0; i < N; i++) {
			if (dq.size() > 0 && dq.getFirst() <= i - K) {
				dq.removeFirst();
			} 

			while (dq.size() > 0 && arr[dq.getLast()] < arr[i]) {
				dq.removeLast();
			}

			dq.addLast(i);

			if (i >= K - 1) {
				ans[win_num] = arr[dq.getFirst()];
				win_num++;
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
