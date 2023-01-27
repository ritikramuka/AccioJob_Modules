class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        int maxPathSum = 0;
        int sum = 0;

        Pair(int sum, int maxPathSum) {
            this.sum = sum;
            this.maxPathSum = maxPathSum;
        }
    }

    public Pair BestPathSum(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE);
        }

        Pair LeftPair = BestPathSum(root.left);
        Pair RightPair = BestPathSum(root.right);

        int bestPathSumFromLeft = Math.max(LeftPair.sum, 0);
        int bestPathSumFromRight = Math.max(RightPair.sum, 0);
        int currMaxPathSum = bestPathSumFromLeft + root.val + bestPathSumFromRight;

        int overallMaxPathSum = Math.max(currMaxPathSum, Math.max(LeftPair.maxPathSum, RightPair.maxPathSum));

        return new Pair(Math.max(bestPathSumFromLeft + root.val, bestPathSumFromRight + root.val), overallMaxPathSum);
    }

    public int maxPathSum(TreeNode root) {
        return BestPathSum(root).maxPathSum;
    }
}