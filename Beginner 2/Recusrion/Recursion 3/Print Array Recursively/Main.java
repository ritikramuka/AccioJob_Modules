import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintArray(arr, n);
    }

	// Faith: prints array from arr[0].....arr[n - 1]
	public static void PrintArray(int[] arr, int n) {
	    // Base Case
		if (n == 0) {
			return;
		}

		// prints array from arr[0].....arr[n - 2]
		PrintArray(arr, n - 1);

		System.out.print(arr[n - 1] + " ");
    }

}