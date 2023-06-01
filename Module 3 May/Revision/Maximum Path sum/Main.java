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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution tr=new Solution();
	            int sum=tr.findMaxSum(root);
	            System.out.println(sum);
	        }
	}
}

class Solution
{
	class Pair {
		int maxPathSum;
		int bestPath;

		Pair (int maxPathSum, int bestPath) {
			this.maxPathSum = maxPathSum;
			this.bestPath = bestPath;
		}
	}

	Pair helper(Node root) {
		if (root == null) {
			return new Pair(Integer.MIN_VALUE, 0);
		}

		Pair left = helper(root.left);
		Pair right = helper(root.right);

		int maxPathSumFromRoot = root.data;
		if (left.bestPath > 0) {
			maxPathSumFromRoot += left.bestPath;
		}
		if (right.bestPath > 0) {
			maxPathSumFromRoot += right.bestPath;
		}

		int maxPathSumOfTree = Math.max(maxPathSumFromRoot, Math.max(left.maxPathSum, right.maxPathSum));

		int bestPathOfTree = Math.max(root.data, Math.max(root.data + left.bestPath, root.data + right.bestPath));

		return new Pair(maxPathSumOfTree, bestPathOfTree);
	}

	// TC: O(N), SC: O(H)
    int findMaxSum(Node node){
        //Write code here
		Pair ans = helper(node);
		return ans.maxPathSum;
    }   
}