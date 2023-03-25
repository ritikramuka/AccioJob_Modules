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

    // static int height(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // return Math.max(height(root.left), height(root.right)) + 1;
    // }

    // // TC: O(N^2), SC: O(H)
    // public static boolean isBalanced(Node root) {
    // // your code here
    // if (root == null) {
    // return true;
    // }

    // boolean isLeftBalanced = isBalanced(root.left);

    // boolean isRightBalanced = isBalanced(root.right);

    // int lh = height(root.left);
    // int rh = height(root.right);

    // boolean isRootBalanced = false;
    // if (Math.abs(lh - rh) <= 1) {
    // isRootBalanced = true;
    // }

    // if (isLeftBalanced == true && isRightBalanced == true && isRootBalanced ==
    // true) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    static class Pair {
        boolean isBalanced;
        int height;

        Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    // TC: O(N), SC: O(H)
    static Pair isBalanced_(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair left = isBalanced_(root.left);

        Pair right = isBalanced_(root.right);

        int lh = left.height;
        int rh = right.height;
        boolean isRootBalanced = false;
        if (Math.abs(lh - rh) <= 1) {
            isRootBalanced = true;
        }

        int height = Math.max(lh, rh) + 1;

        if (isRootBalanced == true && left.isBalanced == true && right.isBalanced == true) {
            return new Pair(true, height);
        } else {
            return new Pair(false, height);
        }
    }

    public static boolean isBalanced(Node root) {
        // your code here
        Pair ans = isBalanced_(root);
        return ans.isBalanced;
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