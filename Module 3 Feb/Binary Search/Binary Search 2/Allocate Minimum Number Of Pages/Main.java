import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // {12, 34, 67, 10, 100} -> cap: 100
    // student 1: 46
    // student 2: 77
    // student 3: 100
    public boolean isPossilbeToDistribute(int[] A, int B, long cap) {
        int numberOfStudents = 1;
        long pagesToThisStudent = 0;

        for (int pages : A) {
            if (pagesToThisStudent + pages <= cap) {
                pagesToThisStudent += pages;
            } else {
                numberOfStudents += 1;
                pagesToThisStudent = pages;
            }
        }

        return numberOfStudents <= B ? true : false;
    }

    // TC: O(N * log N)
    public long MinimumPages(int[] A, int B) {
        // Write your code here
        if (A.length < B) {
            return -1;
        }

        // if I give to 1 student
        long maxPages = 0;

        // if I give to N students
        long minPages = Long.MIN_VALUE;

        for (int book : A) {
            maxPages += book;
            minPages = Math.max(minPages, book);
        }

        long lo = minPages;
        long hi = maxPages;

        long ans = 0;
        while (lo <= hi) {
            long cap = (lo + hi) / 2;

            if (isPossilbeToDistribute(A, B, cap) == true) {
                ans = cap;
                hi = cap - 1;
            } else {
                lo = cap + 1;
            }
        }

        return ans;
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