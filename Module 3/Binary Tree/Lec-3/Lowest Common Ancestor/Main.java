import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.net.Inet4Address;
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
    // static ArrayList<Node> path;

    // public static boolean NodeToRootPath(Node root, int tar) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == tar) {
    // path.add(root);
    // return true;
    // }

    // // find in left child
    // boolean filc = NodeToRootPath(root.left, tar);
    // if (filc == true) {
    // path.add(root);
    // return true;
    // }

    // // find in right child
    // boolean firc = NodeToRootPath(root.right, tar);
    // if (firc == true) {
    // path.add(root);
    // return true;
    // }

    // // I was not the target, not found in left child niether in right child
    // return false;
    // }

    // public static ArrayList<Node> RootToNodePathFunc(Node root, int b) {
    // // your code here
    // path = new ArrayList<>();
    // boolean ans = NodeToRootPath(root, b);

    // // root to node path
    // Collections.reverse(path);
    // return path;
    // }

    // // TC: O(N) , SC: O(N)
    // public static Node findLCA(Node node, int n1, int n2) {
    // // write code here
    // ArrayList<Node> list1 = RootToNodePathFunc(node, n1);
    // ArrayList<Node> list2 = RootToNodePathFunc(node, n2);

    // int i = 0;
    // int j = 0;

    // Node lca = new Node(-1);
    // while (i < list1.size() && j < list2.size() && list1.get(i) == list2.get(j))
    // {
    // lca = list1.get(i);
    // i++;
    // j++;
    // }

    // return lca;
    // }

    // TC: O(N), SC: O(1)
    public static Node findLCA(Node node, int n1, int n2) {
        // write code here
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node findOneInLeft = findLCA(node.left, n1, n2);
        Node findOneInRight = findLCA(node.right, n1, n2);

        if (findOneInLeft != null && findOneInRight != null) {
            return node;
        }

        if (findOneInLeft != null) {
            return findOneInLeft;
        } else if (findOneInRight != null) {
            return findOneInRight;
        } else {
            return null;
        }
    }
}