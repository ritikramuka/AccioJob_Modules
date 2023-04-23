import java.util.*;

public class Main {
	// TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        // step 1: define a search range
		int si = 0;
		int ei = arr.length - 1;

		// step 2: try finding till the search range is valid
		while (si <= ei) {

			// step 3: get mid point
			int mid = (si + ei) / 2;

			// step 4: check if arr[mid] equal to the key, else try eliminating half of the range
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				// eliminate right region and move left
				ei = mid - 1;
			} else {
				// eliminate left region and move right
				si = mid + 1;
			}
		}

		// key not present in the array
		return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}