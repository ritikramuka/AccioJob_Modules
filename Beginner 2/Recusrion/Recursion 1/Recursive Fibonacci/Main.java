import java.util.*;
import static java.lang.Math.ceil;

public class Main {
	// Faith: returns nth fibo
	public static int fib(int n){
        // Base Case
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		// returns (n-1)th fibo
		int a = fib(n - 1);

		// returns (n-2)th fibo
		int b = fib(n - 2);

		int nthFibo = a + b;
		return nthFibo;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}