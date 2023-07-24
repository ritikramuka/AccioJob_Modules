import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));
        
    }
}

class Solution {
    static int rowWithMaximumOnes(int arr[][], int n, int m) {
		int maxCntOfOnes = 0;
		int rNum = -1;

		for (int r = 0; r < n; r++) {
			int si = 0;
			int ei = m - 1;

			int foi = -1;

			while (si <= ei) {
				int mid = (si + ei) / 2;

				if (arr[r][mid] == 1) {
					foi = mid;
					ei = mid - 1;
				} else {
					si = mid + 1;
				}
			}

			if (foi != -1) {
				int cnt = m - foi;

				if (maxCntOfOnes < cnt) {
					maxCntOfOnes = cnt;
					rNum = r;
				}
			}
		}
			
		return rNum;
    }
}