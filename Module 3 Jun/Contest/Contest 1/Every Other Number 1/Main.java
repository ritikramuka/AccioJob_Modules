/**
 * https://course.acciojob.com/idle?question=5caea0c3-302f-46f9-8c6f-404b7da9b517
 */

import java.util.*;

class Solution {
    public static int sum_odd(int n) {
	    //Write your code 
		if (n == 0) {
			return 0;
		}

		if (n % 2 == 0) {
			return 0 + sum_odd(n - 1);
		} else {
			return n + sum_odd(n - 1);
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.sum_odd(N));

    }
}