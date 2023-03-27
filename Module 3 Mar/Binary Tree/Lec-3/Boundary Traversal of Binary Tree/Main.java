import java.util.*;

class Node {

    int data;
    Node left, right;
}

class Solution {
    static void leftWall(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        System.out.print(node.data + " ");

        leftWall(node.left);
        if (node.left == null) {
            leftWall(node.right);
        }
    }

    static void bottomWall(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        bottomWall(node.left);
        bottomWall(node.right);
    }

    static void rightWall(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        rightWall(node.right);
        if (node.right == null) {
            rightWall(node.left);
        }

        System.out.print(node.data + " ");
    }

        static void printBoundary(Node node)
    {
        // Your code here

		// step 1: print root;
		System.out.print(node.data + " ");

		// edge case when root is alone
		if(node.left == null && node.right == null) {
			return;
		}

		// step 2: left wall
		leftWall(node.left);

		// step 3: bottom wall (leaf nodes)
		bottomWall(node);

		// step 4: right wall
		rightWall(node.right);
    }
}

public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    Solution.printBoundary(root);
  }
}
