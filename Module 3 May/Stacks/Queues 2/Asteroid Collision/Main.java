import java.util.Stack;

class Solution {
    // TC: O(N), SC: O(N)
public int[] asteroidCollision(int[] asteroids) {
    // stack: has people moving freely in my known universe
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < asteroids.length; i++) {
                int asteroid = asteroids[i];

                if (asteroid > 0) {
                    // moving towards right
                    // it won't collide with anyone from my known universe
                    // as known universe is at the left side of current asteroid
                    st.push(asteroid);
                } else {
                    // moving towards left

                    while (st.size() > 0 && st.peek() > 0 && st.peek() < -asteroid) {
                        // they will get destroyed
                        st.pop();
                    }

                    if (st.size() > 0 && st.peek() > 0 && st.peek() == -asteroid) {
                        // both will get destroyed
                        st.pop();
                    } else if (st.size() > 0 && st.peek() > 0 && st.peek() > -asteroid) {
                        // you will get destroyed
                        continue;
                    } else {
                        // no threat, so add to freely moving universe
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