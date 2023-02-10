import java.util.*;

class Solution {

  // TC: O(N), SC: O(K)
  static int[] SlidingWindowMaximum(int n, int k, int[] arr) {
    // write code here
    int[] ans = new int[n - k + 1];
    int itr = 0;

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (dq.size() > 0 && dq.getFirst() == i - k) {
        dq.removeFirst();
      }

      while (dq.size() > 0 && arr[dq.getLast()] <= arr[i]) {
        dq.removeLast();
      }

      dq.addLast(i);

      if (i >= k - 1) {
        ans[itr] = arr[dq.getFirst()];
        itr++;
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
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution obj = new Solution();
    int[] ans = obj.SlidingWindowMaximum(n, k, nums);
    for (int i = 0; i < ans.length; ++i) {
      System.out.print(ans[i] + " ");
    }
  }
}
