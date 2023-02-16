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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
    // TC: O(N), SC: O(H)
    public int sizeOfTree(Node root) {
        // base case
        // if root == null then size = 0
        if (root == null) {
            return 0;
        }

        // get size of left sub-tree
        int sizeOfLeftSubTree = sizeOfTree(root.left);

        // get size of right sub-tree
        int sizeOfRightSubTree = sizeOfTree(root.right);

        // size of tree = size of left sub-tree + 1 for my node + size of right sub-tree
        int size = sizeOfLeftSubTree + 1 + sizeOfRightSubTree;

        return size;
    }

    // TC: O(N), SC: O(h)
    public int sumOfTree(Node root) {
        // base case
        // if root == null, then sum = 0;
        if (root == null) {
            return 0;
        }

        // get sum of all the nodes in left sub-tree
        int leftTreeSum = sumOfTree(root.left);

        // get sum of all the nodes in right sub-tree
        int rightTreeSum = sumOfTree(root.right);

        // total sum of the tree = sum of all nodes in left sub-tree + my value + sum of
        // all nodes in right sub-tree
        int totalSum = leftTreeSum + root.data + rightTreeSum;

        return totalSum;
    }

    // TC: O(N), SC: O(h)
    public int maxOfTree(Node root) {
        // base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // get maximum value in left sub-tree
        int lmax = maxOfTree(root.left);

        // get maximum value in right sub-tree
        int rmax = maxOfTree(root.right);

        // overall maximum in this tree, maximum from left sub-tree, my value, right
        // sub-tree
        int overallMax = Math.max(root.data, Math.max(lmax, rmax));

        return overallMax;
    }

    // TC: O(N), SC: O(h)
    // height in terms of nodes
    public int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // get height of left sub-tree
        int leftHeight = heightOfTree(root.left);

        // get height of right sub-tree
        int rightHeight = heightOfTree(root.right);

        // my height is max of height offered from left or right and add my node to the
        // height
        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }

    // TC: O(N), SC: O(h)
    // height in terms of edges
    // public int heightOfTree(Node root) {
    //     // base case
    //     if (root == null) {
    //         return -1;
    //     }

    //     // get height of left sub-tree
    //     int leftHeight = heightOfTree(root.left);

    //     // get height of right sub-tree
    //     int rightHeight = heightOfTree(root.right);

    //     // my height is max of height offered from left or right and add my node to the
    //     // height
    //     int myHeight = Math.max(leftHeight, rightHeight) + 1;

    //     return myHeight;
    // }
}