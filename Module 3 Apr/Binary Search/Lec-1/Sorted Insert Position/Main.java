import java.io.*;
import java.util.*;

public class Main {

	// TC: O(log N), SC: O(1)
    public static int searchInsert(int[] a, int b) {
        // define search range
		int si = 0;
		int ei = a.length - 1;

		int ceil = a.length;

		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (a[mid] == b) {
				return mid;
			} else if (a[mid] > b) {
				// move towards left, but as we are eliminating bigger values so update potential ceil index
				ceil = mid;
				ei = mid - 1;
			} else {
				// move right, and as we are eliminating smaller people so won't affect our ceil value
				si = mid + 1;
			}
		}

		return ceil;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}