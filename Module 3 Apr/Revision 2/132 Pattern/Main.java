import java.util.*;

class Solution {

	class Pair {
		int val;
		int minVal;

		Pair (int val, int minVal) {
			this.val = val;
			this.minVal = minVal;
		}
	}
	
    public boolean find132pattern(int[] nums) {
        //Write code here
		Stack<Pair> st = new Stack<>();
		int minVal = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			while (st.size() > 0 && nums[i] > st.peek().val) {
				st.pop();
			}

			if (st.size() > 0 && nums[i] > st.peek().minVal) {
				return true;
			}

			st.push(new Pair(nums[i], minVal));

			minVal = Math.min(minVal, nums[i]);
		}

		return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        boolean result = Obj.find132pattern(arr);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}