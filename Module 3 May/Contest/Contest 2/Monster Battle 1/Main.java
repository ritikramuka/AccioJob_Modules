/**
 * https://course.acciojob.com/idle?question=1d4ce31a-d697-47f2-905e-4acf49d0b1a4
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] health = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(line[i]);
        }
        Solution ob = new Solution();
        System.out.println(ob.minAttacksNeeded(health, k));
    }
}

class Solution {
	static class Pair {
		int myHealth;
		boolean isCaptain;

		Pair (int myHealth, boolean isCaptain) {
			this.myHealth = myHealth;
			this.isCaptain = isCaptain;
		}
	}

    public static int minAttacksNeeded(int[] health, int k) {
	    Queue<Pair>  que = new ArrayDeque<>();

		for (int i = 0; i < health.length; i++) {
			if (i == k) {
				// I'm the captain
				que.add(new Pair(health[i], true));
			} else {
				que.add(new Pair(health[i], false));
			}
		}

		int attack = 0;
		while (true) {
			Pair soilder = que.remove();

			attack++;
			soilder.myHealth -= 1;

			if (soilder.myHealth == 0) {
				// dead
				if (soilder.isCaptain == true) {
					return attack;
				}
			} else {
				que.add(new Pair(soilder.myHealth, soilder.isCaptain));
			}
		}
	}
}