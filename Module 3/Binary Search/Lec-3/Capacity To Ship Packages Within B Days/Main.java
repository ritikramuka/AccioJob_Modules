import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static boolean isPossible(int[] weights, long maxCap, int maxDays) {
        // start loading for day 1
        long numberOfDays = 1;
        // currently ship empty
        long currCapacityOnShip = 0;
        for (int weight : weights) {
            // try adding this weight to curr day
            if (currCapacityOnShip + weight <= maxCap) {
                currCapacityOnShip += weight;
            }
            // if not able to add to curr day, so depeart ship and start this from a new day
            else {
                numberOfDays++;
                currCapacityOnShip = weight;
            }
        }

        return numberOfDays <= maxDays;
    }

    // TC: O(N*logN)
    public static long solve(int[] A, int B) {
        // Write your code here

        // minimum capacity of ship is when good is taken indivually so, max capacity at
        // that moment is max weight of good available
        // minimum capacity of ship is when good when all goods are taken in same day,
        // is sum of weight of all the goods
        long lo = 0;
        long hi = 0;
        for (int weight : A) {
            lo = Math.max(lo, weight);
            hi += weight;
        }

        long potetialAns = -1;
        while (lo <= hi) {
            // get maxCapacity if the ship
            long mid = (lo + hi) / 2;

            // if it is possible to trasport goods with this maxCapacity to port 1 to port 2
            // within B days, so this is your potential ans and now try for smaller max
            // capacity
            if (isPossible(A, mid, B) == true) {
                potetialAns = mid;
                hi = mid - 1;
            }
            // maxCapacity for ship is less to transport goods from port 1 to port 2 within
            // B days, so increase maxCapacity hence move right
            else {
                lo = mid + 1;
            }
        }

        return potetialAns;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}