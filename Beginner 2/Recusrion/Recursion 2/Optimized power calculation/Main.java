import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int X,N;
        X = sc.nextInt();        
        N = sc.nextInt();

        System.out.println(power(X,N));		
    }

	// Faith: returns x^n
	public static long power(int x, int n)
    {
		// Base Case
		if (n == 0) {
			return 1;
		}
		
		// returns x^(n / 2);
		long a = power(x, n / 2);

		if (n % 2 == 0) {
			return a * a;
		} else {
			return a * a * x;
		}
    }
}
