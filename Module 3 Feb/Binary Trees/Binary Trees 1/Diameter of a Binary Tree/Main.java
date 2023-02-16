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

    // // TC: O(N), SC: O(h)
    // // height in terms of nodes
    // public static int heightOfTree(Node root) {
    // // base case
    // if (root == null) {
    // return 0;
    // }

    // // get height of left sub-tree
    // int leftHeight = heightOfTree(root.left);

    // // get height of right sub-tree
    // int rightHeight = heightOfTree(root.right);

    // // my height is max of height offered from left or right and add my node to
    // the
    // // height
    // int myHeight = Math.max(leftHeight, rightHeight) + 1;

    // return myHeight;
    // }

    // // TC: O(N^2), SC: O(h)
    // public static int diameter(Node root) {
    // // Your code here
    // if (root == null) {
    // return 0;
    // }

    // // get maximum diamter present in left-subtree
    // int maxDiaInLeft = diameter(root.left);

    // // get maximum diamter present in right-subtree
    // int maxDiaInRight = diameter(root.right);

    // // my diamter = height of left sub-tree + 1 + height of right sub-tree
    // int myDia = heightOfTree(root.left) + 1 + heightOfTree(root.right);

    // // diameter of the tree, max of diameter from left sub-tree, diameter passing
    // through root, diameter from left sub-tree
    // return Math.max(myDia, Math.max(maxDiaInLeft, maxDiaInRight));
    // }

    static class Pair {
        int dia;
        int height;

        Pair() {
            dia = 0;
            height = 0;
        }

        Pair(int height, int diameter) {
            this.dia = diameter;
            this.height = height;
        }
    }

    // TC: O(N), SC: O(h)
    public static Pair diamter2(Node root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftPair = diamter2(root.left);
        Pair rightPair = diamter2(root.right);

        int height = Math.max(leftPair.height, rightPair.height) + 1;

        int diaMeterPassingThroughtMe = leftPair.height + 1 + rightPair.height;
        int dia = Math.max(diaMeterPassingThroughtMe, Math.max(leftPair.dia, rightPair.dia));

        return new Pair(height, dia);
    }

    public static int diameter(Node root) {
        // Your code here
        Pair pair = diamter2(root);
        return pair.dia;
    }
}