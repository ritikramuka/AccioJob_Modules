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

    // public static int height(Node root) {
    // if (root == null)
    // return 0;

    // int lh = height(root.left);
    // int rh = height(root.right);

    // return Math.max(lh, rh) + 1;
    // }

    // public static int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int getMaxDiaOfLeftSubTree = diameter(root.left);

    // int getMaxDiaOfRightSubTree = diameter(root.right);

    // int lh = height(root.left);
    // int rh = height(root.right);
    // int diaTroughRoot = lh + rh + 1;

    // return Math.max(diaTroughRoot, Math.max(getMaxDiaOfLeftSubTree,
    // getMaxDiaOfRightSubTree));
    // }

    static class Pair {
        int diameter;
        int height;

        Pair() {
            height = 0;
            diameter = 0;
        }

        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Pair diameter_(Node root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftSubTree = diameter_(root.left);

        Pair righSubTree = diameter_(root.right);

        int diaThroughRoot = leftSubTree.height + righSubTree.height + 1;

        int myHeight = Math.max(leftSubTree.height, righSubTree.height) + 1;

        int myDiameter = Math.max(diaThroughRoot, Math.max(leftSubTree.diameter, righSubTree.diameter));

        return new Pair(myHeight, myDiameter);
    }

    public static int diameter(Node root) {
        Pair ans = diameter_(root);
        return ans.diameter;
    }
}