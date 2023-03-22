import java.util.*;

class Solution {
    public int findPeak(int arr[], int n) {
        // Write your code here
        int si = 0;
        int ei = n - 1;

        if (n == 1) {
            return 0;
        }

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mid == n - 1) {
                // left part is inc, then mid is peak
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    ei = mid - 1;
                }
            } else if (mid == 0) {
                // right part is dec, then mid is peak
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    si = mid + 1;
                }
            } else {
                // check is mid peak ele
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] < arr[mid]) {
                    // left side is inc,
                    // peak will be in right
                    si = mid + 1;
                } else {
                    // left part is dec,
                    // peak will be in left
                    ei = mid - 1;
                }
            }
        }

        return -1;

    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] A = new int[n];
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }
                Solution ob = new Solution();
                int ans = ob.findPeak(A, n);
                if (ans == 0) {
                    if (A[ans] > A[ans + 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else if (ans == n - 1) {
                    if (A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else {
                    if (A[ans] > A[ans + 1] && A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                t--;
            }
        }
    }
}