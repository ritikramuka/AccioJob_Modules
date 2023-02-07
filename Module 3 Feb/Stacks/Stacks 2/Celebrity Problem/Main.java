import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M[][] = new int[N][N];
    for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) M[i][j] =
      sc.nextInt();
    System.out.println(new Solution().findCelebrity(M, N));
  }
}

class Solution {

  // TC: O(N), SC: O(N)
  int findCelebrity(int M[][], int n) {
    // add everyone to my potential celeb list
    Stack<Integer> possibleCeleb = new Stack<>();
    for (int i = 0; i < n; i++) {
      possibleCeleb.push(i);
    }

    while (possibleCeleb.size() > 1) {
      int person1 = possibleCeleb.pop();
      int person2 = possibleCeleb.pop();

      if (M[person1][person2] == 1) {
        // if p1 knows p2, then p2 is possible celeb
        possibleCeleb.push(person2);
      } else {
        // p1 doesn't knows p2, hence p2 is not a celeb, so p1 is possible celeb
        possibleCeleb.push(person1);
      }
    }

    int celeb = possibleCeleb.pop();

    // check row not know anyone
    for (int c = 0; c < n; c++) {
      if (c != celeb) {
        if (M[celeb][c] == 1) {
          return -1;
        }
      }
    }

    // check col, i.e. known by everyone
    for (int r = 0; r < n; r++) {
      if (r != celeb) {
        if (M[r][celeb] == 0) {
          return -1;
        }
      }
    }

    return celeb;
  }
}
