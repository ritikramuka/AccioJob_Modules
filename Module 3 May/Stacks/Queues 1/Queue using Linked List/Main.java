import java.util.*;

class Node {
	int data;
	Node next;

	Node () { }

	Node (int data) {
		this.data = data;
		this.next = null;
	}
}

class Queue {
	Node head;
	Node tail;
	int size;

	Queue() {
		head = tail = null;
		size = 0;
	}

	// TC: O(1)
	public void push(int value) {
        //Write your code here

		Node node = new Node(value);
		
		if (size == 0) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}

		size++;
    }

	// TC: O(1)
    public int pop() {
        //Write your code here
		if (size == 0) {
			// underflow
			return -1;
		} else if (size == 1) {
			// the only element in linkedlist
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		} else {
			Node temp = head.next;
			int val = head.data;
			head = null;
			head = temp;
			size--;
			return val;
		}
    }

	// TC: O(1)
    public int front() {
        //Write your code here
		if (size == 0) {
			// underflow
			return -1;
		} else {
			return head.data;
		}
    }

	// TC: O(1)
    public int getSize() {
        //Write your code here
		return size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.getSize());
        }
    }
}