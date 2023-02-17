import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BST {
    TreeNode root;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // System.out.println("inside insert fn");
        if (root == null) {
            this.root = new TreeNode(val);
            return this.root;
        }

        TreeNode temp = root;
        while (root != null) {
            if (val > root.val) {
                if (root.right != null)
                    root = root.right;
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else if (val < root.val) {
                if (root.left != null)
                    root = root.left;
                else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }

        return temp;
    }

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (que.size() != 0) {
            int size = que.size();

            while (size > 0) {
                TreeNode rnode = que.remove();

                System.out.print(rnode.val + " ");

                if (rnode.left != null) {
                    que.add(rnode.left);
                }

                if (rnode.right != null) {
                    que.add(rnode.right);
                }

                size--;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BST bt = new BST();
        for (int i = 0; i < n; i++) {
            bt.root = bt.insertIntoBST(bt.root, sc.nextInt());
        }
        bt.levelOrderTraversal(bt.root);
    }
}