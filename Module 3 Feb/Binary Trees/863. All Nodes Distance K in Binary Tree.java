/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void getParent(TreeNode node, HashMap<TreeNode, TreeNode> parent) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            // I'm parent of this node.left
            parent.put(node.left, node);
        }

        if (node.right != null) {
            // I'm parent of this node.right
            parent.put(node.right, node);
        }

        getParent(node.left, parent);
        getParent(node.right, parent);
    }

    // TC: O(N), SC: O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // child -> parent
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        getParent(root, parent);

        // basic level order traversal, with childs and parent at a distance away
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(target);

        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);

        int level = 0;
        List<Integer> ans = new ArrayList<>();
        while (que.size() != 0) {
            int size = que.size();

            if (level == k) {
                while (que.size() != 0) {
                    ans.add(que.remove().val);
                }
                return ans;
            }

            while (size-- > 0) {
                TreeNode rnode = que.remove();

                // check left child
                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }

                // check right child
                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }

                // check parent
                if (parent.containsKey(rnode) == true && vis.contains(parent.get(rnode)) == false) {
                    que.add(parent.get(rnode));
                    vis.add(parent.get(rnode));
                }
            }

            level++;
        }

        return ans;
    }
}