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
            if (i >= ip.length)
                break;
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
        Node ans = g.findLCA(root, x, y);
        System.out.println(ans.data);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // static ArrayList<Node> n2r;

    // static boolean node2rootPath (Node root, int target) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == target) {
    // n2r.add(root);
    // return true;
    // }

    // boolean filc = node2rootPath(root.left, target);
    // if (filc == true) {
    // n2r.add(root);
    // return true;
    // }

    // boolean firc = node2rootPath(root.right, target);
    // if (firc == true) {
    // n2r.add(root);
    // return true;
    // }

    // return false;
    // }

    // // TC: O(N), SC: O(N)
    // public static Node findLCA(Node node,int n1,int n2) {
    // // write code here
    // n2r = new ArrayList<>();
    // node2rootPath (node, n1);
    // ArrayList<Node> n2rn1 = n2r;

    // n2r = new ArrayList<>();
    // node2rootPath (node, n2);
    // ArrayList<Node> n2rn2 = n2r;

    // Node lca = new Node();
    // int i = n2rn1.size() - 1;
    // int j = n2rn2.size() - 1;

    // while (i >= 0 && j >= 0) {
    // if (n2rn2.get(j) == n2rn1.get(i)) {
    // lca = n2rn2.get(j);
    // j--;
    // i--;
    // } else {
    // break;
    // }
    // }

    // return lca;
    // }

    public static Node findLCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node lc = findLCA(node.left, n1, n2);
        Node rc = findLCA(node.right, n1, n2);

        if (lc != null && rc != null) {
            return node;
        }

        if (lc != null) {
            return lc;
        }

        if (rc != null) {
            return rc;
        }

        return null;
    }
}