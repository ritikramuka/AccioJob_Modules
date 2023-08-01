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
	// Faith: returns size of the tree from root
    public int sizeOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int lstSize = sizeOfTree(root.left);

		int rstSize = sizeOfTree(root.right);

		return lstSize + rstSize + 1;
    }

	// Faith: sum of the tree from root
    public int sumOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftSum = sumOfTree(root.left);

		int rightSum = sumOfTree(root.right);

		return leftSum + rightSum + root.data;
    }

	// Faith: returns max value in the tree from root
    public int maxOfTree(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = maxOfTree(root.left);

		int rmax = maxOfTree(root.right);

		return Math.max(lmax, Math.max(rmax, root.data));
    }

	// Faith: returns height of the tree from root, in terms of nodes
    public int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int lstHeight = heightOfTree(root.left);

		int rstHeight = heightOfTree(root.right);

		return Math.max(lstHeight, rstHeight) + 1;
    }
}