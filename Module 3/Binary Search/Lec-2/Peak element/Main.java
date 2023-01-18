import java.util.*;

class Solution {
    public int findPeak(int A[], int n) {
        // Write your code here
        if (n == 1) {
            return 0;
        }

        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid == 0) {
                // I'm at first position of array so I don't left element
                if (A[mid] > A[mid + 1]) {
                    // If I'm greater than my right element then right part is decreasing, hence I'm
                    // the peak
                    return mid;
                } else {
                    // if I'm not the peak and as I'm the leftmost person so I don't have left
                    // array, only have right array where peak can be present, so move right
                    lo = mid + 1;
                }
            } else if (mid == A.length - 1) {
                // I'm at the last position of the array, hence don't have a right element
                if (A[mid] > A[mid - 1]) {
                    // If I'm greater than left element, then I'm the peak as left part is
                    // increasing
                    return mid;
                } else {
                    // If I'm not the peak, and I don't have a right array, then peak will be on
                    // left, so move left
                    hi = mid - 1;
                }
            } else {
                // I'm I the peak
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                } else if (A[mid] >= A[mid - 1]) {
                    // left part is sorted, i.e striclty increasing part, so move toward right i.e
                    // unsorted part
                    lo = mid + 1;
                } else {
                    // right part is sorted, i.e. move towards left
                    hi = mid - 1;
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