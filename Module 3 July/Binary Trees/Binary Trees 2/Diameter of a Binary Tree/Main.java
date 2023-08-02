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
	// TC: O(N), SC: O(H)
	// static int height(Node root) {
	// 	// Base Case
	// 	if (root == null) {
	// 		return 0;
	// 	}

	// 	return Math.max(height(root.left), height(root.right)) + 1;
	// }

	// TC: O(N^2), SC: O(H)
	// faith: returns diameter of the tree starting from root
  //   public static int diameter(Node root) {
		// // Base Case
		// if (root == null) {
		// 	return 0;
		// }

		// // get diameter of the LST
		// int diaLST = diameter(root.left);

		// // get diameter of the RST
		// int diaRST = diameter(root.right);

		// // Diameter passing through root
		// // diaPassingRoot = lh + rh + 1
		// int lh = height(root.left);
		// int rh = height(root.right);
		// int diaPassingRoot = lh + 1 + rh;

		// // diameter of Tree = max{diaLST, diaRST, diaPassingRoot}
		// return Math.max(diaLST, Math.max(diaRST, diaPassingRoot));
  //   }

	static class Pair {
		int h;
		int dia;

		Pair(int h, int dia) {
			this.h = h;
			this.dia = dia;
		}
	}

	// TC: O(N), SC: O(H)
	// Faith: returns {h, dia} of the tree starting from root
	public static Pair diameter2(Node root) {
		if (root == null) {
			return new Pair(0, 0);
		}
		
		Pair LST = diameter2(root.left);
		Pair RST = diameter2(root.right);

		int heightOfTheTree = Math.max(LST.h, RST.h) + 1;

		int diameterPassingRoot = LST.h + RST.h + 1;

		int diameterOfTheTree = Math.max(LST.dia, Math.max(diameterPassingRoot, RST.dia));

		return new Pair(heightOfTheTree, diameterOfTheTree);
	}

	public static int diameter(Node root) {
		// Base Case
		Pair ans = diameter2(root);
		return ans.dia;
    }
}