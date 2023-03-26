import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    // public ArrayList<Integer> duplicateBookIDS(int[] book) {
    // //Write code here
    // HashMap<Integer, Integer> fmap = new HashMap<>();
    // for (int id : book) {
    // fmap.put(id, fmap.getOrDefault(id, 0) + 1);
    // }

    // ArrayList<Integer> ans = new ArrayList<>();
    // for (int id : fmap.keySet()) {
    // if (fmap.get(id) > 1) {
    // ans.add(id);
    // }
    // }

    // return ans;
    // }

    // TC: O(N), SC: O(N)
    public ArrayList<Integer> duplicateBookIDS(int[] book) {
        // Write code here
        HashSet<Integer> vis = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int id : book) {
            if (vis.contains(id) == true) {
                ans.add(id);
            }

            vis.add(id);
        }

        ArrayList<Integer> sol = new ArrayList<>();
        for (int id : ans) {
            sol.add(id);
        }

        return sol;
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
        ArrayList<Integer> res = Obj.duplicateBookIDS(arr);
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
        sc.close();
    }
}