import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.arcadeFrenzy(scores, k));

    }
}

class Solution {
    class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    // TC: O(N), SC: O(N)
    public int arcadeFrenzy(int[] scores, int k) {
        int n = scores.length;

        Deque<Pair> dq = new ArrayDeque<>();

        long currSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            currSum += scores[i];

            if (currSum >= k) {
                int len = i + 1;
                minLen = Math.min(len, minLen);
            }

            while (dq.size() > 0 && currSum - dq.getFirst().sum >= k) {
                int len = i - dq.getFirst().idx;
                minLen = Math.min(len, minLen);
                dq.removeFirst();
            }

            while (dq.size() > 0 && dq.getLast().sum > currSum) {
                dq.removeLast();
            }

            dq.addLast(new Pair(currSum, i));
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}