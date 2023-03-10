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
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }

        return -1;
    }

    // v1 o v2
    public int eval(int v1, int v2, char o) {
        if (o == '+') {
            return v1 + v2;
        } else if (o == '-') {
            return v1 - v2;
        } else if (o == '*') {
            return v1 * v2;
        } else if (o == '/') {
            return v1 / v2;
        }

        return -1;
    }

    void solve(String exp) {
        // 2 stacks: first for opd, second for opr
        Stack<Character> opr = new Stack<Character>();
        Stack<Integer> opd = new Stack<Integer>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                opr.push(ch);
            } else if (Character.isDigit(ch) == true) {
                opd.push(ch - '0');
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    char o = opr.pop();
                    int v2 = opd.pop();
                    int v1 = opd.pop();

                    int ans = eval(v1, v2, o);

                    opd.push(ans);
                }

                opr.pop();
            } else {
                while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(ch) <= getPrecedence(opr.peek())) {
                    char o = opr.pop();
                    int v2 = opd.pop();
                    int v1 = opd.pop();

                    int ans = eval(v1, v2, o);

                    opd.push(ans);
                }

                opr.push(ch);
            }
        }

        while (opr.size() > 0) {
            char o = opr.pop();
            int v2 = opd.pop();
            int v1 = opd.pop();

            int ans = eval(v1, v2, o);

            opd.push(ans);
        }

        System.out.println(opd.peek());
    }

    void convert(String exp) {
        Stack<Character> opr = new Stack<Character>();

        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                opr.push(ch);
            } else if (Character.isDigit(ch) == true) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    char o = opr.pop();
                    String v2 = prefix.pop();
                    String v1 = prefix.pop();

                    String ans = o + v1 + v2;
                    prefix.push(ans);

                    String b2 = postfix.pop();
                    String b1 = postfix.pop();
                    ans = b1 + b2 + o;

                    postfix.push(ans);
                }

                opr.pop();
            } else {
                while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(ch) <= getPrecedence(opr.peek())) {
                    char o = opr.pop();
                    String v2 = prefix.pop();
                    String v1 = prefix.pop();

                    String ans = o + v1 + v2;
                    prefix.push(ans);

                    String b2 = postfix.pop();
                    String b1 = postfix.pop();
                    ans = b1 + b2 + o;

                    postfix.push(ans);
                }

                opr.push(ch);
            }
        }

        while (opr.size() > 0) {
            char o = opr.pop();
            String v2 = prefix.pop();
            String v1 = prefix.pop();

            String ans = o + v1 + v2;
            prefix.push(ans);

            String b2 = postfix.pop();
            String b1 = postfix.pop();
            ans = b1 + b2 + o;

            postfix.push(ans);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    // TC: O(N), SC: O(N)
    public void evaluate(String exp) {
        // Write code here
        solve(exp);

        convert(exp);
    }
}