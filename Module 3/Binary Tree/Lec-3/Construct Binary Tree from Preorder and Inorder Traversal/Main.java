class Main {
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

    TreeNode constructTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei) {
            return null;
        }

        if (isi > iei) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[psi]);

        int val = preorder[psi];
        int itr = isi;
        int cntElements = 0;
        while (inorder[itr] != val) {
            cntElements++;
            itr++;
        }

        root.left = constructTree(preorder, psi + 1, psi + cntElements, inorder, isi, itr - 1);
        root.right = constructTree(preorder, psi + cntElements + 1, pei, inorder, itr + 1, iei);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}