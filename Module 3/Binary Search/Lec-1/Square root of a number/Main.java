import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        // your code here
        if (A == 0) {
            System.out.println(0);
            return;
        }

        long lo = 1;
        long hi = (long)A;

        long pSqrt = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid == (long)A) {
                System.out.println(mid);
                return;
            } else if (mid * mid > (long)A) {
                hi = mid - 1;
            } else {
                pSqrt = mid;
                lo = mid + 1;
            }
        }

        System.out.println(pSqrt);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        sqrt(A);

    }
}