import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []A, int n, int B) {
        // write your code here

		// suppose pair (x, y), x - y = B || y - x = B
		// if you have x
		// then y = x - B || y = x + B

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int x = A[i];

			int y1 = x - B;
			int y2 = x + B;

			if (set.contains(y1) || set.contains(y2)) {
				return 1;
			}

			set.add(x);
		}

		return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
