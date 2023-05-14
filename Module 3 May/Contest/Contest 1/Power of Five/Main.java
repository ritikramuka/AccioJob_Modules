import java.util.*;

class Solution {
    public String powOf5(int n) {
        // write code here
		if (n == 1) {
			return "Yes";
		}
		
		if (n % 5 == 0) {
			return powOf5(n / 5);
		} else {
			return "No";
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.print(Obj.powOf5(n));
    }
}
