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

    static void serialize(TreeNode root, StringBuilder pre) {
        if (root == null) {
            pre.append("null,");
            return;
        }

        pre.append(root.val + ",");

        serialize(root.left, pre);

        serialize(root.right, pre);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        // Write code here
        StringBuilder sb = new StringBuilder("");
        serialize(root, sb);
        return sb.toString();
    }

    static int idx;

    static TreeNode deserialize(String[] arr) {
        if (idx == arr.length) {
            return null;
        }

        if (arr[idx].equals("null")) {
            idx++;
            return null;
        }

        int val = Integer.parseInt(arr[idx]);
        idx++;
        TreeNode root = new TreeNode(val);

        root.left = deserialize(arr);
        root.right = deserialize(arr);

        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        // Write code here
        idx = 0;
        String[] arr = str.split(",");
        return deserialize(arr);
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