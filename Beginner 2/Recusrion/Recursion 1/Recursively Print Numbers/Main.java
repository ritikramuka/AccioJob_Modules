import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
		printtillN(n);
        
    }

	// Faith: print number from 1.....n
	public static void printtillN(int n) {
		// base case
		if (n == 0) return;

		// prints number from 1......(n - 1)
		printtillN(n - 1);

		// your work
		System.out.print(n + " ");
    }
}