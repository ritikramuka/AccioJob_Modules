import java.io.*;
import java.util.*;


class Solution{
    public String smallestNumber(String str){
        // write code here
		Stack<Integer> st = new Stack<>();
		int cnt = 1;

		StringBuilder sb = new StringBuilder("");
		for (char ch : str.toCharArray()) {
			if (ch == 'i') {
				sb.append(cnt);
				while (st.size() > 0) {
					sb.append(st.pop());
				}
			} else {
				st.push(cnt);
			}
			cnt++;
		}

		st.push(cnt);

		while (st.size() > 0) {
			sb.append(st.pop());
		}

		return sb.toString();
    }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}