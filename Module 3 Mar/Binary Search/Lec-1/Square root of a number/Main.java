import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    // TC: O(log A), SC: O(1)
    public static void sqrt(int A) {
        // your code here
        long si = 1;
        long ei = (long) A;

        long pans = -1;

        while (si <= ei) {
            long mid = (si + ei) / 2;

            if (mid * mid == A) {
                System.out.println(mid);
                return;
            } else if (mid * mid < A) {
                pans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        System.out.println(pans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        sqrt(A);

    }
}