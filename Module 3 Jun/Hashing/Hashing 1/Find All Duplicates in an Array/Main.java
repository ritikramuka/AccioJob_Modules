import java.util.*;

class Solution {
  //   public void allDuplicates(int n, int[] arr) {
  //       // Write Your code here.
		// Arrays.sort(arr);

		// HashSet<Integer> set = new HashSet<>();
		// for (int ele : arr) {
		// 	if (set.contains(ele) == true) {
		// 		System.out.print(ele + " ");
		// 	} else {
		// 		set.add(ele);
		// 	}
		// }

		// System.out.println();
  //   }

	// TC: O(N), SC: O(N)
	public void allDuplicates(int n, int[] arr) {
        // Write Your code here.

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
			if (fmap.containsKey(i) == true && fmap.get(i) == 2) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
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