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

	static class Pair {
		int dia;
		int height;

		Pair (int dia, int height) {
			this.dia = dia;
			this.height = height;
		}
	}

	// TC: O(N), SC: O(H)
	// faith: returns diameter and height of the tree
	public static Pair diameter2(Node root) {
		if (root == null) {
			return new Pair(0, 0);
		}

		Pair LST = diameter2(root.left);
		
		Pair RST = diameter2(root.right);

		int diaFromRoot = LST.height + 1 + RST.height;

		int diameterOfTree = Math.max(diaFromRoot, Math.max(LST.dia, RST.dia));

		int heightOfTree = Math.max(LST.height, RST.height) + 1;

		return new Pair(diameterOfTree, heightOfTree);
	}
	
    public static int diameter(Node root) {
        // Your code here
		Pair ans = diameter2(root);
		return ans.dia;
    }
}