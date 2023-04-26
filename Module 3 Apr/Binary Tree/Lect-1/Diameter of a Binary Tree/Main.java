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
	// public static int getHeight(Node root) {
	// 	if (root == null) {
	// 		return 0;
	// 	}
		
	// 	int leftHeight = getHeight(root.left);
	// 	int rightHeight = getHeight(root.right);

	// 	int height = Math.max(leftHeight, rightHeight) + 1;

	// 	return height;
 //    }
	
	// static int maxDiameter = 0;
	// public static void getDiameter(Node root) {
	// 	if (root == null) {
	// 		return;
	// 	}

	// 	int lstHeight = getHeight(root.left);
	// 	int rstHeight = getHeight(root.right);

	// 	int diameter = lstHeight + 1 + rstHeight;
	// 	maxDiameter = Math.max(maxDiameter, diameter);

	// 	getDiameter(root.left);
	// 	getDiameter(root.right);
	// }

	// O(N^2), SC: O(H)
  //   public static int diameter(Node root) {
  //       // Your code here
		// getDiameter(root);
		// return maxDiameter;
  //   }


	static class Pair {
		int bestDia;
		int height;

		Pair (int height, int bestDia) {
			this.height = height;
			this.bestDia = bestDia;
		}
	}

	public static Pair getDiameter(Node root) {
		if (root == null) {
			return new Pair(0, 0);
		}
		
		Pair left = getDiameter(root.left);
		Pair right = getDiameter(root.right);

		// diameter passing through me
		int myDia = left.height + right.height + 1;

		int bestDiameter = Math.max(myDia, Math.max(left.bestDia, right.bestDia));

		int height = Math.max(left.height, right.height) + 1;

		return new Pair (height, bestDiameter);
	}

	// TC: O(N), SC: O(H)
	public static int diameter(Node root) {
        // Your code here
		Pair ans = getDiameter(root);
		return ans.bestDia;
    }
}