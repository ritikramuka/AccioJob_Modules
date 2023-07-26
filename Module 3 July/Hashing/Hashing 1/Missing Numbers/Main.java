import java.util.*;

class Solution {
	// TC: O(N log N), SC: O(N)
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here

		// diff freq people + extra ele in second array

		HashMap<Integer, Integer> fmap1 = new HashMap<>();
		for (int num : arr) {
			fmap1.put(num, fmap1.getOrDefault(num, 0) + 1);
		}

		HashMap<Integer, Integer> fmap2 = new HashMap<>();
		for (int num : brr) {
			fmap2.put(num, fmap2.getOrDefault(num, 0) + 1);
		}

		ArrayList<Integer> missingNum = new ArrayList<>();
		for (int key : fmap2.keySet()) {
			if (fmap2.get(key) != fmap1.getOrDefault(key, 0)) {
				missingNum.add(key);
			}
		}

		Collections.sort(missingNum);

		if (missingNum.size() == 0) {
			System.out.print(-1 + " ");
			return;
		}
		
		for (int i : missingNum) {
			System.out.print(i + " ");
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