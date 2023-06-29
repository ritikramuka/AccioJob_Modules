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

	static class Pair {
		boolean isBalancedTree;
		int height;

		Pair (boolean isBalancedTree, int height) {
			this.isBalancedTree = isBalancedTree;
			this.height = height;
		}
	}

	// TC: O(N), SC: O(H)
	// faith: returns is tree balanced and height of the tree
	public static Pair isBalanced2(Node root) {
		if (root == null) {
			return new Pair(true, 0);
		}

		Pair LST = isBalanced2(root.left);

		Pair RST = isBalanced2(root.right);

		boolean isRootNodeBalanced = Math.abs(LST.height - RST.height) <= 1 ? true : false;

		boolean isTreeBalanced = false;
		if (LST.isBalancedTree == true && RST.isBalancedTree == true && isRootNodeBalanced == true) {
			isTreeBalanced = true;
		}

		int heightOfTheTree = Math.max(LST.height, RST.height) + 1;

		return new Pair(isTreeBalanced, heightOfTheTree);
	}

	public static boolean isBalanced(Node root) {
		// your code here
		return isBalanced2(root).isBalancedTree;
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