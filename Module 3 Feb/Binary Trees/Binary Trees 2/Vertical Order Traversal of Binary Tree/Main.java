import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    int maxOfPosition = 0;
    int minOfPosition = 0;

    void getWidth(TreeNode root, int pos) {
        if (root == null) {
            return;
        }

        getWidth(root.left, pos - 1);
        getWidth(root.right, pos + 1);

        maxOfPosition = Math.max(pos, maxOfPosition);
        minOfPosition = Math.min(pos, minOfPosition);

        return;
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int pos;

        Pair(TreeNode node, int pos) {
            this.pos = pos;
            this.node = node;
        }

        @Override 
        public int compareTo(Pair other) {
            if (this.pos == other.pos) {
                return this.node.data - other.node.data;
            }

            return this.pos - other.pos;
        }
    }

    List<List<Integer>> VerticalTraversal(TreeNode root) {
        // Write your code here
        getWidth(root, 0);
        int width = maxOfPosition - minOfPosition;

        int levels = width + 1;
        List<List<Integer>> vw = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            vw.add(new ArrayList<>());
        }

        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minOfPosition));

        while (Ppq.size() > 0) {
            int size = Ppq.size();

            PriorityQueue<Pair> Cpq = new PriorityQueue<>();

            while (size-- > 0) {
                Pair rpair = Ppq.remove();

                vw.get(rpair.pos).add(rpair.node.data);

                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.pos - 1));
                }

                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.pos + 1));
                }
            }

            Ppq = Cpq;
        }

        return vw;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for (int i = 0; i < ans.size(); i++) {
                for (int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            System.out.println();
            t--;
        }
    }
}