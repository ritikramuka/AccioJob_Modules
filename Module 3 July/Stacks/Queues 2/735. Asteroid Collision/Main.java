class Solution {
    // TC: O(N), SC: O(N)
    public int[] asteroidCollision(int[] asteroids) {
        // stack : people moving freely in my stable universe
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // no threat to stable universe
                st.push(asteroid);
            } else {
                // try to destroy as much asteroid of stable universe moving towards right
                while (st.size() > 0 && st.peek() > 0 && st.peek() < -1 * asteroid) {
                    // destroy peek person
                    st.pop();
                }

                if (st.size() > 0 && st.peek() > 0 && st.peek() > -1 * asteroid) {
                    // don't do anything as incoming asteroid got destroyed
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() == -1 * asteroid) {
                    // both peek value and incoming gets destroyed
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