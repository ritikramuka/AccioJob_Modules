import java.util.*;

public class Main {
	// TC: O(log N), SC: O(1)
  //   public static int findIndex(int key, int[] arr) {
  //       //Write code here

		// // Step 1: define range of search
		// int si = 0;
		// int ei = arr.length - 1;

		// // Step 2: Start searching till you have a correct range
		// while (si <= ei) {
		// 	// Step 3: get mid point of this range
		// 	int mid = (si + ei) / 2;

		// 	// Step 4: did you found the target
		// 	if (arr[mid] == key) {
		// 		return mid;
		// 	}

		// 	// Step 5: is arr[mid] bigger than target
		// 	else if (arr[mid] > key) {
		// 		// move towards smaller value, hence move left
		// 		ei = mid - 1;
		// 	}

		// 	// Step 6: is arr[mid] smaller than target
		// 	else {
		// 		// move towards bigger value, hence move right
		// 		si = mid + 1;
		// 	}
		// }

		// return -1;
  //   }

	public static int BinarySearchRecursive(int[] arr, int si, int ei, int key) {
		// base case
		if (si > ei) {
			return -1;
		}

		int mid = (si + ei) / 2;

		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return BinarySearchRecursive(arr, si, mid - 1, key);
		} else {
			return BinarySearchRecursive(arr, mid + 1, ei, key);
		}
	}

	// TC: O(log N), SC: O(log N) callstack space
	public static int findIndex(int key, int[] arr) {
        //Write code here
		return BinarySearchRecursive(arr, 0, arr.length - 1, key);
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