import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int[] MovingBombs(int[] bombs) {
        // Write your code here

        Stack<Integer> st = new Stack<>();
        for (int bomb : bombs) {
            if (bomb > 0) {
                st.push(bomb);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < -bomb) {
                    st.pop();
                }

                if (st.size() > 0 && st.peek() == -bomb) {
                    st.pop();
                } else if (st.size() > 0 && st.peek() > -bomb) {
                    continue;
                } else {
                    st.push(bomb);
                }
            }
        }

        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while (st.size() > 0) {
            ans[i] = st.pop();
            i--;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.MovingBombs(arr);
        for (int j : result)
            System.out.print(j + " ");
        System.out.println();
        sc.close();
    }
}