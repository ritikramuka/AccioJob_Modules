import java.util.*;

class Node {
	int val;
	Node next;

	Node () {
		this.val = 0;
		this.next = null;
	}

	Node (int val) {
		this.val = val;
		this.next = null;
	}
}

class Queue {
	Node head;
	Node tail;
	int size;

	Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	// TC: O(1)
    public void push(int value) {
        // add last
		Node node = new Node(value);
		
		if (size == 0) {
			// first element in the queue
			head = tail = node;	
		} else {
			tail.next = node;
			tail = node;
		}
		
		size++;
    }

	// TC: O(1)
    public int pop() {
        // remove first
		if (size == 0) {
			// queue is empty
			return -1;
		} else if (size == 1) {
			int ele = head.val;
			head = tail = null;
			size = 0;
			return ele;
		} else {
			int ele = head.val;
			Node temp = head.next;
			head = null;
			head = temp;
			size--;
			return ele;
		}
    }

	// TC: O(1)
    public int front() {
        if (size == 0) {
			// queue is empty
			return -1;
		} else {
			return head.val;	
		}
    }

	// TC: O(1)
    public int getSize() {
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