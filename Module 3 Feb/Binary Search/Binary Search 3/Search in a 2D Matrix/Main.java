import java.util.*;

public class Main {
    // TC: O(log(N*M)) SC: O(1)
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        // Write your code here
        int n = mat.length;
        int m = mat[0].length;

        int lo = 0;
        int hi = n - 1;

        int potentialRow = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[mid][m - 1] == x) {
                return true;
            } else if (mat[mid][m - 1] > x) {
                potentialRow = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (potentialRow == -1) {
            return false;
        }

        lo = 0;
        hi = m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[potentialRow][mid] == x) {
                return true;
            } else if (mat[potentialRow][mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if (SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}