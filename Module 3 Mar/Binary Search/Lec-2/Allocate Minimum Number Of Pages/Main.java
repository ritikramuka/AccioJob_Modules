import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isPossible(int[] A, long cap, int B) {
        int studNum = 1;
        int pagesToCurrStud = 0;

        for (int page : A) {
            if (pagesToCurrStud + page <= cap) {
                pagesToCurrStud += page;
            } else {
                studNum++;
                pagesToCurrStud = page;
            }
        }

        return studNum <= B;
    }

    // TC: O(N*logN), SC: O(1)
    public long MinimumPages(int[] A, int B) {
        // Write your code here
        if (A.length < B) {
            return -1;
        }

        // first define sample space for capacity of maximum pages to a student
        // si -> max of all pages, as when we divide books to N students
        // ei -> sum of all pages, as when we divide books to 1 student

        long si = 0;
        long ei = 0;

        for (int page : A) {
            si = Math.max(page, si);
            ei += page;
        }

        long pans = -1;
        while (si <= ei) {
            long mid = (si + ei) / 2;

            if (isPossible(A, mid, B) == true) {
                pans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B));
    }
}