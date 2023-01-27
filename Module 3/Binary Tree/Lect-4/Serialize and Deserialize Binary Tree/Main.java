public class Main {

    public class TreeNode {
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

    // Encodes a tree to a single string.
    public void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");

        encode(root.left, sb);
        encode(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    int idx = 0;

    public TreeNode decode(String[] input) {
        String data = input[idx];
        idx++;

        if (idx == input.length) {
            return null;
        }

        if (data.equals("null") == true) {
            return null;
        }

        int val = Integer.parseInt(data);
        TreeNode root = new TreeNode(val);

        root.left = decode(input);
        root.right = decode(input);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        return decode(input);
    }
}
