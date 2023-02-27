import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public static boolean checkValidString(int n, String s) {
        // write code here
        Stack<Integer> opening = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        // intially stars will be considered as opening bracket and try neutralizing
        // closing brackets
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                opening.push(i);
            else if (ch == '*')
                stars.push(i);
            else {
                // closing bracket
                if (opening.size() > 0) {
                    opening.pop();
                } else if (stars.size() > 0) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }

        // consider my stars as a closing brackets
        if (opening.size() == 0) {
            // here remaining stars will act as a string
            return true;
        }

        if (opening.size() > stars.size()) {
            return false;
        }

        while (opening.size() != 0) {
            int openIdx = opening.pop();
            int closeIdx = stars.pop();

            if (openIdx > closeIdx)
                return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n, s);
        if (ans == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}