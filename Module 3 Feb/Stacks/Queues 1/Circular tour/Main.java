import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int p[] = new int[n];
    int d[] = new int[n];

    for (int i = 0; i < n; i++) {
      p[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      d[i] = sc.nextInt();
    }

    System.out.println(new Solution().tour(p, d));
  }
}

class Solution {

  int tour(int petrol[], int distance[]) {
    int total_petrol = 0;
    for (int p : petrol) {
      total_petrol += p;
    }

    int total_dist = 0;
    for (int d : distance) {
      total_dist += d;
    }

    if (total_dist > total_petrol) {
      return -1;
    }

    int start = 0;
    int remaining_fuel = 0;
    for (int i = 0; i < distance.length; i++) {
      remaining_fuel += petrol[i];

      if (remaining_fuel >= distance[i]) {
        remaining_fuel -= distance[i];
      } else {
        start = i + 1;
        remaining_fuel = 0;
      }
    }

    return start;
  }
}
