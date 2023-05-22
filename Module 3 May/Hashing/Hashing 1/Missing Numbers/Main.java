import java.util.*;

class Solution {
	// TC: O(N log N), SC: O(N)
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here

		// elements with diff freq + extra ele in second array

		HashMap<Integer, Integer> fmap1 = new HashMap<>();
		for (int ele : arr) {
			fmap1.put(ele, fmap1.getOrDefault(ele, 0) + 1);
		}

		HashMap<Integer, Integer> fmap2 = new HashMap<>();
		for (int ele : brr) {
			fmap2.put(ele, fmap2.getOrDefault(ele, 0) + 1);
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int key : fmap2.keySet()) {
			if (fmap1.containsKey(key) == false) {
				list.add(key);
			} else {
				if (fmap1.get(key) != fmap2.get(key)) {
					list.add(key);
				}
			}
		}

		if (list.size() == 0) {
			System.out.print(-1);
			return;
		}
		
		Collections.sort(list);
		for (int ele : list) {
			System.out.print(ele + " ");
		}
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}