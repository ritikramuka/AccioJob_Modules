import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here

		HashMap<Integer, Integer> fmap2 = new HashMap<>();
		for (int ele : brr) {
			if (fmap2.containsKey(ele) == true) {
				int freq = fmap2.get(ele);
				fmap2.put(ele, freq + 1);
			} else {
				fmap2.put(ele, 1);
			}
		}

		HashMap<Integer, Integer> fmap1 = new HashMap<>();
		for (int ele : arr) {
			fmap1.put(ele, fmap1.getOrDefault(ele, 0) + 1);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for (int key : fmap2.keySet()) {
			if (fmap2.get(key) != fmap1.getOrDefault(key, 0)) {
				ans.add(key);
			} 
		}

		if (ans.size() == 0) {
			System.out.print(-1 + " ");
			return;
		}

		Collections.sort(ans);
		for (int ele : ans) {
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