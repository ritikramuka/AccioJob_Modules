import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintReverseArray(arr, n);
    }

	// Faith: prints array ele from arr[n - 1]......arr[0]
	public static void PrintReverseArray(int[] arr, int n) {
		// Base Case
		if (n == 0) {
			return;
		}
		
		System.out.print(arr[n - 1] + " ");
		
		// prints array ele from arr[n - 2]......arr[0]
		PrintReverseArray(arr, n - 1);
    }

  }