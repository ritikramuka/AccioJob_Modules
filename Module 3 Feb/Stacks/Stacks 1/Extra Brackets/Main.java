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
        st.push(ch);
      } else {
        if (st.peek() == '(') {
          return true;
        } else {
          // remove the exp in between
          while (st.peek() != '(') {
            st.pop();
          }

          // as this pair holds a exp in between, that means a valid bracket
          // so remove the corresponding opening bracket
          st.pop();
        }
      }
    }

    // if no extra bracket was found
    return false;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution Obj = new Solution();
    if (Obj.ExtraBrackets(exp)) System.out.println(
      "true"
    ); else System.out.println("false");
  }
}
