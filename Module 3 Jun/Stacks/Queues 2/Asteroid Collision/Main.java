class Solution {
    // TC: O(N), SC: O(N)
    public int[] asteroidCollision(int[] asteroids) {
        // people moving freely in my explored universe
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // I'm moving towards right, hence no one from explored universe can have me in a head on collision
                st.push(asteroid);
            } else {
                // I'm moving towards left

                // do I have people in my explored universe moving towards right, and there magnitude is less than me? if yes explode them
                while (st.size() > 0 && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(asteroid)) {
                    // explode smaller person
                    st.pop();
                }

                // do I have people in my explored universe moving towards right, and there magnitude is equal to me? if yes, both will get explode
                if (st.size() > 0 && st.peek() > 0 && Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                } 
                
                // do I have people in my explored universe moving towards right, and there magnitude is greater to me? if yes, I will explode
                else if (st.size() > 0 && st.peek() > 0 && Math.abs(st.peek()) > Math.abs(asteroid)) {
                    continue;
                } 
                
                // do I have people in my explored universe moving towards left, or it is empty, I will never collide, hence add me
                else {
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