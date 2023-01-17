import java.util.*;

public class Main {

    static int firstOccOfK(int[] a, int n, int k) {
        int fo = -1;

        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == k) {
                fo = mid;
                hi = mid - 1;
            } else if (a[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return fo;
    }

    static int lastOccOfK(int[] a, int n, int k) {
        int lastOcc = -1;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == k) {
                lastOcc = mid;
                lo = mid + 1;
            } else if (a[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lastOcc;
    }

    public static void findPosition(int a[], int n, int k) {
        // Write code here
        int fo = firstOccOfK(a, n, k);
        int lo = lastOccOfK(a, n, k);

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