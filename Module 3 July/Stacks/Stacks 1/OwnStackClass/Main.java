import java.util.ArrayList;

public class Main {
    // every method should be O(1)
    static class Stack {
        ArrayList<Integer> st;
        int size;

        Stack() {
            st = new ArrayList<>();
            size = 0;
        }

        void push(int v) {
            st.add(v);
            size++;
        }

        int pop() {
            if (size > 0) {
                int ele = st.remove(size - 1);
                size--;
                return ele;
            } else {
                System.out.println("stack underflow");
                return -1;
            }
        }

        int peek() {
            if (size > 0) {
                int ele = st.get(size - 1);
                return ele;
            } else {
                System.out.println("stack underflow");
                return -1;
            }
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

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
