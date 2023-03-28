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
    /*
        stack -> {Node, call}
        
        call == 1 -> call left side
        call == 2 -> call right side
        call == 3 -> remove from stack
    **/
    
    class Pair {
        TreeNode node;
        int call;
        
        Pair (TreeNode node, int call) {
            this.node = node;
            this.call = call;
        }
    }
    
    // TC: O(N), SC: O(H)    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        if (root == null) {
            return in;
        }
        
        Stack<Pair> callStack = new Stack<>();
        callStack.push(new Pair(root, 1));
        
        while (callStack.size() != 0) {
            Pair rpair = callStack.peek();
            
            if (rpair.call == 1) {
                // call left side
                if (rpair.node.left != null) {
                    callStack.push(new Pair(rpair.node.left, 1));
                }
                
                rpair.call = 2;
            } else if (rpair.call == 2) {
                in.add(rpair.node.val);
                
                // call right side
                if (rpair.node.right != null) {
                    callStack.push(new Pair(rpair.node.right, 1));
                }
                
                rpair.call = 3;
            } else if (rpair.call == 3) {
                callStack.pop();
            }
        }
        
        return in;
    }
}