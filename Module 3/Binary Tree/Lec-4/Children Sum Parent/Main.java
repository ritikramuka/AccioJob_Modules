
//User function Template for Java

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Tree {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null) {
            return 1;
        }

        // if node is a leaf node then return true
        if (root.left == null && root.right == null) {
            return 1;
        }

        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.data;
        }
        if (root.right != null) {
            childSum += root.right.data;
        }

        int isFollowedInLeftSubTree = isSumProperty(root.left);
        int isFollowedInRightSubTree = isSumProperty(root.right);

        if (isFollowedInLeftSubTree == 0 || isFollowedInRightSubTree == 0 || childSum != root.data) {
            return 0;
        } else {
            return 1;
        }

    }
}