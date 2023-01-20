import java.util.Scanner;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode constructBinaryTree() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Print value of the node");
        int val = scn.nextInt();
        TreeNode root = new TreeNode(val);

        if (val == -1) {
            return null;
        }

        System.out.println("Enter my left tree root");
        root.left = constructBinaryTree();

        System.out.println("Enter my right tree root");
        root.right = constructBinaryTree();

        return root;
    }

    public static void poTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val + " ");
        poTraversal(root.left);
        poTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = constructBinaryTree();
        poTraversal(root);
    }
}
