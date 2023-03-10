import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M, N));
    }
}

class Solution {
    // TC: O(N), SC: O(N)
    int findCelebrity(int M[][], int n) {
        // given a person never knows himself
        // celeb is person, who doesn't know anyone, and is known by everyone

        Stack<Integer> potentialCelebs = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            potentialCelebs.push(i);
        }

        while (potentialCelebs.size() > 1) {
            int p1 = potentialCelebs.pop();
            int p2 = potentialCelebs.pop();

            if (M[p1][p2] == 1) {
                // if p1 knows p2, then p1 is not a celebrity
                potentialCelebs.push(p2);
            } else {
                // if p1 doesn't know p2, then p2 is not a celeb
                potentialCelebs.push(p1);
            }
        }

        int pCeleb = potentialCelebs.pop();

        // I don't know anyone
        for (int c = 0; c < n; c++) {
            if (M[pCeleb][c] == 1) {
                return -1;
            }
        }

        // I should be known by everyone
        for (int r = 0; r < n; r++) {
            if (pCeleb != r) {
                if (M[r][pCeleb] == 0) {
                    return -1;
                }
            }
        }

        return pCeleb;
    }

}