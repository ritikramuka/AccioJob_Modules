import java.util.*;

public class Main {
	// // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
	    // step 1: define region of search
		int si = 0;
		int ei = arr.length - 1;

		// do all the steps till range is defined
		while (si <= ei) {
			// step 2: get mid
			int mid = (si + ei) / 2;
			
			// step 3: check is arr[mid] == key
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				// as array is sorted in inc order, all right value to mid and arr[mid] are greater than key, so move left
				ei = mid - 1;
			} else {
				// as array is sorted in inc order, all left value to mid and arr[mid] are smaller than key, so move towards right
				si = mid + 1;
			}
		}

		// not able to find target
		return -1;
    }


	// static int binarySearch(int[] arr, int key, int si, int ei) {
	// 	if (si > ei) {
	// 		return -1;
	// 	}
		
	// 	int mid = (si + ei) / 2;

	// 	if (arr[mid] == key) {
	// 		return mid;
	// 	} else if (arr[mid] > key) {
	// 		// move left
	// 		return binarySearch(arr, key, si, mid - 1);
	// 	} else {
	// 		// move right
	// 		return binarySearch(arr, key, mid + 1, ei);
	// 	}
	// }

	// TC: O(log N), SC: O(log N) -> callstack
    // public static int findIndex(int key, int[] arr) {
	   //  return binarySearch(arr, key, 0, arr.length - 1);
    // }

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