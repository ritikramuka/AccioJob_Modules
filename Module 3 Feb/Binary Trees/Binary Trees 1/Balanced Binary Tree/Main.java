import java.util.*;

public class Main {

    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    // function to construct a BST from
    // its level order traversal
    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data)
            root.left = LevelOrder(root.left, data);
        else
            root.right = LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0)
            return null;
        Node root = null;

        for (int i = 0; i < n; i++)
            root = LevelOrder(root, arr[i]);

        return root;
    }

    // // height in terms of nodes
    // public static int heightOfTree(Node root) {
    // // base case
    // if (root == null) {
    // return 0;
    // }

    // // get height of left sub-tree
    // int leftHeight = heightOfTree(root.left);

    // // get height of right sub-tree
    // int rightHeight = heightOfTree(root.right);

    // // my height is max of height offered from left or right and add my node to
    // the
    // // height
    // int myHeight = Math.max(leftHeight, rightHeight) + 1;

    // return myHeight;
    // }

    // // TC: O(N^2), SC: O(h)
    // public static boolean isBalanced(Node root) {
    // // your code here
    // if (root == null) {
    // return true;
    // }

    // // get is my left sub-tree balanced
    // boolean isLeftBalanced = isBalanced(root.left);

    // // get is my right sub-tree balanced
    // boolean isRightBalanced = isBalanced(root.right);

    // // is my node balanced
    // int lh = heightOfTree(root.left);
    // int rh = heightOfTree(root.right);
    // boolean isNodeBalanced = Math.abs(lh - rh) <= 1 ? true : false;

    // // is tree balanced
    // if (isLeftBalanced == true && isRightBalanced == true && isNodeBalanced ==
    // true) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    static class Pair {
        boolean isBalanced;
        int height;

        Pair() {
            isBalanced = true;
            height = 0;
        }

        Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    // TC: O(N), SC: O(h)
    public static Pair isBalanced2(Node root) {
        // your code here
        if (root == null) {
            return new Pair();
        }

        Pair leftPair = isBalanced2(root.left);
        Pair rightPair = isBalanced2(root.right);

        int height = Math.max(leftPair.height, rightPair.height) + 1;

        boolean isNodeBalanced = Math.abs(leftPair.height - rightPair.height) <= 1 ? true : false;

        boolean isBalanced = false;
        if (leftPair.isBalanced == true && rightPair.isBalanced == true && isNodeBalanced == true) {
            isBalanced = true;
        }

        return new Pair(height, isBalanced);
    }

    public static boolean isBalanced(Node root) {
        // your code here
        Pair pair = isBalanced2(root);
        return pair.isBalanced;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        if (isBalanced(root))
            System.out.println("true");
        else
            System.out.println(
                    "false");
    }
}

class Node {
    int data;
    Node left, right;
}