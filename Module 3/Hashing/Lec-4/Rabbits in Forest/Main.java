import java.util.*;

class Solution{
    public int numRabbits(int[] arr) {
        // write code here
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int a : arr) {
            fmap.put(a, fmap.getOrDefault(a, 0) + 1);
        }

        int ans = 0;
        for (int key : fmap.keySet()) {
            int gs = key + 1;
            int reportees = fmap.get(key);

            int ng = reportees / gs;
            if (reportees % gs > 0) {
                ng++;
            }
            ans += ng * gs;
        }

        return ans;
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
