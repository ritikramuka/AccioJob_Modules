import java.util.*;

public class Main {
    static int firstOcc(int[] arr, int n, int tar) {
        int si = 0;
        int ei = n - 1;

        int pans = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == tar) {
                pans = mid;
                // try to find target in left
                ei = mid - 1;
            } else if (arr[mid] > tar) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pans;
    }

    static int lastOcc(int[] arr, int n, int tar) {
        int si = 0;
        int ei = n - 1;

        int pans = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == tar) {
                pans = mid;
                // try to find target in right
                si = mid + 1;
            } else if (arr[mid] > tar) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pans;
    }

    // TC: O(log N), SC: O(1)
    public static void findPosition(int a[], int n, int k) {
        // Write code here
        int fo = firstOcc(a, n, k);
        int lo = lastOcc(a, n, k);

        System.out.println(fo + " " + lo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        findPosition(array, n, k);
    }
}