import java.io.*;
import java.util.*;

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

    Pair(int myHealth, boolean isCaptain) {
      this.myHealth = myHealth;
      this.isCaptain = isCaptain;
    }
  }

  public static int minAttacksNeeded(int[] health, int k) {
    int n = health.length;

    Queue<Pair> que = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      if (i == k) {
        que.add(new Pair(health[i], true));
      } else {
        que.add(new Pair(health[i], false));
      }
    }

    int attacks = 0;
    while (true) {
      Pair person = que.remove();
      attacks += 1;
      person.myHealth -= 1;
      if (person.myHealth <= 0) {
        if (person.isCaptain == true) {
          return attacks;
        }
      } else {
		que.add(person);  
	  }
    }
  }
}
