import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.diameter(root1));
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
	// // TC: O(N), SC: O(H)
	// // In terms of nodes
 //    public int heightOfTree(Node root) {
	// 	if (root == null) {
	// 		return 0;
	// 	}

	// 	int heightOfLST = heightOfTree(root.left);
	// 	int heightOfRST = heightOfTree(root.right);

	// 	int height = Math.max(heightOfLST, heightOfRST) + 1;

	// 	return height;
 //    }

	// // TC: O(N^2), SC: O(H)
	// // Faith: returns diameter of the tree
 //    public static int diameter(Node root) {
 //        // Your code here
	// 	if (root == null) {
	// 		return 0;
	// 	}

	// 	int diameterOfLST = diameter(root.left);

	// 	int diameterOfRST = diameter(root.right);

	// 	// diameter from root
	// 	int heightOfLST = heightOfTree(root.left);

	// 	int heightOfRST = heightOfTree(root.right);

	// 	int diameterFromRoot = heightOfLST + 1 + heightOfRST;

	// 	int diameterOfTree = Math.max(diameterOfLST, Math.max(diameterFromRoot, diameterOfRST));

	// 	return diameterOfTree;
 //    }

	static class Pair {
		int dia;
		int height;

		Pair (int dia, int height) {
			this.dia = dia;
			this.height = height;
		}
	}

	// TC: O(N), SC: O(H)
	// faith: returns diameter and height of tree
	public static Pair helper(Node root) {
		if (root == null) {
			return new Pair(0, 0);
		}
		
		Pair left = helper(root.left);

		Pair right = helper(root.right);

		int diameterFromRoot = left.height + right.height + 1;

		int diameterOfTree = Math.max(left.dia, Math.max(diameterFromRoot, right.dia));

		int heightOfTree = Math.max(left.height, right.height) + 1;

		return new Pair(diameterOfTree, heightOfTree);
	}
	
	public static int diameter(Node root) {
        // Your code here
		return helper(root).dia;
    }
}