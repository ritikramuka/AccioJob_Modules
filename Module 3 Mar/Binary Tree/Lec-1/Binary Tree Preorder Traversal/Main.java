/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
    * pre -> print, left, right
    */ 

    public void preOrder (TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }

        // step 1: store root.val
        pre.add(root.val);

        // step 2: call left subtree
        preOrder(root.left, pre);

        // step 3: call right subtree
        preOrder(root.right, pre);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preOrder (root, pre);
        return pre;
    }
}