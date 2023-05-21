/**
 * https://course.acciojob.com/idle?question=81e92f10-8cae-412f-8d37-c0478c4619f5
 */

import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int q=sc.nextInt();
        sc.nextLine();
        TextEditor obj=new TextEditor();
        for(int i=0;i<q;i++)
        {
            // String[] s = sc.nextLine().split(" "); 
            String s=sc.nextLine();
            if(s.equals("UNDO"))
            {
                obj.UNDO();
            }
            else if(s.equals("REDO"))
            {
                obj.REDO();
            }
            else if(s.equals("READ"))
            {
               obj.READ();

            }
            else
            {
                char ch=s.charAt(6);
                obj.WRITE(ch);
            }
        }
    }
}

class TextEditor{
    // your code here
	static Stack<Character> docs;
	static Stack<Character> bin;

	TextEditor () 
	{
		docs = new Stack<>();
		bin = new Stack<>();
	}

	// TC: O(1)
    static void WRITE(char X)
    {
		docs.push(X);
    }

	// TC: O(1)
    static void UNDO()
    {
        if (docs.size() > 0) {
			char ch = docs.pop();
			bin.push(ch);
		}
    }

	// TC: O(1)
    static void REDO()
    {
        if (bin.size() > 0) {
			char ch = bin.pop();
			docs.push(ch);
		}
    }

	// TC: O(N)
    static void READ()
    {
	    Stack<Character> temp = new Stack<>();
		while (docs.size() != 0) {
			temp.push(docs.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (temp.size() != 0) {
			sb.append(temp.peek());
			docs.push(temp.pop());
		}

		System.out.print(sb.toString() + " ");
    }

}