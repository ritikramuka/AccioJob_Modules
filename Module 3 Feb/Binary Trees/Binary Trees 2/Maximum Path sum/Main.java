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

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution tr = new Solution();
            int sum = tr.findMaxSum(root);
            System.out.println(sum);
        }
    }
}

class Solution {
    class Pair {
        int maxPathSum;
        int bestPath;

        Pair() {
            this.maxPathSum = 0;
            this.bestPath = 0;
        }

        Pair(int maxPathSum, int bestPath) {
            this.maxPathSum = maxPathSum;
            this.bestPath = bestPath;
        }
    }

    // TC: O(N), SC: O(h)
    Pair findMaxSum2(Node node) {
        if (node == null) {
            return new Pair();
        }

        Pair leftPair = findMaxSum2(node.left);
        Pair righPair = findMaxSum2(node.right);

        int PathSumFromMe = node.data;
        if (leftPair.bestPath > 0) {
            PathSumFromMe += leftPair.bestPath;
        }
        if (righPair.bestPath > 0) {
            PathSumFromMe += righPair.bestPath;
        }

        return new Pair(Math.max(PathSumFromMe, Math.max(leftPair.maxPathSum, righPair.maxPathSum)),
                Math.max(leftPair.bestPath, Math.max(righPair.bestPath, 0)) + node.data);
    }

    int findMaxSum(Node node) {
        // Write code here
        return findMaxSum2(node).maxPathSum;
    }
}