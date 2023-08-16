import java.util.*;

public class Main {
	// TC: O(N^2), SC: O(1)
    public static int[] SelectionSort(int[] arr) {
        // Write your code here
		int N = arr.length;

		for (int i = 1; i <= N - 1; i++) {
			int minIdx = -1;
			int minEle = Integer.MAX_VALUE;
			for (int j = i - 1; j <= N - 1; j++) {
				if (arr[j] < minEle) {
					minEle = arr[j];
					minIdx = j;
				}
			}

			// swap arr[minIdx], arr[i - 1]
			int temp = arr[minIdx];
			arr[minIdx] = arr[i - 1];
			arr[i - 1] = temp;
		}

		return arr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = SelectionSort(arr);

        for(int a : ans)
            System.out.print(a + " ");
    }
}