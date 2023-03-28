import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrderTraversal(TreeNode root, StringBuilder pre) {
        if (root == null) {
            pre.append("null,");
            return;
        }

        // here is pre-order
        pre.append(root.val + ",");

        // call left
        preOrderTraversal(root.left, pre);

        // call right
        preOrderTraversal(root.right, pre);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        // Write code here

        StringBuilder pre = new StringBuilder("");
        preOrderTraversal(root, pre);

        return pre.toString();
    }

    static int idx = 0;

    public static TreeNode buildTree(String[] arr) {
        if (idx == arr.length) {
            return null;
        }

        if (arr[idx].equals("null") == true) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        idx++;

        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        // Write code here
        String[] arr = str.split(",");
        TreeNode root = buildTree(arr);
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}