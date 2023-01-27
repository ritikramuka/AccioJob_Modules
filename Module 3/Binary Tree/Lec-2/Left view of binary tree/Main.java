import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    Node root = null;

    BST() {

    }

    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }

        Solution Accio = new Solution();
        Accio.letfView(t.root);
    }
}

class Solution {
    public static void letfView(Node root) {
        // Your code here
        if (root == null) {
            return;
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        while (que.size() > 0) {
            int size = que.size();

            System.out.print(que.peek().val + " ");

            while (size > 0) {
                Node rnode = que.remove();

                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                if (rnode.right != null) {
                    que.add(rnode.right);
                }

                size--;
            }
        }
    }

}