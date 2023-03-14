import java.util.*;

class Solution {

    // TC: O(N), SC: O(N)
    public int[] asteroidCollision(int[] asteroids) {
        // Write code here

        // stack will have all the asteroids moving freely in my known universe
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < -asteroid) {
                    st.pop();
                }

                if (st.size() > 0 && st.peek() > 0 && st.peek() > -asteroid) {
                    continue;
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() == -asteroid) {
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
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}
