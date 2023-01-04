import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());

        System.out.println("popped -> " + st.pop());

        System.out.println(st.peek());

        st.push(50);

        System.out.println(st.peek());

        System.out.println(st.size());

        while (st.size() != 0) {
            System.out.println("popped -> " + st.pop());
        }

        // st.pop();
    }
}