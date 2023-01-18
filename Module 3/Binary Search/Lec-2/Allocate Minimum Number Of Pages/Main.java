import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public boolean possibleToPlace(int[] A, int B, long cap) {
        long stud = 1;
        long currPagesCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (currPagesCount + A[i] <= cap) {
                currPagesCount += A[i];
            } else {
                currPagesCount = A[i];
                stud++;
            }
        }

        return stud <= B;
    }

    public long MinimumPages(int[] A, int B) {
        // Write your code here
		if (A.length < B) {
			return -1;
		}

        // first define sample space for capacity of max pages to a student
        // lo -> max element in the array, as if we divide all books to n students then
        // max pages in a permuation to a student will me max element of the array
        // hi -> sum of all elements in the array, as if we divide all books to a single
        // then, maximum pages will be sum of the pages
        long lo = A[0];
        long hi = A[0];
        for (int i = 1; i < A.length; i++) {
            lo = Math.max(lo, A[i]);
            hi += A[i];
        }

        long potentialAns = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            // if I'm able to distribute these books to B or less than B students then,
            // these books are distributable inside this capacity, hence this is my
            // potential ans
            if (possibleToPlace(A, B, mid) == true) {
                potentialAns = mid;

                // move towards smaller capacity to get new answers
                hi = mid - 1;
            } else {

                // move towards as capacity was less, so increase capacity
                lo = mid + 1;
            }
        }

        return potentialAns;
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