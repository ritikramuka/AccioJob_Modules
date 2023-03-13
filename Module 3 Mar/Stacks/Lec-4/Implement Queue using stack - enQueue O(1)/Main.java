// import java.io.*;
// import java.util.*;

// class StackQueue {
//     Stack<Integer> main = new Stack<>();
//     Stack<Integer> temp = new Stack<>();

//     // TC: O(1)
//     // Function to push an element in queue by using 2 stacks.
//     void Push(int x) {
//         // Write your code here
//         main.push(x);
//     }

//     // TC: O(N)
//     // Function to pop an element from queue by using 2 stacks.
//     int Pop() {
//         // Write your code here
//         if (main.size() == 0) {
//             return -1;
//         }

//         while (main.size() > 1) {
//             temp.push(main.pop());
//         }

//         int poppedValue = main.pop();

//         while (temp.size() > 0) {
//             main.push(temp.pop());
//         }

//         return poppedValue;
//     }
// }

// public class Main {
//     public static void main(String args[]) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         StackQueue s = new StackQueue();
//         int q = sc.nextInt();
//         ArrayList<Integer> ans = new ArrayList<>();
//         while (q > 0) {
//             int QueryType = sc.nextInt();
//             if (QueryType == 1) {
//                 int a = sc.nextInt();
//                 s.Push(a);
//             } else if (QueryType == 2)
//                 ans.add(s.Pop());
//             q--;
//         }
//         for (int x : ans)
//             System.out.print(x + " ");
//         System.out.println();
//     }
// }

import java.io.*;
import java.util.*;

class StackQueue {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    // TC: O(1)
    // Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        // Write your code here
        main.push(x);
    }

    // TC: O(N)
    // Function to pop an element from queue by using 2 stacks.
    int Pop() {
        // Write your code here
        if (main.size() == 0 && temp.size() == 0) {
            return -1;
        }

        if (temp.size() > 0) {
            return temp.pop();
        } else {
            while (main.size() > 1) {
                temp.push(main.pop());
            }

            return main.pop();
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
            } else if (QueryType == 2)
                ans.add(s.Pop());
            q--;
        }
        for (int x : ans)
            System.out.print(x + " ");
        System.out.println();
    }
}