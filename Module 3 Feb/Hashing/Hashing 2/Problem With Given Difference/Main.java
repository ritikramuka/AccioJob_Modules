import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int[] A, int n, int B) {
        // write your code here
        
        /*
         * pair -> (x, y)
         * x - y = B
         * 
         * case 1:
         * x = ele
         * y = x - B
         * 
         * case 2:
         * y = ele
         * x = B + y
        */

        HashSet<Integer> mySet = new HashSet<>();

        for (int ele : A) {
            // case 1
            int x = ele;
            int y = x - B;
            if (mySet.contains(y) == true) {
                return 1;
            }

            // case 2
            y = ele;
            x = B + y;
            if (mySet.contains(x) == true) {
                return 1;
            }

            // add myself for further reference of x, y
            mySet.add(ele);
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, B;
        n = sc.nextInt();
        int[] mat = new int[n];
        for (int i = 0; i < n; ++i) {
            mat[i] = sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat, n, B));
        System.out.println('\n');
    }
}
