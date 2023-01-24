import java.util.*;

class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // map -> child : parent
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(target);

        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);

        List<Integer> list = new ArrayList<>();

        while (que.size() != 0) {
            int size = que.size();

            if (k == 0) {
                while (que.size() != 0) {
                    list.add(que.remove().val);
                }
                return list;
            }

            while (size > 0) {
                TreeNode rnode = que.remove();

                // add left child if available
                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    vis.add(rnode.left);
                    que.add(rnode.left);
                }

                // add right child if available
                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    vis.add(rnode.right);
                    que.add(rnode.right);
                }

                // add parent id available
                if (parent.getOrDefault(rnode, null) != null && vis.contains(parent.get(rnode)) == false) {
                    vis.add(parent.get(rnode));
                    que.add(parent.get(rnode));
                }

                size--;
            }

            k--;
        }

        return list;
    }

    void findParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            // I have a left child
            parent.put(root.left, root);
        }

        if (root.right != null) {
            // I have a righ child
            parent.put(root.right, root);
        }

        findParent(root.left, parent);
        findParent(root.right, parent);
    }
}