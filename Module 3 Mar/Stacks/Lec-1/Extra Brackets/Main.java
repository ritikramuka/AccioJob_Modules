import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch != ')') {
                // ch is opening bracket, or part of expression
                stack.push(ch);
            } else {
                if (stack.peek() == '(') {
                    // no exp in between, so extra bracket pair
                    return true;
                } else {
                    // remove exp from stack
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    
                    // stack peek is corresponding opening bracket
                    stack.pop();
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
        if (Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}