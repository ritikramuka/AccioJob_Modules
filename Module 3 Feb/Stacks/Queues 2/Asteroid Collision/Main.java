import java.util.*;

class Solution {

  public int[] asteroidCollision(int[] asteroids) {
    //Write code here
    Stack<Integer> st = new Stack<>();

    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        st.push(asteroid);
      } else {
        while (st.size() > 0 && st.peek() > 0 && st.peek() < -asteroid) {
          st.pop();
        }

        if (st.size() > 0 && st.peek() > -asteroid) {
          // he destroyed me, hence no space for me in free universe
          continue;
        } else if (st.size() > 0 && st.peek() == -asteroid) {
          // we both got destroyed
          st.pop();
        } else {
          st.push(asteroid);
        }
      }
    }

    int[] ans = new int[st.size()];
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = st.pop();
    }

    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Solution Obj = new Solution();
    int[] result = Obj.asteroidCollision(arr);
    for (int i = 0; i < result.length; ++i) System.out.print(result[i] + " ");
    System.out.println();
    sc.close();
  }
}
