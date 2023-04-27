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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lo = new ArrayList<>();
        
        if (root == null) {
            return lo;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        
        while (que.size() != 0) {
            int size = que.size();
            
            List<Integer> currLevel = new ArrayList<>();
            
            while (size-->0) {
                TreeNode rnode = que.remove();
                
                currLevel.add(rnode.val);
                
                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
            }
            
            lo.add(currLevel);
        }
        
        return lo;
    }
}