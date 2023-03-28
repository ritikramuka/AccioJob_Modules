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
    public TreeNode construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
        if (psi > pei) {
            return null;
        }
        
        if (isi > iei) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[psi]);
        
        int i = isi;
        int cntNumberOfNodesInLeftSubtree = 0;
        while (in[i] != root.val) {
            i++;
            cntNumberOfNodesInLeftSubtree++;
        }
        
        root.left = construct(pre, psi + 1, psi + cntNumberOfNodesInLeftSubtree, in, isi, i - 1);
        root.right = construct(pre, psi + cntNumberOfNodesInLeftSubtree + 1, pei, in, i + 1, iei);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}