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

    static class Pair {
        boolean isBalanced;
        int height;

        Pair() {
            isBalanced = true;
            height = 0;
        }

        Pair(int h, boolean iB) {
            isBalanced = iB;
            height = h;
        }
    }

    public static Pair isBalanced_(Node root) {
        // your code here
        if (root == null) {
            return new Pair();
        }

        Pair leftSubTree = isBalanced_(root.left);

        Pair rightSubTree = isBalanced_(root.right);

        int diff = Math.abs(leftSubTree.height - rightSubTree.height);

        if (diff > 1 || leftSubTree.isBalanced == false || rightSubTree.isBalanced == false) {
            return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, false);
        } else {
            return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, true);
        }
    }

    public static boolean isBalanced(Node root) {
        // your code here
        Pair ans = isBalanced_(root);
        return ans.isBalanced;
    }

    // TC: O(N*N)
    // public static boolean isBalanced(Node root) {
    // // your code here
    // if (root == null) {
    // return true;
    // }

    // // is left sub-tree balanced
    // boolean isLeftBalanced = isBalanced(root.left);

    // // is right sub-tree balanced
    // boolean isRightBalanced = isBalanced(root.right);

    // // check am I balanced
    // int lh = height(root.left);
    // int rh = height(root.right);
    // int diff = Math.abs(lh - rh);

    // boolean ImBalanced = false;
    // if (diff <= 1) {
    // ImBalanced = true;
    // }

    // if (isLeftBalanced == false || isRightBalanced == false || ImBalanced ==
    // false) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    // public static int height(Node root) {
    // if (root == null)
    // return 0;

    // int lh = height(root.left);
    // int rh = height(root.right);

    // return Math.max(lh, rh) + 1;
    // }

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