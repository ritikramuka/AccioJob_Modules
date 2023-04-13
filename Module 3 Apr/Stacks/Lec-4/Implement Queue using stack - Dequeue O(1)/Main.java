import java.io.*;
import java.util.*;

class StackQueue
{
	Stack<Integer> mainStack = new Stack<>();
	Stack<Integer> auxStack = new Stack<>();

	// TC: O(N), enqueue
    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
		//Write your code here

		while (mainStack.size() > 0) {
			int ele = mainStack.pop();
			auxStack.push(ele);
		}

		mainStack.push(x);

		while (auxStack.size() > 0) {
			mainStack.push(auxStack.pop());
		}
    }

	// TC: O(1), dequeue
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
		//Write your code here
		if (mainStack.size() == 0) {
			return -1;
		}

		return mainStack.pop();
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);  
        StackQueue s = new StackQueue();	
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
            ans.add(s.Pop());
        q--;
        }	
        for(int x:ans)
        System.out.print(x+" ");       
     System.out.println();
    }
}