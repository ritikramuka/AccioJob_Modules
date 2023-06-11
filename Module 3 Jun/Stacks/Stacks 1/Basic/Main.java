import java.util.*;

class Main {
    public static void main(String[] args) {
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // TC: O(1)
        // add ele
        st.push(10);
        st.push(20);
        st.push(30);
        
        // TC: O(1)
        // remove ele
        System.out.println(st.pop());

        // TC: O(1)
        // size of stack
        System.out.println(st.size());

        // TC: O(1)
        // topmost ele
        System.out.println(st.peek());
    }
}