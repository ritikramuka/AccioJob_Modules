import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        int si = 1;
		int ei = A;

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (mid * mid == A) {
				System.out.println(mid);
				return;
			} else if (mid * mid > A) {
				// move left
				ei = mid - 1;
			} else {
				// move right 
				pans = mid;
				si = mid + 1;
			}
		}

		System.out.println(pans);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}