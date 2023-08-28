import java.util.*;

class Main {
	// faith: returns x^n
	public static long xPowerN(int x, int n) {
		// base case
		if (n == 0) {
			return 1;
		}

		// returns x^(n - 1)
		long a = xPowerN(x, n - 1);

		return a * x;
	}
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int x = sc.nextInt();
    	int n = sc.nextInt();
		System.out.println(xPowerN(x, n));
	}
}