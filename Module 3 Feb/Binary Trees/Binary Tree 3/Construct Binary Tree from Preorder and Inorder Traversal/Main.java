import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }

    public static void postOrdrer(Node root) {
        if (root == null)
            return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution {
    static Node construct(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei) {
            return null;
        }

        if (isi > iei) {
            return null;
        }

        Node root = new Node(preorder[psi]);

        int val = preorder[psi];
        int cntNodeInLeftSubTree = 0;
        int i = isi;

        while (inorder[i] != val) {
            cntNodeInLeftSubTree += 1;
            i++;
        }

        root.left = construct(preorder, psi + 1, psi + cntNodeInLeftSubTree, inorder, isi, i - 1);
        root.right = construct(preorder, psi + cntNodeInLeftSubTree + 1, pei, inorder, i + 1, iei);

        return root;
    }

    // TC: O(N), SC: O(h)
    public static Node buildTree(int inorder[], int preorder[], int n) {
        // Your code here
        return construct(preorder, 0, n - 1, inorder, 0, n - 1);
    }
}
