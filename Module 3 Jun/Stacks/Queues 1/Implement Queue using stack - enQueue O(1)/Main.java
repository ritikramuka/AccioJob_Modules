import java.io.*;
import java.util.*;

// class StackQueue
// {
// 	Stack<Integer> mainStack = new Stack<>();
// 	Stack<Integer> auxStack = new Stack<>();

// 	// TC: O(1)
//     //Function to push an element in queue by using 2 stacks.
//     void Push(int x)
//     {
// 		//Write your code here
// 		mainStack.push(x);
//     }

// 	// TC: O(N)
//     //Function to pop an element from queue by using 2 stacks.
//     int Pop()
//     {
// 		//Write your code here
// 		if (mainStack.size() == 0) {
// 			return -1;
// 		}

// 		while(mainStack.size() != 1) {
// 			auxStack.push(mainStack.pop());
// 		}

// 		int ans = mainStack.pop();

// 		while (auxStack.size() != 0) {
// 			mainStack.push(auxStack.pop());
// 		}

// 		return ans;
//     }
// }

class StackQueue
{
	Stack<Integer> mainStack = new Stack<>();
	Stack<Integer> auxStack = new Stack<>();

	// TC: O(1)
    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
		//Write your code here
		mainStack.push(x);
    }

	// TC: O(1) avg time
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
		//Write your code here
		if (auxStack.size() == 0) {
			if (mainStack.size() == 0) {
				return -1;
			} else {
				while(mainStack.size() != 1) {
					auxStack.push(mainStack.pop());
				}
		
				int ans = mainStack.pop();

				return ans;
			}
		} else {
			return auxStack.pop();
		}
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