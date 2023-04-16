/**
 * https://course.acciojob.com/idle?question=b35b8b6f-f94e-4fc1-85a5-34d9e486acd7
 */
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.barcketNumbers(S);
            for(int value :  result)
            System.out.print(value + " ");
            System.out.println();
        
    }
}


class Solution {
	// TC: O(N), SC: O(N)
    ArrayList<Integer> barcketNumbers(String S) {
        // code here
		ArrayList<Integer> list = new ArrayList<Integer>();

		Stack<Integer> st = new Stack<>();
		int num = 0;

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);

			if (ch == '(') {
				num += 1;
				st.push(num);
				list.add(num);
			} else if (ch == ')') {
				int openingBracketNum = st.pop();
				list.add(openingBracketNum);
			}
		}
		
		return list;
    }
};