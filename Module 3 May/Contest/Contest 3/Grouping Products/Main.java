/**
 * https://course.acciojob.com/idle?question=27d25f78-8608-4868-ae34-3633856e2577
 */

import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
    public List<List<Integer>> groupThePeople(int[] gz) {
        //Write code here
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int id = 0; id < gz.length; id++) {
			int gs = gz[id];
			if (map.containsKey(gs) == false) {
				List<Integer> list = new ArrayList<>();
				list.add(id);
				map.put(gs, list);
			} else {
				List<Integer> list = map.get(gs);
				list.add(id);
				map.put(gs, list);
			}
		}

		List<List<Integer>> ans = new ArrayList<>();
		for (int gs : map.keySet()) {
			int cnt = 0;
			while (cnt < map.get(gs).size()) {
				List<Integer> currGrp = new ArrayList<>();
				for (int i = cnt; i < cnt + gs; i++) {
					currGrp.add(map.get(gs).get(i));	
				}
				ans.add(currGrp);
				cnt += gs;
			}
		}

		return ans;
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
        List<List<Integer>> res = Obj.groupThePeople(arr);
        Collections.sort(res, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
        sc.close();
    }
}