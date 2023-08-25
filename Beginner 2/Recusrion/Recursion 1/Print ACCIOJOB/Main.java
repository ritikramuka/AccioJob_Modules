import java.io.*;
import java.util.*;

class Main
{
	// public static void main(String args[])throws IOException
 //    {
 //        Scanner sc = new Scanner(System.in);
        
 //        int n=sc.nextInt();

 //        solve(0, n);

 //    }

	// public static void solve(int i, int n)
 //    {
	//     // Basecase
	// 	if (i == n) {
	// 		return;
	// 	}
		
	// 	System.out.println("ACCIOJOB");

	// 	// recursive call
	// 	solve(i + 1, n);
 //    }
	
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();

        solve(n);

    }

	public static void solve(int n)
    {
        // Base Case
		if (n == 0) {
			return;
		}

		System.out.println("ACCIOJOB");

		solve(n - 1);
    }
}