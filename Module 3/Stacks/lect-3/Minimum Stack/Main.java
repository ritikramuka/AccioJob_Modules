import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int q = sc.nextInt();
            Solution g = new Solution();
            while (q > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    System.out.print(g.pop() + " ");
                } else if (qt == 3) {
                    System.out.print(g.getMin() + " ");
                }

                q--;
            }
            System.out.println();
            T--;
        }
        sc.close();

    }
}

// Approach 1
// class Solution {
// Stack<Integer> mainStack = new Stack<>();

// Solution() {

// }

// // TC: O(1), SC: O(1)
// void push(int x) {
// // Write Code here
// mainStack.push(x);
// }

// // TC: O(1), SC: O(1)
// int pop() {
// // Write Code here
// if (mainStack.size() == 0) {
// return -1;
// }

// return mainStack.pop();
// }

// // TC: O(N), SC: O(N)
// int getMin() {
// // Write Code here
// if (mainStack.size() == 0) {
// return -1;
// }

// int minVal = Integer.MAX_VALUE;
// Stack<Integer> tempStack = new Stack<>();
// while (mainStack.size() != 0) {
// int val = mainStack.pop();
// minVal = Math.min(minVal, val);
// tempStack.push(val);
// }

// while (tempStack.size() != 0) {
// int val = tempStack.pop();
// mainStack.push(val);
// }

// return minVal;
// }
// }

// Approach 2: TC: O(1) for each operation, SC: O(2N)
// class Solution {

// class Pair {
// int val = 0;
// int min = 0;

// Pair(int val, int min) {
// this.val = val;
// this.min = min;
// }
// }

// Stack<Pair> st = new Stack<>();

// Solution() {

// }

// // TC: O(1), SC: O(1)
// void push(int x) {
// // Write Code here
// if (st.size() == 0) {
// st.push(new Pair(x, x));
// } else {
// int myMin = Math.min(x, st.peek().min);
// st.push(new Pair(x, myMin));
// }
// }

// // TC: O(1), SC: O(1)
// int pop() {
// // Write Code here
// if (st.size() == 0) {
// return -1;
// } else {
// return st.pop().val;
// }
// }

// // TC: O(1), SC: O(1)
// int getMin() {
// // Write Code here
// if (st.size() == 0) {
// return -1;
// }

// return st.peek().min;
// }
// }

// Approach 3 TC: O(1) for each operation, SC: O(N)
class Solution {

    Stack<Integer> st = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    Solution() {

    }

    // TC: O(1), SC: O(1)
    void push(int x) {
        // Write Code here
        if (st.size() == 0) {
            st.push(x);
            minValue = x;
        } else {
            if (x < minValue) {
                // reposible to update min till now?
                int val = 2 * x - minValue;
                st.push(val);
                minValue = x;
            } else {
                st.push(x);
            }
        }
    }

    // TC: O(1), SC: O(1)
    int pop() {
        // Write Code here
        if (st.size() == 0) {
            return -1;
        }

        if (st.peek() > minValue) {
            return st.pop();
        } else {
            int ans = minValue;
            int prevMin = 2 * minValue - st.pop();
            minValue = prevMin;
            return ans;
        }
    }

    // TC: O(1), SC: O(1)
    int getMin() {
        // Write Code here
        if (st.size() == 0) {
            return -1;
        }

        return minValue;
    }
}
