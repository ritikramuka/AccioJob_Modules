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
        System.out.println(g.sizeOfTree(root1));
        System.out.println(g.sumOfTree(root1));
        System.out.println(g.maxOfTree(root1));
        System.out.println(g.heightOfTree(root1));
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
	// TC: O(N), SC: O(H) -> Height of the tree
    public int sizeOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		
		int lstSize = sizeOfTree(root.left);
		int rstSize = sizeOfTree(root.right);

		int size = lstSize + 1 + rstSize;

		return size;
    }

	// TC: O(N), SC: O(H)
    public int sumOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		
		int sumOfLST = sumOfTree(root.left);
		int sumOfRST = sumOfTree(root.right);

		int sumOfTree = sumOfLST + root.data + sumOfRST;

		return sumOfTree;
    }

	// TC: O(N), SC: O(H)
    public int maxOfTree(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = maxOfTree(root.left);
		int rmax = maxOfTree(root.right);

		int overallMax = Math.max(lmax, Math.max(rmax, root.data));

		return overallMax;
	}

	// TC: O(N), SC: O(H)
    public int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);

		int height = Math.max(leftHeight, rightHeight) + 1;

		return height;
    }
}