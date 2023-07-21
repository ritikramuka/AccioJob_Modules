import java.util.*;

public class Main {
	// TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        //Write code here

		// step 1: define search region
		int si = 0;
		int ei = arr.length - 1;

		// step 2: start searching, divide into two parts take one, eliminate other
		while (si <= ei) {
			// get mid point
			int mid = (si + ei) / 2;

			if (arr[mid] == key) {
				// found the key, hence return its index
				return mid;
			} else if (arr[mid] > key) {
				// as array is sorted in inc order, hence all the value to right of mid will be also greater than key, hence eliminate right region of mid
				ei = mid - 1;
			} else {
				// as array is sorted in inc order, hence all the value to left of mid will be also smaller than key, hence eliminate left region of mid
				si = mid + 1;
			}
		}

		// not able to find key in array
		return -1;
    }

	// public static int BinarySearch(int[] arr, int key, int si, int ei) {
	// 	// base case
	// 	if (si > ei) {
	// 		return -1;
	// 	}
		
	// 	int mid = (si + ei) / 2;
	// 	if (arr[mid] == key) {
	// 		return mid;
	// 	} else if (arr[mid] > key) {
	// 		return BinarySearch(arr, key, si, mid - 1);
	// 	} else {
	// 		return BinarySearch(arr, key, mid + 1, ei);
	// 	}
	// }

	// // TC: O(log N), SC: O(log N)
	// public static int findIndex(int key, int[] arr) {
 //        //Write code here
	// 	return BinarySearch(arr, key, 0, arr.length - 1);
 //    }

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