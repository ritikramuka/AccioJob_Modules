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
	  boolean isBalanced;
	  int h;

	  Pair (boolean isBalanced, int h) {
		  this.isBalanced = isBalanced;
		  this.h = h;
	  }
  }

  // Faith: returns {isBalanced, height} of the Tree starting from root
  public static Pair isBalanced2(Node root) {
	  if (root == null) {
		  return new Pair(true, 0);
	  }
	  
	  Pair LST = isBalanced2(root.left);
	  Pair RST = isBalanced2(root.right);

	  int heightOfTheTree = Math.max(LST.h, RST.h) + 1;

	  // is root node balanced?
	  boolean rootIsBalanced = false;
	  if (Math.abs(LST.h - RST.h) <= 1) {
		  rootIsBalanced = true;
	  }

	  if (rootIsBalanced == true && LST.isBalanced == true && RST.isBalanced == true) {
		  return new Pair(true, heightOfTheTree);
	  } else {
		  return new Pair(false, heightOfTheTree);
	  }
  }

  // TC: O(N), SC: O(H)
  public static boolean isBalanced(Node root) {
    // your code here
	return isBalanced2(root).isBalanced;
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