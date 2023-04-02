/*
    https://course.acciojob.com/idle?question=76db1218-3577-4e02-a32b-76210d6ddd97
**/ 

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            String X = br.readLine();
            String arr[] = X.split(" ");
            int x, y;
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            if (g.isCousins(root, x, y))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

class Solution {
    /*
     * two nodes to be cousins we need:
     * 1. both on same level
     * 2. diff parent
     **/

    // TC: O (N), SC: O(H)
    public Node getParent(Node root, int n) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.left.data == n) {
            return root;
        }

        if (root.right != null && root.right.data == n) {
            return root;
        }

        Node foundInLeft = getParent(root.left, n);
        if (foundInLeft != null) {
            return foundInLeft;
        }

        Node foundInRight = getParent(root.right, n);
        if (foundInRight != null) {
            return foundInRight;
        }

        return null;
    }

    // TC: O(N), SC: O(H)
    int level = 0;

    public void getLevel(Node root, int n, int l) {
        if (root == null) {
            return;
        }

        if (root.data == n) {
            level = l;
            return;
        }

        getLevel(root.left, n, l + 1);
        getLevel(root.right, n, l + 1);
    }

    // TC: O(N), SC: O(H)
    public boolean isCousins(Node root, int x, int y) {
        // Write code here
        Node p1 = getParent(root, x);
        Node p2 = getParent(root, y);

        getLevel(root, x, 0);
        int l1 = level;

        getLevel(root, y, 0);
        int l2 = level;

        if (l1 == l2 && p1 != p2) {
            return true;
        }

        return false;
    }
}