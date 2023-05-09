import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // add elements
        st.push(10);
        st.push(20);
        st.push(30);

        // remove elements
        System.out.println(st.pop());

        // see topmost ele
        System.out.println(st.peek());

        // size
        System.out.println(st.size());

    }
}
