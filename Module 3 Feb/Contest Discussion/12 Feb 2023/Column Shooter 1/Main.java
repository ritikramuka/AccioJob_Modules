import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] heights = new int[n];
    for (int i = 0; i < n; i++) {
      heights[i] = input.nextInt();
    }
    System.out.println(maxScore(heights));
  }

  // TC: O(N), SC: O(N)
  public static int maxScore(int[] heights) {
    int maxScore = 0;

    Stack<Integer> st = new Stack<>();
    for (int i = heights.length - 1; i >= 0; i--) {
      while (st.size() > 0 && heights[st.peek()] < heights[i]) {
        int heightDiff = heights[i] - heights[st.peek()];
        int dist = st.peek() - i;
        st.pop();
        int myScore = heightDiff * dist;
        maxScore = Math.max(myScore, maxScore);
      }

      st.push(i);
    }

    return maxScore;
  }
}
