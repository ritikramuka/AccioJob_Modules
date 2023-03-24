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
        // base case: root == null, then size of tree is 0;
        if (root == null) {
            return 0;
        }

        int sizeOfLeftSubtree = sizeOfTree(root.left);

        int sizeOfRightSubtree = sizeOfTree(root.right);

        // size of the tree = (size of subtree) + (1 for root node) + (size of right
        // subtree)
        int size = sizeOfLeftSubtree + 1 + sizeOfRightSubtree;

        return size;
    }

    // TC: O(N), SC: O(H)
    public int sumOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int sumOfLeftSubtree = sumOfTree(root.left);

        int sumOfRightSubtree = sumOfTree(root.right);

        int totalSum = sumOfLeftSubtree + root.data + sumOfRightSubtree;

        return totalSum;
    }

    // TC: O(N), SC: O(H)
    public int maxOfTree(Node root) {
        // base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = maxOfTree(root.left);

        int rightMax = maxOfTree(root.right);

        // max {leftMax, root.data, rightMax}
        int overAllMax = Math.max(root.data, Math.max(leftMax, rightMax));

        return overAllMax;
    }

    // TC: O(N), SC: O(H)
    public int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int heightOfLeftSubtree = heightOfTree(root.left);

        int heightOfRightSubtree = heightOfTree(root.right);

        int heightOfTree = Math.max(heightOfLeftSubtree, heightOfRightSubtree) + 1;

        return heightOfTree;
    }
}