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
     * call 0 -> left
     * call 1 -> right
     * call 2 -> remove
     */

    class Pair {
        TreeNode node;
        int call;

        Pair(TreeNode node, int call) {
            this.node = node;
            this.call = call;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root == null) return pre;
        Stack<Pair> callStack = new Stack<>();
        callStack.push(new Pair(root, 0));
        while (callStack.size() > 0) {
            Pair top = callStack.peek();
            if (top.call == 0) {
                top.call++;

                // as pre order print before left call
                pre.add(top.node.val);

                if (top.node.left != null) {
                    callStack.push(new Pair(top.node.left, 0));
                }
            } else if (top.call == 1) {
                top.call++;

                // in.add(top.node.val);
                
                if (top.node.right != null) {
                    callStack.push(new Pair(top.node.right, 0));
                }
            } else {
                // post.add(tope.node.val); 

                callStack.pop();
            }
        }
        return pre;
    }
}