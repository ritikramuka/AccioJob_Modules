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

	// static int height(Node root) {
	// 	if (root == null) {
	// 		return -1;
	// 	}

	// 	int lh = height(root.left);
	// 	int rh = height(root.right);

	// 	return Math.max(lh, rh) + 1;
	// }

	// // TC: O(N^2), SC: O(H)
	// public static boolean isBalanced(Node root) {
	// 	// your code here
	// 	if (root == null) {
	// 		return true;
	// 	}

	// 	Boolean isLeftBalanced = isBalanced(root.left);
	// 	Boolean isRightBalanced = isBalanced(root.right);

	// 	int lh = height(root.left);
	// 	int rh = height(root.right);
	// 	boolean isRootBalanced = false;
	// 	if (Math.abs(lh - rh) <= 1) {
	// 		isRootBalanced = true;
	// 	}

	// 	if (isLeftBalanced == true && isRootBalanced == true && isRightBalanced == true) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }

	static class Pair {
		boolean isBalanced;
		int height;

		Pair (boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	static Pair isBalancedTree(Node root) {
		if (root == null) {
			return new Pair (true, -1);
		}
		
		Pair left = isBalancedTree(root.left);
		Pair right = isBalancedTree(root.right);

		boolean isRootBalanced = false;
		if (Math.abs(left.height - right.height) <= 1) {
			isRootBalanced = true;
		}

		boolean isTreeBalanced = false;
		if (left.isBalanced == true && isRootBalanced == true && right.isBalanced == true) {
			isTreeBalanced = true;
		}

		int height = Math.max(left.height, right.height) + 1;

		return new Pair(isTreeBalanced, height);
	}

	// TC: O(N), SC: O(H)
	public static boolean isBalanced(Node root) {
		// your code here
		Pair ans = isBalancedTree(root);
		return ans.isBalanced;
	}

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node {

  int data;
  Node left, right;
}