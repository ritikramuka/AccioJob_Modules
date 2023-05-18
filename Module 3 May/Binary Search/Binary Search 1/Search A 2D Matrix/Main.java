import java.util.*;

public class Main {
	// TC: O(log N + log M), SC: O(1)
  //   public static boolean SearchA2DMatrix(int[][] mat, int x) {
		// int n = mat.length;
		// int m = mat[0].length;
		
		// int si = 0;
		// int ei = n * m - 1;

		// while (si <= ei) {
		// 	int mid = (si + ei) / 2;

		// 	int r = mid / m;
		// 	int c = mid % m;

		// 	if (mat[r][c] == x) {
		// 		return true;
		// 	} else if (mat[r][c] > x) {
		// 		ei = mid - 1;
		// 	} else {
		// 		si = mid + 1;
		// 	}
		// }

		// return false;
  //   }

	// TC: O(log N + log M), SC: O(1)
	public static boolean SearchA2DMatrix(int[][] mat, int x) {
		int n = mat.length;
		int m = mat[0].length;
		
		// apply binary search in last col
		int si = 0;
		int ei = n - 1;

		int potentialRow = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (mat[mid][m - 1] == x) {
				return true;
			} else if (mat[mid][m - 1] > x) {
				potentialRow = mid;
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		if (potentialRow == -1) {
			return false;
		}

		// apply binary search in potentialRow
		si = 0;
		ei = m - 1;

		while(si <= ei) {
			int mid = (si + ei) / 2;

			if (mat[potentialRow][mid] == x) {
				return true;
			} else if (mat[potentialRow][mid] > x) {
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