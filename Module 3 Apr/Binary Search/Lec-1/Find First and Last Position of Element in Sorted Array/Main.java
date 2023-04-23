import java.util.*;

public class Main {
	static int firstOcc (int[] arr, int key) {
		int si = 0;
		int ei = arr.length - 1;

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (arr[mid] == key) {
				pans = mid;

				// but try to find more key on left side, as leftmost occ will be the first occ
				ei = mid - 1;
			} else if (arr[mid] > key) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
	}

	static int lastOcc (int[] arr, int key) {
		int si = 0;
		int ei = arr.length - 1;

		int pans = -1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (arr[mid] == key) {
				pans = mid;

				// but try to find more key on right side, as rightmost occ will be the last occ
				si = mid + 1;
			} else if (arr[mid] > key) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return pans;
	}
	
    public static void findPosition(int a[], int n,int k)
    {
        // Write code here

		int fo = firstOcc(a, k);
		int lo = lastOcc(a, k);

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