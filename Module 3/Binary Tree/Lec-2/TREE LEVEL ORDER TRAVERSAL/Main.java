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
        // step 1: add root
        que.add(root);

        // step 2: do your work till que size is greater than zero
        while (que.size() > 0) {
            // step 3: get curr size of the que
            int size = que.size();

            // step 4: remove size amt of fronts from the que and add there chilren, these
            // size amt of people will lie on same level
            while (size > 0) {
                TreeNode rnode = que.remove();
                System.out.print(rnode.val + " ");

                // step 5: see if children are there, add them
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