import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // add elements to the stack
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("size -> " + st.size());

        // remove element from the stack
        System.out.println(st.pop());

        System.out.println("size -> " + st.size());

        // see the topmost element in the stack
        System.out.println(st.peek());

        System.out.println("size -> " + st.size());
    }
}