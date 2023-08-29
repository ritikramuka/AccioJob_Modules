import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(recforMin(arr, 0));
    }

	// Faith: returns min value present in the array from arr[idx].....arr[arr.length - 1]
	public static int recforMin(int[] arr, int idx) {
		// Base Case
		if (idx == arr.length) {
			return Integer.MAX_VALUE;
		}
		
		// returns min value present in the array from arr[idx + 1].....arr[arr.length - 1]
		int a = recforMin(arr, idx + 1);

		return Math.min(arr[idx], a);
    }
}