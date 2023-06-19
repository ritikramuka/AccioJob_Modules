import java.io.*;
import java.util.*;

public class Main {
	// TC: O(log N), SC: O(1)
    public static int searchInsert(int[] a, int b) {
        // Write code here
		int si = 0;
		int ei = a.length - 1;

		int pans = a.length;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (a[mid] == b) {
				return mid;
			} else if (a[mid] > b) {
				pans = mid;
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
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