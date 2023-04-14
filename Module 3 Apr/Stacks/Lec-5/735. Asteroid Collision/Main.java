class Solution {
    
    // TC: O(N), SC: O(N)
    public int[] asteroidCollision(int[] asteroids) {
        // Stack -> Asteroid freely moving in universe 
        Stack<Integer> st = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < -asteroid) {
                    st.pop();
                }
                
                if (st.size() > 0 && st.peek() > 0 && st.peek() == -asteroid) {
                    st.pop();
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() > -asteroid) {
                    continue;
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