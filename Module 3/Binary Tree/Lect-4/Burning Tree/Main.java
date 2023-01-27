import java.util.*;

class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void getParent(Node root, HashMap<Node, Node> parent) {
        if (root == null)
            return;

        if (root.left != null) {
            parent.put(root.left, root);
        }

        if (root.right != null) {
            parent.put(root.right, root);
        }

        getParent(root.left, parent);
        getParent(root.right, parent);
    }

    public static Node findTarget(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            return root;
        }

        Node filc = findTarget(root.left, target);
        if (filc != null) {
            return filc;
        }

        Node firc = findTarget(root.right, target);
        if (firc != null) {
            return firc;
        }

        return null;
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        getParent(root, parent);

        Node targetNode = findTarget(root, target);

        Queue<Node> que = new ArrayDeque<>();
        que.add(targetNode);

        HashSet<Node> burned = new HashSet<>();
        burned.add(targetNode);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && burned.contains(rnode.left) == false) {
                    burned.add(rnode.left);
                    que.add(rnode.left);
                }

                if (rnode.right != null && burned.contains(rnode.right) == false) {
                    burned.add(rnode.right);
                    que.add(rnode.right);
                }

                if (parent.getOrDefault(rnode, null) != null && burned.contains(parent.get(rnode)) == false) {
                    burned.add(parent.get(rnode));
                    que.add(parent.get(rnode));
                }

                size--;
            }
            level++;
        }

        return level - 1;
    }
}