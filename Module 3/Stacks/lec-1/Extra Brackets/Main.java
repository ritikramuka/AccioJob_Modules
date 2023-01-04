import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here
        // true when extra bracket else false

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // if '(' or Char or Operator -> push in stack
            if (ch != ')') {
                st.push(ch);
            }

            else {
                // we got a closing bracket
                if (st.peek() == '(') {
                    // no expression in between
                    return true;
                } else {
                    // removal of exp in between
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    // corresponding opening bracket for a closing bracket with exp in between
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