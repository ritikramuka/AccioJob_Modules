import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public List<Integer> missingFromRange(int[] balance) {
        // Write code here

        HashSet<Integer> set = new HashSet<>();

        for (int val : balance) {
            set.add(val);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= balance.length; i++) {
            if (set.contains(i) == false) {
                ans.add(i);
            }
        }

        return ans;
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
        List<Integer> res = Obj.missingFromRange(arr);
        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
        sc.close();
    }
}