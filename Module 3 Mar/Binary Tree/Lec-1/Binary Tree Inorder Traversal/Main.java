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
    *   in order -> left subtree, print, right subtree 
    */

    public void inOrder (TreeNode root, List<Integer> in) {
        // base case: root == null -> do nothing, just return
        if (root == null) {
            return;
        }

        // step 1: call left subtree
        inOrder(root.left, in);

        // step 2: store root.val
        in.add(root.val);

        // step 3: call right subtree
        inOrder(root.right, in);
    }

    // TC: O(N), O(H) -> H is height of the tree
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);
        return in;
    }
}