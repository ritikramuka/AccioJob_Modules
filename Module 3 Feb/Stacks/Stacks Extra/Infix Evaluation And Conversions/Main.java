import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob = new Solution();
    ob.evaluate(exp);
  }
}

class Solution {

  public int getPrecedence(char ch) {
    if (ch == '+') {
      return 1;
    } else if (ch == '-') {
      return 1;
    } else if (ch == '*') {
      return 2;
    } else if (ch == '/') {
      return 2;
    }

    return -1;
  }

  public int eval(int v1, int v2, char o) {
    if (o == '+') {
      return v1 + v2;
    } else if (o == '-') {
      return v1 - v2;
    } else if (o == '*') {
      return v1 * v2;
    } else {
      return v1 / v2;
    }
  }

  public void solve(String exp) {
    Stack<Integer> opd = new Stack<>();
    Stack<Character> opr = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '(') {
        opr.push(ch);
      } else if (Character.isDigit(ch) == true) {
        opd.push(ch - '0');
      } else if (ch == ')') {
        while (opr.peek() != '(') {
          // v1 o v2
          int v2 = opd.pop();
          int v1 = opd.pop();
          char o = opr.pop();

          int ans = eval(v1, v2, o);

          opd.push(ans);
        }

        opr.pop();
      } else {
        while (
          opr.size() > 0 &&
          opr.peek() != '(' &&
          getPrecedence(opr.peek()) >= getPrecedence(ch)
        ) {
          int v2 = opd.pop();
          int v1 = opd.pop();
          char o = opr.pop();

          int ans = eval(v1, v2, o);

          opd.push(ans);
        }

        opr.push(ch);
      }
    }

    while (opr.size() > 0) {
      int v2 = opd.pop();
      int v1 = opd.pop();
      char o = opr.pop();

      int ans = eval(v1, v2, o);

      opd.push(ans);
    }

    System.out.println(opd.peek());
  }

  public void convert(String exp) {
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> opr = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '(') {
        opr.push(ch);
      } else if (Character.isDigit(ch) == true) {
        pre.push(ch + "");
        post.push(ch + "");
      } else if (ch == ')') {
        while (opr.peek() != '(') {
          // v1 o v2
          String v2 = pre.pop();
          String v1 = pre.pop();
          char o = opr.pop();

          // pre : o V1 V2
          pre.push(o + v1 + v2);

          String a2 = post.pop();
          String a1 = post.pop();

          post.push(a1 + a2 + o);
        }

        opr.pop();
      } else {
        while (
          opr.size() > 0 &&
          opr.peek() != '(' &&
          getPrecedence(opr.peek()) >= getPrecedence(ch)
        ) {
          // v1 o v2
          String v2 = pre.pop();
          String v1 = pre.pop();
          char o = opr.pop();

          // pre : o V1 V2
          pre.push(o + v1 + v2);

          String a2 = post.pop();
          String a1 = post.pop();

          post.push(a1 + a2 + o);
        }

        opr.push(ch);
      }
    }

    while (opr.size() > 0) {
      // v1 o v2
      String v2 = pre.pop();
      String v1 = pre.pop();
      char o = opr.pop();

      // pre : o V1 V2
      pre.push(o + v1 + v2);

      String a2 = post.pop();
      String a1 = post.pop();

      post.push(a1 + a2 + o);
    }

    System.out.println(pre.peek());
    System.out.println(post.peek());
  }

  public void evaluate(String exp) {
    //Write code here
    solve(exp);

    convert(exp);
  }
}
