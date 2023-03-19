
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String S = read.readLine();
        Solution ob = new Solution();
        ArrayList<Integer> result = ob.barcketNumbers(S);
        for (int value : result)
            System.out.print(value + " ");
        System.out.println();

    }
}

class Solution {
    // TC: O(N), SC: O(N)
    ArrayList<Integer> barcketNumbers(String s) {
        // code here

        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                num += 1;
                list.add(num);
                st.push(num);
            } else if (ch == ')') {
                int numClosing = st.pop();
                list.add(numClosing);
            }
        }

        return list;
    }
};