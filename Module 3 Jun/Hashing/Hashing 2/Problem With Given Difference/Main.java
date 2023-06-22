import java.io.*;
import java.util.*;

class Solution {
	// TC: O(N), SC: O(N)
    public int givenDifference(int []A, int n, int B) {
        // write your code 
		HashSet<Integer> set = new HashSet<>();
		for (int ele : A) {
			set.add(ele);
		}

		for (int x : A) {
			int y = x + B;
			if (set.contains(y) == true) {
				return 1;
			} 

			y = x - B;
			if (set.contains(y) == true) {
				return 1;
			}
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
