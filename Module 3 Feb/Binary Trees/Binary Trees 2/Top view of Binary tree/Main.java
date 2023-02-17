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
            ArrayList<Integer> arr = tree.topView(root);
            for (int x : arr)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

class qObj {
    Node node;
    int level;

    qObj(Node n, int l) {
        node = n;
        level = l;
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

    public ArrayList<Integer> topView(Node root) {
        // Write Code here
        getWidth(root, 0);
        int width = maxOfPosition - minOfPosition;

        int levels = width + 1;
        ArrayList<Integer> tv = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            tv.add(null);
        }

        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(root, -minOfPosition));

        while (pq.size() > 0) {
            int size = pq.size();

            while (size-- > 0) {
                Pair rpair = pq.remove();

                if (tv.get(rpair.pos) == null) {
                    tv.set(rpair.pos, rpair.node.data);
                }

                if (rpair.node.left != null) {
                    pq.add(new Pair(rpair.node.left, rpair.pos - 1));
                }

                if (rpair.node.right != null) {
                    pq.add(new Pair(rpair.node.right, rpair.pos + 1));
                }
            }
        }

        return tv;
    }
}
