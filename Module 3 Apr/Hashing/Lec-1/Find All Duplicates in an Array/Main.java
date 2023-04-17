import java.util.*;

class Solution {
    public void allDuplicates(int n, int[] arr) {
        // Write Your code here.
		Arrays.sort(arr);
		
		// HashSet<Integer> set = new HashSet<>();
		// for (int ele : arr) {
		// 	if (set.contains(ele) == true) {
		// 		System.out.print(ele + " ");
		// 	} else {
		// 		set.add(ele);
		// 	}
		// }

		// HashMap<Integer, Integer> fmap = new HashMap();
		// for (int ele : arr) {
		// 	fmap.put(ele, fmap.getOrDefault(ele, 0) + 1);
		// }

		// for (int key : fmap.keySet()) {
		// 	if (fmap.get(key) == 2) {
		// 		System.out.print(key + " ");
		// 	}
		// }

		for(int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.print(arr[i] + " ");
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