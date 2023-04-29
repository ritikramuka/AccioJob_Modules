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
    class Pair {
        TreeNode node;
        int state;
        
        Pair (TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    /*
    * state 0 -> call left side
    * state 1 -> print
    * state 2 -> call rigth side
    **/
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        if (root == null) return in;
        
        Stack<Pair> callStack = new Stack<>();
        callStack.push(new Pair(root, 0));
        
        while (callStack.size() != 0) {
            Pair rpair = callStack.pop();
            
            if (rpair.state == 0) {
                callStack.push(new Pair(rpair.node, 1));
                if (rpair.node.left != null) {
                    callStack.push(new Pair(rpair.node.left, 0));
                }
            } else if (rpair.state == 1) {
                in.add(rpair.node.val);
                callStack.push(new Pair(rpair.node, 2));
            } else if (rpair.state == 2) {
                callStack.push(new Pair(rpair.node, 3));
                if (rpair.node.right != null) {
                    callStack.push(new Pair(rpair.node.right, 0));
                }
            }
        }
        
        return in;
    }
}