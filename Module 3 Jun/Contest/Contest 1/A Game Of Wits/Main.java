/**
 * https://course.acciojob.com/idle?question=de770f57-b7c1-424a-a6e6-075d8fe0567a
 */
import java.util.*;

class Solution {
	// TC: O(N), SC: O(1)
    public int helpBob(int n) {
        //Write code here
		int prev = 1;
		int secondPrev = 1;

		if (n == 1 || n == 2) {
			return 1;
		}

		int oddFiboSeen = 2;

		while (true) {
			int currFiboNum = prev + secondPrev;
			if (currFiboNum % 2 != 0) {
				oddFiboSeen++;
			}

			if (oddFiboSeen == n) {
				return currFiboNum;
			}

			secondPrev = prev;
			prev = currFiboNum;
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.helpBob(n);
        System.out.println(result);
        sc.close();
    }
}