
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n, k;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        in.nextLine();
        MyCircularDeque obj = new MyCircularDeque(k);
        for (int i = 0; i < n - 1; i++) {
            String[] s = in.nextLine().split(" ");

            if (s[0].equals("insertFront")) {
                int value = Integer.parseInt(s[1]);
                boolean ans = obj.insertFront(value);
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            } else if (s[0].equals("insertLast")) {
                int value = Integer.parseInt(s[1]);
                boolean ans = obj.insertLast(value);
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            } else if (s[0].equals("deleteFront")) {
                boolean ans = obj.deleteFront();
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            } else if (s[0].equals("deleteLast")) {
                boolean ans = obj.deleteLast();
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            } else if (s[0].equals("isFull")) {
                boolean ans = obj.isFull();
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            } else if (s[0].equals("isEmpty")) {
                boolean ans = obj.isEmpty();
                if (ans == true)
                    System.out.print("true ");
                else
                    System.out.print("false ");
            }

            else if (s[0].equals("getFront")) {
                int ans = obj.getFront();
                System.out.print(ans + " ");
            }

            else if (s[0].equals("getLast")) {
                int ans = obj.getRear();
                System.out.print(ans + " ");
            }
        }

        System.out.println();
    }

}

class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {
    // your code here
    Node head;
    Node tail;
    int size;
    int maxSize;

    public MyCircularDeque(int k) {
        head = null;
        tail = null;
        size = 0;
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        } else {
            Node node = new Node(value);

            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }

            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        } else {
            Node node = new Node(value);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;

            return true;
        }
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;

            return true;
        }
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        } else {
            return head.val;
        }
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        } else {
            return tail.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
