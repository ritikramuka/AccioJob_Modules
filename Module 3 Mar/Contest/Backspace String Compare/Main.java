import java.io.*;
import java.util.*;

class Solution {

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '#') {
                if (stack1.size() > 0) {
                    stack1.pop();
                }
            } else {
                stack1.push(ch);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if (ch == '#') {
                if (stack2.size() > 0) {
                    stack2.pop();
                }
            } else {
                stack2.push(ch);
            }
        }

        if (stack1.size() != stack2.size()) {
            return false;
        } else {
            while (stack1.size() > 0) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        Solution Obj = new Solution();
        System.out.print(Obj.backspaceCompare(s, t));
    }
}
