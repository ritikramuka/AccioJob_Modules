import java.util.*;

class Node {

    int data;
    Node link;

	Node (int data) {
		this.data = data;
		this.link = null;
	}
}

class Main {
	public static void main(String[] args)
	{
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		Scanner sc = new Scanner(System.in);
        int q;
        q = sc.nextInt();
        while(q-->0){
            int x;
            x = sc.nextInt();
            if(x==1){
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if(x==2){
                System.out.println(obj.peek());
            }
            if(x==3){
                obj.pop();
            }
            if(x==4){
                Node temp = obj.display();
                while (temp != null) {

                    System.out.print(temp.data+" ");

                    temp = temp.link;
			    }
				System.out.println();
            }
        }
	}
}

class StackUsingLinkedlist {

	Node top;
	StackUsingLinkedlist() { 
		this.top = null;
	}

	public void addFirst(int x) {
		Node node = new Node(x);

		node.link = top;
		
		top = node;
	}

	public void removeFirst() {
		Node temp = top.link;

		top = null;

		top = temp;
	}

	// TC: O(1)
	public void push(int x)
	{
		//Complete the function
		addFirst(x);
	}

	// TC: O(1)
	public int peek()
	{
		//Complete the function
		if (top == null) {
			// underflow
			return -1;
		} else {
			return top.data;
		}
	}

	// TC: O(1)
	public void pop()
	{
		//Complete the function
		if (top == null) {
			// underflow
			return;
		} else {
			removeFirst();
		}
	}

	public Node display()
	{
		//Complete the function
		return top;
	}
}
