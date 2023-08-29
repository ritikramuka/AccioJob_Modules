import java.util.*;
import static java.lang.Math.ceil;

public class Main {
	static long mod = 1000000007;
	static long NthEvenFibonacci(long n) {
        //Write your code here
		if (n == 1) return 2;
		if (n == 2) return 8;

		long a = NthEvenFibonacci(n - 1) % mod;
		long b = NthEvenFibonacci(n - 2) % mod;

		return (((4 * a) % mod) + b) % mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(NthEvenFibonacci(n));
    }
}