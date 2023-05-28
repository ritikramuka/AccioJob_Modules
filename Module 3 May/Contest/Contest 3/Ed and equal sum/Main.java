/**
 * https://course.acciojob.com/idle?question=4cffb8d5-5cc8-4f73-9e66-397fc86b49e8 
 */

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
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    if(g.isSumTree(root) == true)
    			    System.out.println(1);
    			else 
    			    System.out.println(0);
                t--;
            
        }
    }
  
}

class Solution
{
	class Pair {
		int sum;
		boolean isEqualSum;

		Pair(int sum, boolean isEqualSum) {
			this.sum = sum;
			this.isEqualSum = isEqualSum;
		}
	}

	Pair helper(Node root) {
		if (root == null) {
			return new Pair(0, true);
		}

		// leaf nodes
		if (root.left == null && root.right == null) {
			return new Pair(root.data, true);
		}
		
		Pair left = helper(root.left);
		Pair right = helper(root.right);

		if (left.isEqualSum != true || right.isEqualSum != true || root.data != (left.sum + right.sum)) {
			return new Pair(left.sum + right.sum + root.data, false);
		} else {
			return new Pair(left.sum + right.sum + root.data, true);
		}
	}

	// TC: O(N), SC: O(H)
    boolean isSumTree(Node node){
        //Write code here
		return helper(node).isEqualSum;
    }
}    