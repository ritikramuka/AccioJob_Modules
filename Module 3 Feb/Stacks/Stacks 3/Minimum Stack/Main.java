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
//   int minEle;
//   Stack<Integer> s;

//   Solution() {
//     s = new Stack<Integer>();
//   }

//   //   TC: O(1), SC: O(1)
//   void push(int x) {
//     //Write Code here
//     s.push(x);
//   }

//   //   TC: O(1), SC: O(1)
//   int pop() {
//     //Write Code here
//     if (s.size() > 0) {
//       return s.pop();
//     } else {
//       return -1;
//     }
//   }

//   //   TC: O(N), SC: O(N)
//   int getMin() {
//     //Write Code here
//     Stack<Integer> temp = new Stack<>();
//     int minValue = Integer.MAX_VALUE;

//     // remove each element from stack s and add to temp stack
//     // so that we can look the value of each ele
//     // and get the min val in them
//     while (s.size() > 0) {
//       int ele = s.pop();
//       minValue = Math.min(minValue, ele);
//       temp.push(ele);
//     }

//     // but now the order of elements in intial stack is reverse in temp stack
//     // so to get back that order, remove everyone from temp stack and add to s Stack
//     while (temp.size() > 0) {
//       int ele = temp.pop();
//       s.push(ele);
//     }

//     return minValue;
//   }
// }

// class Solution {

//   class Pair {
//     int val;
//     int minVal;

//     Pair(int val, int minVal) {
//       this.val = val;
//       this.minVal = minVal;
//     }
//   }

//   Stack<Pair> s;

//   Solution() {
//     s = new Stack<Pair>();
//   }

//   //   TC: O(1), SC: O(1)
//   void push(int x) {
//     if (s.size() == 0) {
//       s.push(new Pair(x, x));
//     } else {
//       int prevMin = s.peek().minVal;
//       s.push(new Pair(x, Math.min(x, prevMin)));
//     }
//   }

//   //   TC: O(1), SC: O(1)
//   int pop() {
//     //Write Code here
//     if (s.size() == 0) {
//       return -1;
//     } else {
//       return s.pop().val;
//     }
//   }

//   //   TC: O(1), SC: O(1)
//   int getMin() {
//     //Write Code here
//     if (s.size() == 0) {
//       return -1;
//     } else {
//       return s.peek().minVal;
//     }
//   }
// }

class Solution {
  int minEle;
  Stack<Integer> s;

  Solution() {
    s = new Stack<Integer>();
  }

  //   TC: O(1), SC: O(1)
  void push(int x) {
    //Write Code here
    if (s.size() == 0) {
      minEle = x;
      s.push(x);
    } else {
      if (x >= minEle) {
        s.push(x);
      } else {
        // update minEle
        int val = x - minEle;
        minEle = x;
        s.push(val);
      }
    }
  }

  //   TC: O(1), SC: O(1)
  int pop() {
    //Write Code here
    if (s.size() == 0) {
      return -1;
    } else {
      if (s.peek() >= minEle) {
        return s.pop();
      } else {
        int prevMin = minEle - s.peek();
        int peekValue = minEle;
        s.pop();
        
        // rollback
        minEle = prevMin;
        
        return peekValue;
      }
    }
  }

  //   TC: O(1), SC: O(1)
  int getMin() {
    //Write Code here
    if (s.size() == 0) {
        return -1;
    }
    return minEle;
  }
}
