import java.io.*;
import java.util.*;

class StackQueue {
  Stack<Integer> mainStack = new Stack<>();
  Stack<Integer> supportStack = new Stack<>();

  // TC: Equeue is O(N)
  //Function to push an element in queue by using 2 stacks.
  void Push(int x) {
    //Write your code here

    // step 1: add everyone from mainStack to supportStack
    while (mainStack.size() > 0) {
      int ele = mainStack.pop();
      supportStack.push(ele);
    }

    // step 2: add myself to mainStack, so that I'm the last person to be removed from stack
    mainStack.push(x);

    // step 3: add everyone back from suppportStack to mainStack
    while (supportStack.size() > 0) {
      int ele = supportStack.pop();
      mainStack.push(ele);
    }
  }

  // TC: dequeue is O(1)
  //Function to pop an element from queue by using 2 stacks.
  int Pop() {
    //Write your code here
    if (mainStack.size() == 0) {
      return -1;
    } else {
      return mainStack.pop();
    }
  }
}

public class Main {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    StackQueue s = new StackQueue();
    int q = sc.nextInt();
    ArrayList<Integer> ans = new ArrayList<>();
    while (q > 0) {
      int QueryType = sc.nextInt();
      if (QueryType == 1) {
        int a = sc.nextInt();
        s.Push(a);
      } else if (QueryType == 2) ans.add(s.Pop());
      q--;
    }
    for (int x : ans) System.out.print(x + " ");
    System.out.println();
  }
}
