import java.util.*;

class Solution{
  //   static int[] SlidingWindowMaximum(int N, int K, int[] arr){
  //       // ngeri
		// Stack<Integer> st = new Stack<>();
		// int[] ngeri = new int[N];

		// for (int i = 0; i < N; i++) {
		// 	while (st.size() > 0 && arr[i] > arr[st.peek()]) {
		// 		int idx = st.pop();
		// 		ngeri[idx] = i;
		// 	}

		// 	st.push(i);
		// }

		// while (st.size() > 0) {
		// 	int idx = st.pop();
		// 	ngeri[idx] = N;
		// }

		// // N - K + 1 windows can be opened
		// int[] ans = new int[N - K + 1];

		// int j = 0;
		// for (int i = 0; i <= N - K; i++) {
		// 	if (j < i) {
		// 		j = i;
		// 	}
			
		// 	while (ngeri[j] < i + K) {
		// 		j = ngeri[j];
		// 	}

		// 	ans[i] = arr[j];
		// }

		// return ans;
  //   }

	// TC: O(N), SC: O(K)
	static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        int[] ans = new int[N - K + 1];
		int win_num = 0;

		// for stack -> addLast, removeLast
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			if (dq.size() > 0 && dq.peek() <= i - K) {
				dq.removeFirst();
			}
			
			while (dq.size() > 0 && arr[dq.getLast()] < arr[i]) {
				dq.removeLast();
			}

			dq.addLast(i);

			if (i >= K - 1) {
				ans[win_num] = arr[dq.peek()];
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
