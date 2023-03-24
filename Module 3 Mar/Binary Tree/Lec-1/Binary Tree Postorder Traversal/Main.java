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
    *   post order -> left subtree, right subtree, print
    */
    public void postOrder (TreeNode root, List<Integer> post) {
        // base case: root == null, then do nothing, just return
        if (root == null) {
            return;
        }

        // step 1: call left subtree
        postOrder(root.left, post);

        // step 2: call right subtree
        postOrder(root.right, post);

        // step 3: store root val
        post.add(root.val);
    }

    // TC: O(N) -> N is Number of nodes in the Tree, 
    // SC: O(H) -> H is height of Tree
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList();
        postOrder(root, post);
        return post;
    }
}