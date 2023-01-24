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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution {

    class Pair {
        Node node;
        int idx;

        Pair(Node node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int solve(Node root) {
        // your code here
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root, 1));

        int width = 0;

        while (que.size() != 0) {
            int size = que.size();

            int minIdx = Integer.MAX_VALUE;
            int maxIdx = Integer.MIN_VALUE;

            while (size > 0) {
                Pair rpair = que.remove();

                minIdx = Math.min(minIdx, rpair.idx);
                maxIdx = Math.max(maxIdx, rpair.idx);

                if (rpair.node.left != null) {
                    que.add(new Pair(rpair.node.left, 2 * rpair.idx));
                }

                if (rpair.node.right != null) {
                    que.add(new Pair(rpair.node.right, 2 * rpair.idx + 1));
                }

                size--;
            }

            int currWidth = maxIdx - minIdx + 1;
            width = Math.max(currWidth, width);
        }

        return width;
    }
}
