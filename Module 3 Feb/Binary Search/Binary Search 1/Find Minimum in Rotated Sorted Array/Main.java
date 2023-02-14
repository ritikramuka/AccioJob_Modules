import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  static int findMin(int arr[], int lo, int hi) {
    //Write your code here

    if (arr[lo] <= arr[hi]) {
      return arr[lo];
    }

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
        return arr[mid];
      } else if (mid + 1 < arr.length - 1 && arr[mid] > arr[mid + 1]) {
        return arr[mid + 1];
      } else if (arr[lo] <= arr[mid]) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return -1;
  }
}

class Main {

  // Driver Program
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    System.out.println(Solution.findMin(arr, 0, n - 1));
  }
}
