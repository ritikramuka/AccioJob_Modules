import java.util.ArrayList;

public class Main {
    static class Stack {
        private ArrayList<Integer> list;
        private int size;

        Stack() {
            list = new ArrayList<>();
            size = 0;
        }

        // TC: O(1)
        int pop() {
            if (size == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int ele = list.remove(size - 1);
                size--;
                return ele;
            }
        }

        // TC: O(1)
        void push(int e) {
            list.add(e);
            size++;
        }

        // TC: O(1)
        int size() {
            return size;
        }

        // TC: O(1)
        int peek() {
            if (size == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int ele = list.get(size - 1);
                return ele;
            }
        }
    }
    
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);

        System.out.println(s1.pop());

        System.out.println(s1.size());

        System.out.println(s1.peek());
    }
}
