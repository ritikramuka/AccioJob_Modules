import java.util.*;

public class Main {
	// TC: O(log N), SC: O(1)
	public static int findFirstOcc (int[] arr, int n, int key) {
		int si = 0;
		int ei = n - 1;

		int firstOcc = -1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (arr[mid] == key) {
				firstOcc = mid;
				ei = mid - 1;
			} else if (arr[mid] > key) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return firstOcc;
	}

	// TC: O(log N), SC: O(1)
	public static int findLastOcc (int[] arr, int n, int key) {
		int si = 0;
		int ei = n - 1;

		int lastOcc = -1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (arr[mid] == key) {
				lastOcc = mid;
				si = mid + 1;
			} else if (arr[mid] > key) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return lastOcc;
	}
	
    public static void findPosition(int a[], int n,int k) {
        // Write code here
		int fo = findFirstOcc(a, n, k);
		int lo = findLastOcc(a, n, k);

		System.out.println(fo + " " + lo);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}