import java.util.*;

class Solution{
	// TC: O(N), SC: O(N)
    public int numRabbits(int[] answers) {
        // write code here

		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int ans : answers) {
			fmap.put(ans, fmap.getOrDefault(ans, 0) + 1);
		}

		int totalRabbits = 0;
		for (int ans : fmap.keySet()) {
			int cnt = fmap.get(ans);

			int numberOfGroups = 0;
			if (cnt / (ans + 1) > 0) {
				numberOfGroups += (cnt / (ans + 1));
			}

			if (cnt % (ans + 1) != 0) {
				numberOfGroups += 1;
			}

			totalRabbits += numberOfGroups * (ans + 1);
		}

		return totalRabbits;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.numRabbits(arr));
    }
}
