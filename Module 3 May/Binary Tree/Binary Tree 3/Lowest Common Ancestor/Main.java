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
	// n2r path
	// public static boolean find(Node node, int tar, ArrayList<Node> n2r) {
	// 	if (node == null) {
	// 		return false;
	// 	}

	// 	if (node.data == tar) {
	// 		n2r.add(node);
	// 		return true;
	// 	}

	// 	boolean filc = find(node.left, tar, n2r);
	// 	if (filc == true) {
	// 		n2r.add(node);
	// 		return true;
	// 	}

	// 	boolean firc = find(node.right, tar, n2r);
	// 	if (firc == true) {
	// 		n2r.add(node);
	// 		return true;
	// 	}

	// 	return false;
	// }

	// // TC: O(N), SC: O(H) for AL + O(H) for callstack
 //    public static Node findLCA(Node node,int n1,int n2) {
	//     // write code here
	// 	ArrayList<Node> n12r = new ArrayList<>();
	// 	find(node, n1, n12r);

	// 	ArrayList<Node> n22r = new ArrayList<>();
	// 	find(node, n2, n22r);	

	// 	int i = n12r.size() - 1;
	// 	int j = n22r.size() - 1;

	// 	Node lca = null;
	// 	while (i >= 0 && j >= 0 && n12r.get(i).data == n22r.get(j).data) {
	// 		lca = n12r.get(i);
	// 		i--;
	// 		j--;
	// 	}

	// 	return lca;
 //    }

	// TC: O(N), SC: O(H) for callstack
	public static Node findLCA(Node node,int n1,int n2) {
	    // write code here
		if (node == null) {
			return null;
		}

		if (node.data == n1) {
			return node;
		} else if (node.data == n2) {
			return node;
		}

		Node filc = findLCA(node.left, n1, n2);
		Node firc = findLCA(node.right, n1, n2);

		if (filc == null && firc != null) {
			return firc;
		} else if (filc != null && firc == null) {
			return filc;
		} else if (filc == null && firc == null) {
			return null;
		} else {
			return node;
		}
    }
}