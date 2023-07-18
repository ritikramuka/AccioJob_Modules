import java.util.*;

class Solution{
	// static int[] nextGreaterElementOnRightIndexwise(int[] arr) {
	// 	int n = arr.length;

	// 	// Stack: people looking for nser
	// 	Stack<Integer> st = new Stack<>();

	// 	int[] ngeri = new int[n]; 
		
	// 	for (int i = 0; i < n; i++) {
	// 		int ele = arr[i];

	// 		while (st.size() > 0 && ele > arr[st.peek()]) {
	// 			int idx = st.pop();
	// 			ngeri[idx] = i;
	// 		}

	// 		st.push(i);
	// 	}

	// 	while (st.size() > 0) {
	// 		int idx = st.pop();
	// 		ngeri[idx] = n;
	// 	}

	// 	return ngeri;
	// }
	
  //   static int[] SlidingWindowMaximum(int n, int k, int[] arr){
  //       // write code here

		// int[] ngeri = nextGreaterElementOnRightIndexwise(arr);

		// int[] ans = new int[n - k + 1];
		// int j = 0;
		// for (int i = 0; i < n - k + 1; i++) {
		// 	if (j < i) {
		// 		j = i;
		// 	}

		// 	while (ngeri[j] <= i + k - 1) {
		// 		j = ngeri[j];
		// 	}

		// 	ans[i] = arr[j];
		// }

		// return ans;
  //   }

	// TC: O(N), SC: O(N)
	static int[] SlidingWindowMaximum(int n, int k, int[] arr){
        // write code here
		Deque<Integer> st = new ArrayDeque<>();

		int[] ans = new int[n - k + 1];
		int win_num = 0;
		for (int i = 0; i < n; i++) {
			if (st.size() > 0 && st.getFirst() == i - k) {
				st.removeFirst();
			}

			int ele = arr[i];
			while (st.size() > 0 && arr[st.getLast()] < ele) {
				st.removeLast();
			}

			st.addLast(i);

			if (i >= k - 1) {
				ans[win_num] = arr[st.getFirst()];
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
