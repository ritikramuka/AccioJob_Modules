import java.util.*;

class Solution {

	public static int[][] tarnspose(int[][] mat) {
		int[][] trans = new int[mat[0].length][mat.length];
		
		for (int i = 0; i < trans.length; i++) {
			for (int j = 0; j < trans[0].length; j++) {
				trans[i][j] = mat[j][i];
			}
		}

		return trans;
	}

	// TC: O(N * M), SC: O(N * M)
    public static void sortCol(int[][] mat, int N, int M){
        // Write your code and print here

		int[][] trans = tarnspose(mat);

		for (int i = 0; i < M; i++) {
			Arrays.sort(trans[i]);
		}

		mat = tarnspose(trans);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
    }
}

public class Main {
        public static void main(String[] args) throws Throwable {
         Scanner sc=new Scanner(System.in); 
          int n=sc.nextInt();
          int m=sc.nextInt();
          int[][] mat =new int[n][m]; 
          for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                mat[i][j] = sc.nextInt();
            }
          } 
          Solution.sortCol(mat, n, m);
      
        }
}