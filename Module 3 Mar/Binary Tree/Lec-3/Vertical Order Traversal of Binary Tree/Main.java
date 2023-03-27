import java.util.LinkedList;
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

    int minIdx = Integer.MAX_VALUE;
    int maxIdx = Integer.MIN_VALUE;

    void getIndex(TreeNode root, int idx) {
        if (root == null) {
            return;
        }

        minIdx = Math.min(minIdx, idx);
        maxIdx = Math.max(maxIdx, idx);

        getIndex(root.left, idx - 1);
        getIndex(root.right, idx + 1);
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.vLevel == other.vLevel) {
                return this.node.data - other.node.data;
            } else {
                // this - other gives default behaviour
                return this.vLevel - other.vLevel;
            }
        }
    }

    List<List<Integer>> VerticalTraversal(TreeNode root) {
        // Write your code here

        // step 1: get index of leftmost node and rightmost node, by putting root at 0th
        // idx
        getIndex(root, 0);

        int numberOfLevels = maxIdx - minIdx + 1;

        List<List<Integer>> vo = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            vo.add(new ArrayList<>());
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root, -minIdx));

        while (pq.size() != 0) {
            int size = pq.size();
            PriorityQueue<Pair> Cpq = new PriorityQueue<>();
            while (size-- > 0) {
                Pair rpair = pq.remove();
                vo.get(rpair.vLevel).add(rpair.node.data);

                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
                }

                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
                }
            }
            pq = Cpq;
        }

        return vo;
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
            // System.out.println();
            t--;
        }
    }
}