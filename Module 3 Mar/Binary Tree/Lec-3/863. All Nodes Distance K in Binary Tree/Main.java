/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void findParent(TreeNode root, HashMap<TreeNode, TreeNode>  getParent) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			getParent.put(root.left, root);
		}

		if (root.right != null) {
			getParent.put(root.right, root);
		}

		findParent(root.left, getParent);
		findParent(root.right, getParent);
	}

    // TC: O(N), SC: O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
			return new ArrayList<>();
		}
		
		// child -> parent
		HashMap<TreeNode, TreeNode>  getParent = new HashMap<>();
		findParent(root, getParent);

		HashSet<TreeNode> vis = new HashSet<>();
		Queue<TreeNode> que = new ArrayDeque<>();
		vis.add(target);
		que.add(target);
		int level = 0;

		while (que.size() != 0) {
			int size = que.size();
            
            if (level == k) {
				List<Integer> ans = new ArrayList<>();
				while (que.size() != 0) {
					ans.add(que.remove().val);
				}
				return ans;
			}
            
			while (size-->0) {
				TreeNode rnode = que.remove();

				if (rnode.left != null && vis.contains(rnode.left) == false) {
					vis.add(rnode.left);
					que.add(rnode.left);
				}

				if (rnode.right != null && vis.contains(rnode.right) == false) {
					vis.add(rnode.right);
					que.add(rnode.right);
				}

				if (getParent.containsKey(rnode) == true && vis.contains(getParent.get(rnode)) == false) {
					vis.add(getParent.get(rnode));
					que.add(getParent.get(rnode));
				}
			}
			level++;
		}

		return new ArrayList<>();
    }
}