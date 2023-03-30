import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    static class Pair {
        int maxPathSum;
        int bestPathToAttach;

        Pair(int bestPathToAttach, int maxPathSum) {
            this.bestPathToAttach = bestPathToAttach;
            this.maxPathSum = maxPathSum;
        }
    }

    static Pair maxPathSum_(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE);
        }

        Pair left = maxPathSum_(root.left);
        Pair right = maxPathSum_(root.right);

        int maxPathSumFromRoot = root.data;
        if (left.bestPathToAttach > 0) {
            maxPathSumFromRoot += left.bestPathToAttach;
        }
        if (right.bestPathToAttach > 0) {
            maxPathSumFromRoot += right.bestPathToAttach;
        }

        int overallMaxPathSum = Math.max(maxPathSumFromRoot, Math.max(left.maxPathSum, right.maxPathSum));

        int bestPathToAttach = root.data + Math.max(0, Math.max(right.bestPathToAttach, left.bestPathToAttach));

        return new Pair(bestPathToAttach, overallMaxPathSum);
    }

    // TC: O(N), SC: O(H)
    public static int maxPathSum(TreeNode root) {
        // Write your code
        return maxPathSum_(root).maxPathSum;
    }
}

class Main {
    public static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] nodes = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {

            TreeNode currNode = queue.poll();

            String currVal = nodes[i];

            if (!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= nodes.length)
                break;
            currVal = nodes[i];

            if (!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        int maxPath = Solution.maxPathSum(root);
        System.out.println(maxPath);
    }
}
