import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public boolean ExtraBrackets(String exp) {
        // Write your code here

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch != ')') {
                st.push(ch);
            } else {
                // find corresponding opening bracket

                if (st.peek() == '(') {
                    // no exp in between
                    return true;
                } else {
                    // remove exp
                    while (st.size() != 0 && st.peek() != '(') {
                        st.pop();
                    }

                    // as we have a exp in between, so this pair is not a extra bracket
                    st.pop();
                }
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution Obj = new Solution();
        if (Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}