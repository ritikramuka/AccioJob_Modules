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

// class Solution {
// Stack<Integer> s;

// Solution() {
// s = new Stack<Integer>();
// }

// // TC: O(1), SC: O(1)
// void push(int x) {
// // Write Code here
// s.push(x);
// }

// // TC: O(1), SC: O(1)
// int pop() {
// // Write Code here
// if (s.isEmpty() == true) {
// return -1;
// }
// return s.pop();
// }

// // TC: O(N), SC: O(N)
// int getMin() {
// // Write Code here
// Stack<Integer> temp = new Stack<Integer>();
// int minEle = Integer.MAX_VALUE;
// while (s.size() > 0) {
// int ele = s.pop();
// minEle = Math.min(minEle, ele);
// temp.push(ele);
// }

// while (temp.size() > 0) {
// s.push(temp.pop());
// }

// return minEle;
// }
// }

// class Solution {
// class Pair {
// int val;
// int minEle;

// Pair(int val, int minEle) {
// this.val = val;
// this.minEle = minEle;
// }
// }

// Stack<Pair> stack;

// Solution() {
// stack = new Stack<Pair>();
// }

// // TC: O(1), SC: O(1)
// void push(int x) {
// // Write Code here
// if (stack.size() == 0) {
// stack.push(new Pair(x, x));
// } else {
// stack.push(new Pair (x, Math.min(stack.peek().minEle, x)));
// }
// }

// // TC: O(1), SC: O(1)
// int pop() {
// // Write Code here
// if (stack.size() == 0) {
// return -1;
// }

// return stack.pop().val;
// }

// // TC: O(1), SC: O(1)
// int getMin() {
// // Write Code here
// return stack.peek().minEle;
// }
// }

class Solution {
    int minEle;
    Stack<Integer> s;

    Solution() {
        s = new Stack<Integer>();
    }

    // TC: O(1), SC: O(1)
    void push(int x) {
        // Write Code here
        if (s.size() == 0) {
            minEle = x;
            s.push(x);
        } else {
            if (x < minEle) {
                int val = x - minEle;
                s.push(val);
                minEle = x;
            } else {
                s.push(x);
            }
        }
    }

    // TC: O(1), SC: O(1)
    int pop() {
        // Write Code here
        if (s.size() == 0) {
            return -1;
        } else {
            if (s.peek() < minEle) {
                int prevMin = minEle - s.pop();
                int val = minEle;
                minEle = prevMin;
                return val;
            } else {
                return s.pop();
            }
        }
    }

    // TC: O(1), SC: O(1)
    int getMin() {
        // Write Code here
		if (s.size() == 0) {
			return -1;
		}
        return minEle;
    }
}
