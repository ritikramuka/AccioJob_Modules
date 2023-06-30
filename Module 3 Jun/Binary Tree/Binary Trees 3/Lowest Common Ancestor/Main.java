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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
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
	// public static boolean nodeToRootPath (Node root, int val, ArrayList<Node> n2r) {
	// 	if (root == null) {
	// 		return false;
	// 	}

	// 	if (root.data == val) {
	// 		n2r.add(root);
	// 		return true;
	// 	}

	// 	boolean filc = nodeToRootPath(root.left, val, n2r);
	// 	if (filc == true) {
	// 		n2r.add(root);
	// 		return true;
	// 	}

	// 	boolean firc = nodeToRootPath(root.right, val, n2r);
	// 	if (firc == true) {
	// 		n2r.add(root);
	// 		return true;
	// 	}

	// 	return false;
	// }

	// TC: O(N), SC: O(H)
  //   public static Node findLCA(Node node,int n1,int n2) {
	 //    // write code here
		// ArrayList<Node> n2rFromN1 = new ArrayList<>();
		// nodeToRootPath(node, n1, n2rFromN1);

		// ArrayList<Node> n2rFromN2 = new ArrayList<>();
		// nodeToRootPath(node, n2, n2rFromN2);

		// int i = n2rFromN1.size() - 1;
		// int j = n2rFromN2.size() - 1;

		// Node lca = node;

		// while (i >= 0 && j >= 0) {
		// 	if (n2rFromN1.get(i) == n2rFromN2.get(j)) {
		// 		lca = n2rFromN1.get(i);
		// 		i--;
		// 		j--;
		// 	} else {
		// 		break;
		// 	}
		// }

		// return lca;
  //   }
	
	// TC: O(N), SC: O(H) -> callstack space
	public static Node findLCA(Node node,int n1,int n2) {
	    // write code here
		if (node == null) {
			return null;
		}

		if (node.data == n1 || node.data == n2) {
			return node;
		}

		Node filc = findLCA(node.left, n1, n2);
		Node firc = findLCA(node.right, n1, n2);

		if (filc != null && firc != null) {
			return node;
		} else if (filc != null) {
			return filc;
		} else if (firc != null) {
			return firc;
		} else {
			return null;
		}
    }
}