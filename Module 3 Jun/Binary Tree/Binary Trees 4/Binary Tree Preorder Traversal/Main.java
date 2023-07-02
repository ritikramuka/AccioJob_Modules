
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.preorderTraversal(root);
            
		
	}
}

class Solution {
	/**
		call num = 0 -> call left side
		call num = 1 -> call right side
		call num = 2 -> remove yourself
	*/
	
	static class Pair {
		Node node;
		int callNum;

		Pair(Node node, int callNum) {
			this.node = node;
			this.callNum = callNum;
		}
	}

	public static void preorderTraversal(Node root) {
		//Write your code here 
		Stack<Pair> callStack = new Stack<>();

		callStack.push(new Pair(root, 0));

		while (callStack.size() > 0) {
			Pair rpair = callStack.peek();

			if (rpair.callNum == 0) {
				System.out.print(rpair.node.data + " ");

				rpair.callNum = 1;
				
				if (rpair.node.left != null) {
					callStack.push(new Pair(rpair.node.left, 0));
				}
			} else if (rpair.callNum == 1) {
				rpair.callNum = 2;

				if (rpair.node.right != null) {
					callStack.push(new Pair(rpair.node.right, 0));
				}
			} else {
				callStack.pop();
			}
		}
	}
}