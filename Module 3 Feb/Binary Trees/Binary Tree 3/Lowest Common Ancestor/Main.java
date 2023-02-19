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

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // static ArrayList<Node> n2r;

    // static boolean Node2Root(Node root, int val) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == val) {
    // n2r.add(root);
    // return true;
    // }

    // boolean filc = Node2Root(root.left, val);
    // if (filc == true) {
    // n2r.add(root);
    // return true;
    // }

    // boolean firc = Node2Root(root.right, val);
    // if (firc == true) {
    // n2r.add(root);
    // return true;
    // }

    // return false;
    // }

    // // TC: O(N), SC: O(N)
    // public static Node findLCA(Node node, int n1, int n2) {
    // // write code here
    // n2r = new ArrayList<>();
    // Node2Root(node, n1);
    // ArrayList<Node> n2rForn1 = n2r;

    // n2r = new ArrayList<>();
    // Node2Root(node, n2);
    // ArrayList<Node> n2rForn2 = n2r;

    // int i = n2rForn1.size() - 1;
    // int j = n2rForn2.size() - 1;
    // Node lca = new Node(0);

    // while (i >= 0 && j >= 0) {
    // if (n2rForn1.get(i) != n2rForn2.get(j)) {
    // break;
    // } else {
    // lca = n2rForn1.get(i);
    // i--;
    // j--;
    // }
    // }

    // return lca;
    // }

    // TC: O(N), SC: O(1)
    public static Node findLCA(Node node, int n1, int n2) {
        // write code here
        if (node == null) {
            return null;
        }

        if (node.data == n1) {
            return node;
        }

        if (node.data == n2) {
            return node;
        }

        Node foundAnyoneInLeft = findLCA(node.left, n1, n2);
        Node foundAnyoneInRight = findLCA(node.right, n1, n2);

        if (foundAnyoneInLeft != null && foundAnyoneInRight != null) {
            return node;
        }

        if (foundAnyoneInLeft != null) {
            return foundAnyoneInLeft;
        }

        if (foundAnyoneInRight != null) {
            return foundAnyoneInRight;
        }

        return null;
    }
}