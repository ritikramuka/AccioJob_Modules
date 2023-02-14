import java.util.*;

public class Main {

  public static int findFirstOcc(int[] a, int n, int k) {
    int lo = 0;
    int hi = n - 1;

    int firstOccOfK = -1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (a[mid] == k) {
        firstOccOfK = mid;
        hi = mid - 1;
      } else if (a[mid] > k) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return firstOccOfK;
  }

  public static int findLastOcc(int[] a, int n, int k) {
    int lo = 0;
    int hi = n - 1;

    int lastOccOfK = -1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (a[mid] == k) {
        lastOccOfK = mid;
        lo = mid + 1;
      } else if (a[mid] > k) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return lastOccOfK;
  }

  // TC: O(log N)
  public static void findPosition(int a[], int n, int k) {
    // Write code here
    int firstOcc = findFirstOcc(a, n, k);
    int lastOcc = findLastOcc(a, n, k);

    System.out.println(firstOcc + " " + lastOcc);
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
