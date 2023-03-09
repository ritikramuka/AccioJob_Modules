import java.util.*;

public class Main {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        Pair() {
            this.a = 0;
            this.b = 0;
        }

        // @Override
        // public String toString () {
        // return "(" + a + "," + b + ")";
        // }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // push into stack
        st.push(10);
        st.push(20);

        // peek into stack
        int peek = st.peek();
        System.out.println(peek);

        // pop from stack
        st.pop();

        peek = st.peek();
        System.out.println(peek);

        // size of stack
        int size = st.size();
        System.out.println(size);

        // isEmpty
        System.out.println(st.isEmpty());

        st.pop();

        System.out.println(st.isEmpty());

        System.out.println("=================================");

        Stack<Pair> st2 = new Stack<>();
        st2.push(new Pair(1, 2));
        st2.push(new Pair(3, 4));
        st2.push(new Pair(5, 6));
        st2.push(new Pair(7, 8));

        /**
         * |   |
         * |7,8|
         * |5,6|
         * |3,4|
         * |1,2|
         * _____
         */

        Pair peekObj = st2.peek();
        System.out.println(peekObj.a + ", " + peekObj.b);

        st2.pop();

        peekObj = st2.peek();
        System.out.println(peekObj.a + ", " + peekObj.b);

        System.out.println(st2.size());

        while (st2.isEmpty() == false) {
            st2.pop();
        }

        System.out.println(st2.size());

        // Empty stack error message
        System.out.println(st2.peek());
    }
}
