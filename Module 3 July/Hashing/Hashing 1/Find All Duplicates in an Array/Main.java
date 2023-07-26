import java.util.*;

class Solution {
  //   public void allDuplicates(int n, int[] arr) {
  //       // Write Your code here.
		
		// // HashMap -> num (key) -> freq (value)
		// HashMap<Integer, Integer> fmap = new HashMap<>();

		// for (int num : arr) {
		// 	if (fmap.containsKey(num) == true) {
		// 		System.out.print(num + " ");
		// 	} else {
		// 		fmap.put(num, 1);
		// 	}
		// }
  //   }

	public void allDuplicates(int n, int[] arr) {
        // Write Your code here.
		
		HashSet<Integer> set = new HashSet<>();

		for (int num : arr) {
			if (set.contains(num) == true) {
				System.out.print(num + " ");
			} else {
				set.add(num);
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