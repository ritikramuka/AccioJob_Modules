
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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> ans = tree.bottomView(root);

            for (Integer num : ans)
                System.out.print(num + " ");

            System.out.println();
        }
    }
}

class Solution {
    int maxOfPosition = 0;
    int minOfPosition = 0;

    void getWidth(Node root, int pos) {
        if (root == null) {
            return;
        }

        getWidth(root.left, pos - 1);
        getWidth(root.right, pos + 1);

        maxOfPosition = Math.max(pos, maxOfPosition);
        minOfPosition = Math.min(pos, minOfPosition);

        return;
    }

    class Pair {
        Node node;
        int pos;

        Pair(Node node, int pos) {
            this.pos = pos;
            this.node = node;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        // Your code here
        getWidth(root, 0);
        int width = maxOfPosition - minOfPosition;

        int levels = width + 1;
        ArrayList<Integer> bv = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            bv.add(0);
        }

        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(root, -minOfPosition));

        while (pq.size() > 0) {
            int size = pq.size();

            while (size-- > 0) {
                Pair rpair = pq.remove();

                bv.set(rpair.pos, rpair.node.data);

                if (rpair.node.left != null) {
                    pq.add(new Pair(rpair.node.left, rpair.pos - 1));
                }

                if (rpair.node.right != null) {
                    pq.add(new Pair(rpair.node.right, rpair.pos + 1));
                }
            }
        }

        return bv;
    }
}
