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

    Pair(int r, int c) {
      row = r;
      col = c;
    }
  }

  public static int orangesRotting(int[][] grid) {
    //your code
    int n = grid.length;
    int m = grid[0].length;

    // stores origin of all the rotten orange at time 0
    Queue<Pair> que = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          // rotten orange found
          que.add(new Pair(i, j));
        }
      }
    }

    int time = 0;
    while (que.size() > 0) {
      int size = que.size();

      while (size > 0) {
        Pair rnode = que.remove();

        int cr = rnode.row;
        int cc = rnode.col;

        if (cr - 1 >= 0 && grid[cr - 1][cc] == 1) {
          grid[cr - 1][cc] = 2;
          que.add(new Pair(cr - 1, cc));
        }

        if (cr + 1 < n && grid[cr + 1][cc] == 1) {
          grid[cr + 1][cc] = 2;
          que.add(new Pair(cr + 1, cc));
        }

        if (cc - 1 >= 0 && grid[cr][cc - 1] == 1) {
          grid[cr][cc - 1] = 2;
          que.add(new Pair(cr, cc - 1));
        }

        if (cc + 1 < m && grid[cr][cc + 1] == 1) {
          grid[cr][cc + 1] = 2;
          que.add(new Pair(cr, cc + 1));
        }

        size--;
      }

      time++;
    }

    // check is any fresh orange left
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }

    if (time == 0) {
      return 0;
    }

    return time - 1;
  }
}
