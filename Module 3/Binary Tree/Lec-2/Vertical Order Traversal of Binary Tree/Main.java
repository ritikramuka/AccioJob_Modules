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
    int minLevel = 0;
    int maxLevel = 0;

    public void verticalLevels(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        verticalLevels(root.left, level - 1);
        verticalLevels(root.right, level + 1);

        minLevel = Math.min(level, minLevel);
        maxLevel = Math.max(level, maxLevel);
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
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

    public List<List<Integer>> VerticalTraversal(TreeNode root) {
        verticalLevels(root, 0);
        int width = maxLevel - minLevel;
        int numberOfLevels = width + 1;

        List<List<Integer>> vo = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            vo.add(new ArrayList<>());
        }

        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minLevel));

        while (Ppq.size() > 0) {
            int size = Ppq.size();

            PriorityQueue<Pair> Cpq = new PriorityQueue<>();
            while (size > 0) {
                Pair rpair = Ppq.remove();

                vo.get(rpair.vLevel).add(rpair.node.data);

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
            System.out.println();
            t--;
        }
    }
}