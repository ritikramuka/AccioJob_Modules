import java.util.*;
import java.io.*;

class Solution {

    // TC: O(N), SC: O(1)
    static boolean possibleTo(int[] A, int B, long cap) {
        int dayNumber = 1;
        long weightOntheShip = 0;

        for (int weight : A) {
            if (weightOntheShip + weight <= cap) {
                weightOntheShip += weight;
            } else {
                dayNumber += 1;
                weightOntheShip = weight;
            }
        }

        return dayNumber <= B;
    }

    // TC: O(N * log N), SC: O(1)
    public static long solve(int[] A, int B) {
        // Write your code here

        // when we wan't to ship each package on different day, then cap of the ship
        // should maximum weight of a package
        long minWeightOfTheShip = 0;

        // when we wan't to ship all the packages in a single day, then cap of the ship
        // should sum of all the packages
        long maxWeightOfTheShip = 0;

        for (int weight : A) {
            minWeightOfTheShip = Math.max(minWeightOfTheShip, weight);
            maxWeightOfTheShip += weight;
        }

        long lo = minWeightOfTheShip;
        long hi = maxWeightOfTheShip;
        long potentialAns = -1;

        while (lo <= hi) {
            long cap = (lo + hi) / 2;

            if (possibleTo(A, B, cap) == true) {
                potentialAns = cap;
                // decrease cap so move left
                hi = cap - 1;
            } else {
                // not possible so increase cap, hence move right
                lo = cap + 1;
            }
        }

        return potentialAns;
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