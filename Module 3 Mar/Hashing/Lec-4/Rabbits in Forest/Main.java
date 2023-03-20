import java.util.*;

class Solution {

    // TC: O(N), SC: O(N)
    public int numRabbits(int[] answers) {
        // key, ans -> number of rabbit with that ans
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int minRabbitVerified = 0;
        for (int key : map.keySet()) {
            int gs = key + 1;
            int numberOfAns = map.get(key);

            int fullyFilledGroups = numberOfAns / gs;
            int partiallyFilledGroups = numberOfAns % gs;

            int numberOfGroups = fullyFilledGroups;
            if (partiallyFilledGroups > 0) {
                numberOfGroups += 1;
            }

            int rabbitsFiguredOut = numberOfGroups * gs;
            minRabbitVerified += rabbitsFiguredOut;
        }

        return minRabbitVerified;
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
