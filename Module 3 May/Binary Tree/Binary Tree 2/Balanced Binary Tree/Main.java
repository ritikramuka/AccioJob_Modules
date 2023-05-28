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

	// TC: O(N^2), SC: O(H)
	// faith: tell's is tree balanced?
	// public static boolean isBalanced(Node root) {
	// 	// your code here
	// 	if (root == null) {
	// 		return true;
	// 	}

	// 	boolean isLeftBalanced = isBalanced(root.left);
	// 	boolean isRightBalanced = isBalanced(root.right);

	// 	int lh = height(root.left);
	// 	int rh = height(root.right);
	// 	int diff = Math.abs(lh - rh);
	// 	boolean isNodeBalanced = false;
	// 	if (diff <= 1) {
	// 		isNodeBalanced = true;
	// 	}

	// 	if (isLeftBalanced == true && isRightBalanced == true && isNodeBalanced == true) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }

	static class Pair {
		boolean isBalanced;
		int height;

		Pair (int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	public static Pair helper(Node root) {
		if (root == null) {
			return new Pair(0, true);
		}
		
		Pair left = helper(root.left);
		Pair right = helper(root.right);

		int diff = Math.abs(left.height - right.height);
		boolean isNodeBalanced = false;
		if (diff <= 1) {
			isNodeBalanced = true;
		}

		if (left.isBalanced == true && right.isBalanced == true && isNodeBalanced == true) {
			return new Pair(Math.max(left.height, right.height) + 1, true);
		} else {
			return new Pair(Math.max(left.height, right.height) + 1, false);
		}
	}
	
	public static boolean isBalanced(Node root) {
		// your code here
		return helper(root).isBalanced;
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