import java.util.*;

class Node {
	int data;
	Node next;

	Node () {
		this.data = 0;
		this.next = null;
	}

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
		head = null;
		tail = null;
		size = 0;
	}
	
    //Write your code here
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
	
    public int pop() {
        //Write your code here
		if (size == 0) {
			return -1;
		} else {
			int v = head.data;
			
			Node temp = head;
			head = head.next;
			temp.next = null;
			size--;

			return v;
		}
    }

    public int front() {
        //Write your code here
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
    }
	
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