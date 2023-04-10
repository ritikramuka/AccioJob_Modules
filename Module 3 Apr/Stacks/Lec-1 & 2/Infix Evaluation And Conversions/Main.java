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

class Solution{

	public int getPrecedence (char o) {
		if (o == '+' || o == '-') {
			return 1;
		} else {
			return 2;
		}
	}

	// v1 o v2
	public int eval (int v1, char o, int v2) {
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

	public void solve (String exp) {
		Stack<Integer> opd = new Stack<>();
		Stack<Character> opr = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				opr.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				opd.push(ch - '0');
			} else if (ch == ')') {
				while (opr.peek() != '(') {
					char o = opr.pop();
					int v2 = opd.pop();
					int v1 = opd.pop();

					int sol = eval(v1, o, v2);

					opd.push(sol);
				}

				opr.pop();
			} else {
				// ch -> *, /, +, -
				while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(opr.peek()) >= getPrecedence(ch)) {
					char o = opr.pop();
					int v2 = opd.pop();
					int v1 = opd.pop();

					int sol = eval(v1, o, v2);

					opd.push(sol);
				}

				opr.push(ch);
			}
		}

		while (opr.size() > 0) {
			char o = opr.pop();
			int v2 = opd.pop();
			int v1 = opd.pop();

			int sol = eval(v1, o, v2);

			opd.push(sol);
		}

		System.out.println(opd.peek());
	}

	public void convert (String exp) {
		Stack<String> opdPost = new Stack<>();
		Stack<String> opdPre = new Stack<>();
		Stack<Character> opr = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				opr.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				opdPre.push(ch + "");
				opdPost.push(ch + "");
			} else if (ch == ')') {
				while (opr.peek() != '(') {
					char o = opr.pop();
					
					String v2 = opdPre.pop();
					String v1 = opdPre.pop();

					String ans = o + v1 + v2;
					opdPre.push(ans);

					v2 = opdPost.pop();
					v1 = opdPost.pop();

					ans = v1 + v2 + o;
					opdPost.push(ans);
				}

				opr.pop();
			} else {
				// ch -> *, /, +, -
				while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(opr.peek()) >= getPrecedence(ch)) {
					char o = opr.pop();
					
					String v2 = opdPre.pop();
					String v1 = opdPre.pop();

					String ans = o + v1 + v2;
					opdPre.push(ans);

					v2 = opdPost.pop();
					v1 = opdPost.pop();

					ans = v1 + v2 + o;
					opdPost.push(ans);
				}

				opr.push(ch);
			}
		}

		while (opr.size() > 0) {
			char o = opr.pop();
					
			String v2 = opdPre.pop();
			String v1 = opdPre.pop();

			String ans = o + v1 + v2;
			opdPre.push(ans);

			v2 = opdPost.pop();
			v1 = opdPost.pop();

			ans = v1 + v2 + o;
			opdPost.push(ans);
		}

		System.out.println(opdPost.peek());
		System.out.println(opdPre.peek());
	}

	// TC: O(N), SC: O(N)
    public void evaluate(String exp){
        //Write code here
		solve(exp);

		convert(exp);
    }
}               