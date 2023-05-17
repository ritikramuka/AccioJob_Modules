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
class Solution {   
	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int orangesRotting(int[][] grid) {
		//your code
		int n = grid.length;
		int m = grid[0].length;

		Queue<Pair> que = new ArrayDeque<>();

		// add all src in the que
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

			while (size-->0) {
				Pair rpair = que.remove();

				// can I rotten someone on right
				if (rpair.col + 1 < m && grid[rpair.row][rpair.col + 1] == 1) {
					grid[rpair.row][rpair.col + 1] = 2;
					que.add(new Pair(rpair.row, rpair.col + 1));
				}

				// can I rotten someone on bottom
				if (rpair.row + 1 < n && grid[rpair.row + 1][rpair.col] == 1) {
					grid[rpair.row + 1][rpair.col] = 2;
					que.add(new Pair(rpair.row + 1, rpair.col));
				}

				// can I rotten someone on left
				if (rpair.col - 1 >= 0 && grid[rpair.row][rpair.col - 1] == 1) {
					grid[rpair.row][rpair.col - 1] = 2;
					que.add(new Pair(rpair.row, rpair.col - 1));
				}

				// can I rotten someone on top
				if (rpair.row - 1 >= 0 && grid[rpair.row - 1][rpair.col] == 1) {
					grid[rpair.row - 1][rpair.col] = 2;
					que.add(new Pair(rpair.row - 1, rpair.col));
				}
			}

			level++;
		}

		int time = level - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		if (time < 0) {
			return 0;
		}

		return time;
	}
}
