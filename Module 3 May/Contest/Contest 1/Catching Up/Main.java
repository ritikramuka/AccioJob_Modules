import java.util.*;

class Solution {

	int GCD(int n1, int n2) {
		if (n2 != 0) {
			return GCD(n2, n1 % n2);
		} else {
			return n1;
		}
	}
	
    int catchingUp(int a, int b) {
	    // write code here
		return GCD(a, b);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.catchingUp(a,b));

    }
}