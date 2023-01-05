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

    public int precedence(char o) {
        if (o == '+') {
            return 1;
        } else if (o == '-') {
            return 1;
        } else if (o == '/') {
            return 2;
        } else {
            // o -> *
            return 2;
        }
    }

    public int eval(int v1, int v2, char o) {
        if (o == '+') {
            return v1 + v2;
        } else if (o == '-') {
            return v1 - v2;
        } else if (o == '/') {
            return v1 / v2;
        } else {
            // o -> *
            return v1 * v2;
        }
    }

    public int solve(String exp) {
        // consist of operands
        Stack<Integer> opd = new Stack<>();

        // consist of operators
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch) == true) {
                opd.push(ch - '0');
            } else if (ch == '(') {
                opr.push(ch);
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    int v2 = opd.pop();
                    int v1 = opd.pop();

                    char o = opr.pop();

                    int ans = eval(v1, v2, o);

                    opd.push(ans);
                }

                // remove the '(' bracket
                opr.pop();
            } else {
                // ch -> *, /, +, -
                while (opr.size() > 0 && opr.peek() != '(' && precedence(ch) <= precedence(opr.peek())) {
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

        return opd.peek();
    }

    public void convert(String exp) {
        // consist of postfix opd
        Stack<String> post = new Stack<>();

        // consist of prefix opd
        Stack<String> pre = new Stack<>();

        // consist of operators
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch) == true) {
                // opd.push(ch - '0');
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == '(') {
                opr.push(ch);
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    char o = opr.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String ans = postv1 + postv2 + o;
                    post.push(ans);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String ans2 = o + prev1 + prev2;
                    pre.push(ans2);
                }

                // remove the '(' bracket
                opr.pop();
            } else {
                // ch -> *, /, +, -
                while (opr.size() > 0 && opr.peek() != '(' && precedence(ch) <= precedence(opr.peek())) {
                    char o = opr.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String ans = postv1 + postv2 + o;
                    post.push(ans);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String ans2 = o + prev1 + prev2;
                    pre.push(ans2);
                }

                opr.push(ch);
            }
        }

        while (opr.size() > 0) {
            char o = opr.pop();

            String postv2 = post.pop();
            String postv1 = post.pop();
            String ans = postv1 + postv2 + o;
            post.push(ans);

            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String ans2 = o + prev1 + prev2;
            pre.push(ans2);
        }

        System.out.println(post.peek());
        System.out.println(pre.peek());
    }

    public void evaluate(String exp) {
        // Write code here
        System.out.println(solve(exp));

        convert(exp);
    }
}