import java.util.ArrayList;

public class Main {
    
    static class Stack {
        ArrayList<Integer> list;
        int size;

        Stack() {
            list = new ArrayList<>();
            size = 0;
        }

        // push operation
        void push(int v) {
            list.add(v);
            size++;
        }

        // pop operation
        int pop() {
            if (size > 0) {
                int ele = list.remove(size - 1);
                size--;
                return ele;
            } else {
                System.out.println("Stack is empty: stack underflow");
                return -1;
            }
        }

        // peek operation
        int peek() {
            if (size > 0) {
                return list.get(size - 1);
            } else {
                System.out.println("Stack is empty: stack underflow");
                return -1;
            }
        }

        // size operation
        int size() {
            return size;
        }
    }
    
    
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
