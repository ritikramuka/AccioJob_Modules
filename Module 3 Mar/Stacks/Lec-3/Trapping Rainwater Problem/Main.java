import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    // public void TappingWater(int[] arr, int n) {
    // //Write code here and print output

    // // step 1: get lmax array -> TC: O(N), SC: O(N)
    // int lb = -1;
    // int[] lmax = new int[n];
    // for (int i = 0; i < n; i++) {
    // if (lb > arr[i]) {
    // // I can be lmax of curr building
    // lmax[i] = lb;
    // } else {
    // // curr building is greater than lmax, so it's lmax = -1, and overall lmax
    // will inc to height of curr building
    // lmax[i] = -1;
    // lb = arr[i];
    // }
    // }

    // // step 2: get rmax array -> TC: O(N), SC:O(N)
    // int rb = -1;
    // int[] rmax = new int[n];
    // for (int i = n - 1; i >= 0; i--) {
    // if (arr[i] < rb) {
    // rmax[i] = rb;
    // } else {
    // rmax[i] = -1;
    // rb = arr[i];
    // }
    // }

    // // step 3: calculate total water
    // int totalWater = 0;
    // for (int i = 0; i < n; i++) {
    // int heightOfBuilding = arr[i];
    // int heightOfWater = Math.min(lmax[i], rmax[i]);
    // if (heightOfWater == -1) {
    // // do nothing
    // } else {
    // int heightOfWaterAbove = heightOfWater - heightOfBuilding;
    // int waterAbove = heightOfWaterAbove * 1;
    // totalWater += waterAbove;
    // }
    // }

    // System.out.println(totalWater);
    // }

    // TC: O(N), SC: O(N)
    // public void TappingWater(int[] arr, int n) {
    // //Write code here and print output

    // // next greater element index
    // Stack<Integer> stack = new Stack<>();
    // int totalWater = 0;
    // for (int i = 0; i < n; i++) {
    // int ele = arr[i];
    // while (stack.size() > 0 && ele >= arr[stack.peek()]) {
    // int rb = ele;
    // int height = arr[stack.pop()];
    // if (stack.size() > 0) {
    // int lb = arr[stack.peek()];
    // int width = i - stack.peek() - 1;
    // int heightOfWaterAbove = Math.min(lb, rb) - height;
    // int waterOfAbove = heightOfWaterAbove * width;
    // totalWater += waterOfAbove;
    // }
    // }

    // stack.push(i);
    // }

    // System.out.println(totalWater);
    // }

    public void TappingWater(int[] arr, int n) {
        // Write code here and print output

        int LB = arr[0];
        int RB = arr[n - 1];

        int l = 1;
        int r = n - 2;

        int totalWater = 0;
        while (l <= r) {
            if (LB <= RB) {
                // left boundry is limiting
                if (arr[l] < LB) {
                    int heightOfWaterAbove = LB - arr[l];
                    totalWater += heightOfWaterAbove * 1;
                } else {
                    LB = arr[l];
                }
                l++;
            } else {
                // right boundry is limiting
                if (arr[r] < RB) {
                    int heightOfWaterAbove = RB - arr[r];
                    totalWater += heightOfWaterAbove * 1;
                } else {
                    RB = arr[r];
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