/**
 * https://course.acciojob.com/idle?question=64b8de3a-5299-4183-9357-ac2831991c63
 */

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int m = Integer.parseInt(inputLine[1]);


        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          for(int j=0; j<m; j++){
            grid[i][j]=Integer.parseInt(inputLine1[j]);
          }
        }

        Solution g = new Solution();
        g.divisiblePaths(n, m, grid);
  }
}

class Solution
{
	void solve (int sr, int sc, int er, int ec, int[][] grid, int sum, String path) {
		if (sr > er || sc > ec) {
			return;
		} 

		if (grid[sr][sc] == -1) {
			return;
		}

		if (sr == er && sc == ec) {
			sum += grid[er][ec];
			if (sum % 5 == 0) {
				System.out.println(path);
			}
			return;
		}

		solve (sr, sc + 1, er, ec, grid, sum + grid[sr][sc], path + "h");
		solve (sr + 1, sc + 1, er, ec, grid, sum + grid[sr][sc], path + "d");
		solve (sr + 1, sc, er, ec, grid, sum + grid[sr][sc], path + "v");
	}
	
    void divisiblePaths(int m, int n, int[][] grid){
		//Your code here  
		solve(0, 0, m - 1, n - 1, grid, 0, "");
    }
} 

