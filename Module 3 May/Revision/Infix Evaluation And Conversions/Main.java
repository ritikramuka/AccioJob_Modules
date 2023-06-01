import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluate(exp);
  }
}

class Solution {

	// higher the value of precedence, more priority it has
	public int getPrecedence(char ch) {
		if (ch == '*' || ch == '/') {
			return 1;
		} else {
			return 0;
		}
	}

	public int eval(int a, int b, char o) {
		if (o == '/') {
			return a / b;
		} else if (o == '+') {
			return a + b;
		} else if (o == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	public int solve(String exp) {
		Stack<Character> opr = new Stack<>();
		Stack<Integer> opd = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				opr.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				opd.push(ch - '0');
			} else if (ch == ')') {
				while (opr.size() > 0 && opr.peek() != '(') {
					// v1 o v2
					char o = opr.pop();
					int v2 = opd.pop();
					int v1 = opd.pop();

					int res = eval(v1, v2, o);

					opd.push(res);
				}
				opr.pop();
			} else {
				// ch -> *, /, +, -
				while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(opr.peek()) >= getPrecedence(ch)){
					// v1 o v2
					char o = opr.pop();
					int v2 = opd.pop();
					int v1 = opd.pop();

					int res = eval(v1, v2, o);

					opd.push(res);
				}

				opr.push(ch);
			}
		}

		while (opr.size() > 0) {
			// v1 o v2
			char o = opr.pop();
			int v2 = opd.pop();
			int v1 = opd.pop();

			int res = eval(v1, v2, o);

			opd.push(res);
		}

		return opd.peek();
	}

	void convert(String exp) {
		Stack<Character> opr = new Stack<>();
		Stack<String> pre = new Stack<>();
		Stack<String> post = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				opr.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				pre.push(ch + "");
				post.push(ch + "");
			} else if (ch == ')') {
				while (opr.size() > 0 && opr.peek() != '(') {
					// v1 o v2
					char o = opr.pop();
					
					String v2 = pre.pop();
					String v1 = pre.pop();

					pre.push(o + v1 + v2);

					v2 = post.pop();
					v1 = post.pop();

					post.push(v1 + v2 + o);
				}
				opr.pop();
			} else {
				// ch -> *, /, +, -
				while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(opr.peek()) >= getPrecedence(ch)){
					// v1 o v2
					char o = opr.pop();
					
					String v2 = pre.pop();
					String v1 = pre.pop();

					pre.push(o + v1 + v2);

					v2 = post.pop();
					v1 = post.pop();

					post.push(v1 + v2 + o);
				}

				opr.push(ch);
			}
		}

		while (opr.size() > 0) {
			// v1 o v2
			char o = opr.pop();
					
			String v2 = pre.pop();
			String v1 = pre.pop();

			pre.push(o + v1 + v2);

			v2 = post.pop();
			v1 = post.pop();

			post.push(v1 + v2 + o);
		}

		System.out.println(post.peek());
		
		System.out.println(pre.peek());
	}
	
    public void evaluate(String exp) {
        //Write code here
		System.out.println(solve(exp));
		convert(exp);
    }
}               