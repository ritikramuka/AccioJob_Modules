/**
 * https://course.acciojob.com/idle?question=640e3336-efe0-470c-9d7a-1bb87e588b2e
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] lifetime = new int[k];
        for (int i = 0; i < k; i++)
            lifetime[i] = sc.nextInt();
        sc.close();
        System.out.println(maxRunTime(n, lifetime));
    }

    /*
     * n = 5;
     * lifeTime[] = {5, 10, 20, 6, 7}
     * 
     * shift = 10;
     * 
     * 1st machine -> stop after 5 hours
     * 2nd machine -> stop after 10 hours
     * 3rd machine -> stop after 10 hours
     * 4th machine -> stop after 6 hours
     * 5th machine -> stop after 7 hours
     * 
     * si + ei / 2 - si / 2
     * si / 2 + ei / 2
     * (si + ei) / 2
     **/

    public static boolean isPossible(int n, long shift, int[] lifeTime) {
        long work = shift * n;
        long currWork = 0;
        for (int time : lifeTime) {
            if (time <= shift) {
                currWork += time;
            } else {
                currWork += shift;
            }
        }

        return currWork >= work;
    }

    // TC: O(N*logN), SC: O(1)
    public static long maxRunTime(int n, int[] lifeTime) {
        // your code here
        long si = 0;
        long ei = 0;
        for (int time : lifeTime) {
            ei += time;
        }
        ei = ei / n;

        long pans = -1;
        while (si <= ei) {
            long mid = si + (ei - si) / 2;
            if (isPossible(n, mid, lifeTime) == true) {
                pans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return pans;
    }
}