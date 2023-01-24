import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
            if (i >= ip.length)
                break;
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int b = sc.nextInt();
        Node root = buildTree(s);
        Solution tree = new Solution();
        ArrayList<Integer> ans = tree.solve(root, b);
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");

        System.out.println();

        sc.close();
    }
}

class Solution {

    // public boolean find(Node root, int tar) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == tar) {
    // return true;
    // }

    // // find in left child
    // boolean filc = find(root.left, tar);
    // if (filc == true) {
    // return true;
    // }

    // // find in right child
    // boolean firc = find(root.right, tar);
    // if (firc == true) {
    // return true;
    // }

    // // I was not the target, not found in left child niether in right child
    // return false;
    // }

    ArrayList<Integer> path;

    public boolean NodeToRootPath(Node root, int tar) {
        if (root == null) {
            return false;
        }

        if (root.data == tar) {
            path.add(root.data);
            return true;
        }

        // find in left child
        boolean filc = NodeToRootPath(root.left, tar);
        if (filc == true) {
            path.add(root.data);
            return true;
        }

        // find in right child
        boolean firc = NodeToRootPath(root.right, tar);
        if (firc == true) {
            path.add(root.data);
            return true;
        }

        // I was not the target, not found in left child niether in right child
        return false;
    }

    public ArrayList<Integer> solve(Node root, int b) {
        // your code here
        path = new ArrayList<>();
        boolean ans = NodeToRootPath(root, b);

        // root to node path
        Collections.reverse(path);
        return path;
    }
}