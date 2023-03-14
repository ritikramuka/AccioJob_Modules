import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();

        System.out.println(obj.orangesRotting(arr));
    }
}

class Solution {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

	// TC: O(N * M), SC: O(N * M)
    public static int orangesRotting(int[][] grid) {
        // your code
        int n = grid.length;
        int m = grid[0].length;

        // 0 -> empty
        // 1 -> fresh
        // 2 -> Rotten

        Queue<Pair> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Pair(i, j));
                }
            }
        }

        int level = 0;

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rpair = que.remove();

                int r = rpair.row;
                int c = rpair.col;

                // bottom
                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    que.add(new Pair(r + 1, c));
                }

                // up
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    que.add(new Pair(r - 1, c));
                }

                // right
                if (c + 1 < m && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    que.add(new Pair(r, c + 1));
                }

                // left
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    que.add(new Pair(r, c - 1));
                }
            }
            level++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        int time = level - 1;

        return time == -1 ? 0 : time;
    }
}
