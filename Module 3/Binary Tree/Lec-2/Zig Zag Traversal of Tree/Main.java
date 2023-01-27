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
        g.binaryTreeZigZagTraversal(root1);
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
    public static void binaryTreeZigZagTraversal(Node root) {
        // Your code here
        // if no root, hence return empty List
        if (root == null) {
            return;
        }

        Queue<Node> que = new ArrayDeque<>();
        // step 1: add root
        que.add(root);
        int level = 0;

        // step 2: do your work till que size is greater than zero
        while (que.size() > 0) {
            // step 3: get curr size of the que
            int size = que.size();
            List<Integer> currLevel = new ArrayList<>();

            // step 4: remove size amt of fronts from the que and add there chilren, these
            // size amt of people will lie on same level
            while (size > 0) {
                Node rnode = que.remove();
                currLevel.add(rnode.data);

                // step 5: see if children are there, add them
                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                if (rnode.right != null) {
                    que.add(rnode.right);
                }

                size--;
            }

            if (level % 2 != 0) {
                Collections.reverse(currLevel);
            }
            for (int val : currLevel) {
                System.out.print(val + " ");
            }

            level++;
        }
    }
}