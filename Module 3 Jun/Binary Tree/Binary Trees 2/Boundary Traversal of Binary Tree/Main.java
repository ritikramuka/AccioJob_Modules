import java.util.*;

class Node {

  int data;
  Node left, right;
}

class Solution {
	// TC: O(H), SC: O(H)
	static void leftBoundry(Node root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			
		} else {
			System.out.print(root.data + " ");	
		}

		if (root.left != null) {
			leftBoundry(root.left);
		} else {
			leftBoundry(root.right);
		}
	}

	// TC: O(N), SC: O(H)
	static void bottomBoundry(Node root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}

		bottomBoundry(root.left);
		bottomBoundry(root.right);
	}

	// TC: O(H), SC: O(H)
	static void rightBoundry(Node root) {
		if (root == null) {
			return;
		}
		
		if (root.right != null) {
			rightBoundry(root.right);
		} else {
			rightBoundry(root.left);
		}

		if (root.left == null && root.right == null) {
			
		} else {
			System.out.print(root.data + " ");	
		}
	}

	// TC: O(N), SC: O(H)
    static void printBoundary(Node root)
    {
        // Your code here
		System.out.print(root.data + " ");	

		leftBoundry(root.left);

		if (root.left == null && root.right == null) {
			
		} else {
			bottomBoundry(root);
		}

		rightBoundry(root.right);
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
