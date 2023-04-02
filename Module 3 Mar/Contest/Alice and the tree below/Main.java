/**
 * https://course.acciojob.com/idle?question=7b65cbf3-7b9a-4a16-a8f9-5d419cdfb0a9
 */
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

class Solution {
    /*
     * top view:
     * - do vo traversal
     * - and get first node of each vLevel
     **/

    int minPos = 0;
    int maxPos = 0;

    void getPos(Node root, int pos) {
        if (root == null) {
            return;
        }

        minPos = Math.min(minPos, pos);
        maxPos = Math.max(maxPos, pos);

        getPos(root.left, pos - 1);
        getPos(root.right, pos + 1);
    }

    class Pair {
        Node node;
        int vLevel;

        Pair(Node node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        // Write Code here

        getPos(root, 0);

        int width = maxPos - minPos + 1;

        ArrayList<Integer> tv = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            tv.add(-1);
        }

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root, -minPos));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rpair = que.remove();

                if (tv.get(rpair.vLevel) == -1) {
                    tv.set(rpair.vLevel, rpair.node.data);
                }

                if (rpair.node.left != null) {
                    que.add(new Pair(rpair.node.left, rpair.vLevel - 1));
                }

                if (rpair.node.right != null) {
                    que.add(new Pair(rpair.node.right, rpair.vLevel + 1));
                }
            }
        }

        return tv;
    }
}