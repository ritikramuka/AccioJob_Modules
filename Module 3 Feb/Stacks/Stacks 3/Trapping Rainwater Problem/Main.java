import java.io.*;
import java.util.*;

class Solution {

  // Approch 1: TC: O(N), SC: O(N)
  //   public void TappingWater(int[] arr, int n) {
  //     //Write code here and print output

  //     // step 1: get lmax array
  //     int maxHeight = 0;
  //     int[] lmax = new int[n];
  //     for (int i = 0; i < n; i++) {
  //       if (arr[i] <= maxHeight) {
  //         // is maxHeight useful to me
  //         lmax[i] = maxHeight;
  //       } else {
  //         // maxHeight not useful to me
  //         maxHeight = arr[i];
  //         lmax[i] = arr[i];
  //       }
  //     }

  //     // step 2: get rmax array
  //     maxHeight = 0;
  //     int[] rmax = new int[n];
  //     for (int i = n - 1; i >= 0; i--) {
  //       if (arr[i] <= maxHeight) {
  //         // is maxHeight useful to me
  //         rmax[i] = maxHeight;
  //       } else {
  //         // maxHeight not useful to me
  //         maxHeight = arr[i];
  //         rmax[i] = arr[i];
  //       }
  //     }

  //     // step 3: get water above each building, and add them
  //     int totalWaterStored = 0;
  //     for (int i = 0; i < n; i++) {
  //       int heightTillWaterCanGo = Math.min(lmax[i], rmax[i]);

  //       // actual height of water is maxHeightWaterCanGo - Buildingheight
  //       int height = heightTillWaterCanGo - arr[i];

  //       // unit of water is height * width (i.e. 1 for this ques)
  //       int waterStoredAboveMe = height * 1;

  //       totalWaterStored += waterStoredAboveMe;
  //     }

  //     System.out.println(totalWaterStored);
  //   }
  // }

  // Approach 2: TC: O(N), SC: O(N)
  //   public void TappingWater(int[] arr, int n) {
  //     //Write code here and print output

  //     Stack<Integer> st = new Stack<>();
  //     int totalWaterStored = 0;

  //     for (int i = 0; i < n; i++) {
  //       int ele = arr[i];

  //       while (st.size() > 0 && ele >= arr[st.peek()]) {
  //         int idx = st.peek();
  //         st.pop();

  //         int rb = ele;
  //         int myHeight = arr[idx];

  //         if (st.size() > 0) {
  //           int lbIdx = st.peek();
  //           int lb = arr[lbIdx];

  //           int width = i - lbIdx - 1;
  //           int height = Math.min(rb, lb) - myHeight;

  //           int water = width * height;
  //           totalWaterStored += water;
  //         }
  //       }

  //       st.push(i);
  //     }

  //     System.out.println(totalWaterStored);
  //   }
  // }

  //  TC: O(N), SC: (1)
  public void TappingWater(int[] arr, int n) {
    //Write code here and print output
    int LB = arr[0];
    int RB = arr[n - 1];

    int l = 1;
    int r = n - 2;

    int totalWaterStored = 0;

    while (l <= r) {
      if (LB <= RB) {
        if (arr[l] < LB) {
          totalWaterStored += (LB - arr[l]) * 1;
        } else {
          LB = arr[l];
        }
        l++;
      } else {
        if (arr[r] < RB) {
          totalWaterStored += (RB - arr[r]) * 1;
        } else {
          RB = arr[r];
        }
        r--;
      }
    }

    System.out.println(totalWaterStored);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

    Solution Obj = new Solution();
    Obj.TappingWater(arr, n);

    sc.close();
  }
}
