import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int numRabbits(int[] answers) {
        // write code here

        // answers, reportess
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int answer : answers) {
            fmap.put(answer, fmap.getOrDefault(answer, 0) + 1);
        }

        int confirmedRabbitsInForest = 0;
        for (int key : fmap.keySet()) {
            int gs = key + 1;
            int reportess = fmap.get(key);

            int fullOccupiedGroups = reportess / gs;
            int partiallyOccupiedGroup = (reportess % gs) != 0 ? 1 : 0;

            int numberOfGroups = fullOccupiedGroups + partiallyOccupiedGroup;

            int numberOfRabbits = numberOfGroups * gs;

            confirmedRabbitsInForest += numberOfRabbits;
        }

        return confirmedRabbitsInForest;
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
        Solution Obj = new Solution();
        System.out.println(Obj.numRabbits(arr));
    }
}
