import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,x;
        n = sc.nextInt();
        x = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        findX(arr1, n, x);
    }



    static void findX(int arr[], int n, int x)
    {
	    // Base Case
		if (n == 0) {
			return;
		}

		findX(arr, n - 1, x);

		if (arr[n - 1] == x) {
			System.out.print((n - 1) + " ");
		}
    }
}
