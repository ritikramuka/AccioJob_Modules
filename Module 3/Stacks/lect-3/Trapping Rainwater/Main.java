import java.io.*;
import java.util.*;

class Solution {
    // Approach 1
    // public void TappingWater(int[] arr, int n) {
    // // Write code here and print output

    // int[] lmax = new int[n];
    // lmax[0] = arr[0];
    // for (int i = 1; i < n; i++) {
    // lmax[i] = Math.max(lmax[i - 1], arr[i]);
    // }

    // int[] rmax = new int[n];
    // rmax[n - 1] = arr[n - 1];
    // for (int i = n - 2; i >= 0; i--) {
    // rmax[i] = Math.max(rmax[i + 1], arr[i]);
    // }

    // int totalWater = 0;

    // for (int i = 0; i < n; i++) {
    // int maxHeight = Math.min(lmax[i], rmax[i]);
    // int waterHeight = maxHeight - arr[i];
    // int currUnitOfWater = waterHeight * 1;
    // totalWater += currUnitOfWater;
    // }

    // System.out.println(totalWater);
    // }

    // Approach 2
    // public void TappingWater(int[] arr, int n) {
    // // Write code here and print output
    // Stack<Integer> st = new Stack<>();
    // int totalWater = 0;

    // for (int i = 0; i < n; i++) {
    // while (st.size() > 0 && arr[i] > arr[st.peek()]) {
    // int r = i;
    // int cVal = arr[st.pop()];

    // if (st.size() == 0) {
    // // don't have next greater element on left
    // break;
    // }

    // int l = st.peek();

    // int width = r - l - 1;
    // int totalHeight = Math.min(arr[l], arr[r]);
    // int waterHeight = totalHeight - cVal;

    // totalWater += (width * waterHeight);
    // }
    // st.push(i);
    // }

    // System.out.println(totalWater);
    // }

    // Approach 3
    // TC: O(N), SC: O(1)
    public void TappingWater(int[] arr, int n) {
        // Write code here and print output
        int LB = arr[0];
        int RB = arr[n - 1];

        int l = 1;
        int r = n - 2;

        int totalWater = 0;

        while (l <= r) {
            if (LB <= RB) {
                if (LB < arr[l]) {
                    LB = arr[l];
                } else {
                    totalWater += LB - arr[l];
                }
                l++;
            } else {
                if (RB < arr[r]) {
                    RB = arr[r];
                } else {
                    totalWater += RB - arr[r];
                }
                r--;
            }
        }

        System.out.println(totalWater);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Solution Obj = new Solution();
        Obj.TappingWater(arr, n);

        sc.close();

    }
}