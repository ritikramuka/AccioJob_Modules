import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
    public void allDuplicates(int n, int[] arr) {
        // Write Your code here.

		// key, value pair -> key => value will be its freq
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int ele : arr) {
			if (fmap.containsKey(ele) == true) {
				int prevFreq = fmap.get(ele);
				fmap.put(ele, prevFreq + 1);
			} else {
				fmap.put(ele, 1);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (fmap.containsKey(i) && fmap.get(i) > 1) {
				System.out.print(i + " ");
			}
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}