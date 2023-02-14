import java.util.Scanner;

public class Main {

  // TC: O(N), SC: O(1)
  public static int BinarySearch(int n, int[] arr, int ele) {
    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (arr[mid] == ele) {
        return mid;
      } else if (arr[mid] > ele) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter a sorted array of length n: ");
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println("Enter Element to be found: ");
    int ele = scn.nextInt();

    int idx = BinarySearch(n, arr, ele);
  }
}
