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
        // step 1: add everyone to the stack
        Stack<Integer> possibleCelebs = new Stack<>();
        for (int i = 0; i < n; i++) {
            possibleCelebs.push(i);
        }

        while (possibleCelebs.size() >= 2) {
            int p1 = possibleCelebs.pop();
            int p2 = possibleCelebs.pop();

            if (M[p1][p2] == 1) {
                // p1 knows p2, hence p2 can be celeb but p1 cann't be
                possibleCelebs.push(p2);
            } else {
                // p1 doesn't knows p2, hence p2 can't be a celeb, but p1 can be one
                possibleCelebs.push(p1);
            }
        }

        int celeb = possibleCelebs.pop();

        // check row
        for (int c = 0; c < n; c++) {
            // if celeb knows any c hence violatation
            if (M[celeb][c] == 1) {
                return -1;
            }
        }

        // check col
        for (int r = 0; r < n; r++) {
            // if celeb is not known by anyone, hence violation
            if (r != celeb && M[r][celeb] == 0) {
                return -1;
            }
        }

        return celeb;
    }

}