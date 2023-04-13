import java.io.*;
import java.util.*;

class StackQueue
{
	Stack<Integer> mainStack = new Stack<>();
	Stack<Integer> auxStack = new Stack<>();

	// TC: O(1) enqueue
    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
		//Write your code here
		mainStack.push(x);
    }

	// TC: O(N) dequeue
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
		//Write your code here
		if (mainStack.size() == 0) {
			// queue is empty
			return -1;
		}
		
	    while (mainStack.size() > 1) {
			int ele = mainStack.pop();
			auxStack.push(ele);
		}

		int poppedEle = mainStack.pop();

		while (auxStack.size() > 0) {
			int ele = auxStack.pop();
			mainStack.push(ele);
		}

		return poppedEle;
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