import java.util.*;

public class Main {

    public static int BinarySearchIterative(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int BinarySearchRecursive(int key, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return BinarySearchRecursive(key, arr, low, mid - 1);
        } else {
            return BinarySearchRecursive(key, arr, mid + 1, high);
        }
    }

    public static int findIndex(int key, int[] arr) {
        // Write code here
        // int idx = BinarySearchIterative(key, arr);
        int idx = BinarySearchRecursive(key, arr, 0, arr.length - 1);
        return idx;
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