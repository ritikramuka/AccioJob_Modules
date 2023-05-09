import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch != ')') {
				// blindly add to the stack
				st.push(ch);
			} else {
				if (st.peek() == '(') {
					// nothing in between, hence extra pair of bracket
					return true;
				} else {
					// remove people in between you and corresponding opening bracket
					while (st.peek() != '(') {
						st.pop();
					}

					// as people were removed, hence you were a valid pair
					// remove corresponding open braket
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
        if(Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}