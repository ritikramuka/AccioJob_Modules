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
    int minLevel;
    int maxLevel;

    public void verticalLevels(Node root, int level) {
        if (root == null) {
            return;
        }

        verticalLevels(root.left, level - 1);
        verticalLevels(root.right, level + 1);

        minLevel = Math.min(level, minLevel);
        maxLevel = Math.max(level, maxLevel);
    }

    class Pair implements Comparable<Pair> {
        Node node;
        int vLevel;

        Pair(Node node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.vLevel == o.vLevel) {
                return this.node.data - o.node.data;
            }

            return this.vLevel - o.vLevel;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        // Write Code here
        minLevel = 0;
        maxLevel = 0;
        verticalLevels(root, 0);
        int width = maxLevel - minLevel;
        int numberOfLevels = width + 1;

        ArrayList<Integer> tv = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            tv.add(Integer.MIN_VALUE);
        }

        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minLevel));

        while (Ppq.size() > 0) {
            int size = Ppq.size();

            PriorityQueue<Pair> Cpq = new PriorityQueue<>();
            while (size > 0) {
                Pair rpair = Ppq.remove();

                if (tv.get(rpair.vLevel) == Integer.MIN_VALUE) {
                    tv.set(rpair.vLevel, rpair.node.data);
                }

                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
                }

                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
                }

                size--;
            }

            Ppq = Cpq;
        }

        return tv;
    }
}
