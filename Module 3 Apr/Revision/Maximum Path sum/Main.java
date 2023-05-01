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
	// int bestPath(Node node) {
	// 	if (node == null) {
	// 		return 0;
	// 	}

	// 	int left = bestPath(node.left);
	// 	int right = bestPath(node.right);

	// 	int bestPath = node.data;
	// 	if (left > right && left > 0) {
	// 		bestPath += left;
	// 	} else if (right > left && right > 0) {
	// 		bestPath += right;
	// 	}

	// 	return bestPath;
	// }
	
 //    int findMaxSum(Node node){
 //        //Write code here
	// 	if (node == null) {
	// 		return Integer.MIN_VALUE;
	// 	}

	// 	int maxPathSumInLST = findMaxSum(node.left);
	// 	int maxPathSumInRST = findMaxSum(node.right);

	// 	int bestPathFromLeft = bestPath(node.left);
	// 	int bestPathFromRight = bestPath(node.right);

	// 	int bestPathIncludingMe = node.data;
	// 	if (bestPathFromLeft > 0) {
	// 		bestPathIncludingMe += bestPathFromLeft;
	// 	}
	// 	if (bestPathFromRight > 0) {
	// 		bestPathIncludingMe += bestPathFromRight;
	// 	}

	// 	return Math.max(bestPathIncludingMe, Math.max(maxPathSumInRST, maxPathSumInLST));
 //    } 

	class Pair {
		int bestPath;
		int maxPath;

		Pair (int maxPath, int bestPath) {
			this.bestPath = bestPath;
			this.maxPath = maxPath;
		}
	}

	Pair findMaxSum_(Node node) {
		if (node == null) {
			return new Pair(Integer.MIN_VALUE, 0);
		}
		
		Pair left = findMaxSum_(node.left);
		Pair right = findMaxSum_(node.right);

		int maxPathSumIncMe = node.data;
		if (left.bestPath > 0) {
			maxPathSumIncMe += left.bestPath;
		}
		if (right.bestPath > 0) {
			maxPathSumIncMe += right.bestPath;
		}

		int maxPathSumOfTree = Math.max(maxPathSumIncMe, Math.max(left.maxPath, right.maxPath));
		int bestPathOfTree = node.data;
		if (left.bestPath > right.bestPath && left.bestPath > 0) {
			bestPathOfTree += left.bestPath;
		} else if (right.bestPath > left.bestPath && right.bestPath > 0) {
			bestPathOfTree += right.bestPath;
		}

		return new Pair(maxPathSumOfTree, bestPathOfTree);
	}

	// TC: O(N)
	int findMaxSum(Node node){
        //Write code here
		Pair ans = findMaxSum_(node);
		return ans.maxPath;
    } 
}