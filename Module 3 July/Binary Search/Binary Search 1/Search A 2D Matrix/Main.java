import java.util.*;

public class Main {
	// TC: O(log N * M), SC: O(1)
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        int n = mat.length;
		int m = mat[0].length;

		int si = 0;
		int ei = n * m - 1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			int r = mid / m;
			int c = mid % m;

			if (mat[r][c] == x) {
				return true;
			} else if (mat[r][c] > x) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return false;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}