import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Solution{ 
	static class Pair {
		int r;
		int c;

		Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// TC: O(N*M), SC: O(N*M)
	public static int orangesRotting(int[][] grid) {
		//your code
		int n = grid.length;
		int m = grid[0].length;

		Queue<Pair> que = new ArrayDeque<>();

		// add all the src in the que
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					que.add(new Pair(i, j));
				}
			}
		}

		int level = 0;

		while (que.size() > 0) {
			// size of the current level
			int size = que.size();

			while (size-->0) {
				Pair rpair = que.remove();

				// rotten someone on right
				if (rpair.c + 1 < m && grid[rpair.r][rpair.c + 1] == 1) {
					grid[rpair.r][rpair.c + 1] = 2;
					que.add(new Pair(rpair.r, rpair.c + 1));
				}

				// rotten somone on bottom
				if (rpair.r + 1 < n && grid[rpair.r + 1][rpair.c] == 1) {
					grid[rpair.r + 1][rpair.c] = 2;
					que.add(new Pair(rpair.r + 1, rpair.c));
				}

				// rotten somone on left
				if (rpair.c - 1 >= 0 && grid[rpair.r][rpair.c - 1] == 1) {
					grid[rpair.r][rpair.c - 1] = 2;
					que.add(new Pair(rpair.r, rpair.c - 1));
				}

				// rotten somone on up
				if (rpair.r - 1 >= 0 && grid[rpair.r - 1][rpair.c] == 1) {
					grid[rpair.r - 1][rpair.c] = 2;
					que.add(new Pair(rpair.r - 1, rpair.c));
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

		if (level == 0) {
			return 0;
		}

		return level - 1;
	}
}
