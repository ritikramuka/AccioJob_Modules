import java.util.*;

class Node {

  int data;
  Node left, right;
}

class Solution{
	static void leftBoundry(Node root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		ans.add(root.data);
		
		if (root.left != null) {
			leftBoundry(root.left, ans);
		} else {
			leftBoundry(root.right, ans);
		}
	}
	
	static void leafNodes(Node root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			ans.add(root.data);
			return;
		}
		
		leafNodes(root.left, ans);
		leafNodes(root.right, ans);
	}

	static void rightBoundry(Node root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		if (root.right != null) {
			rightBoundry(root.right, ans);
		} else {
			rightBoundry(root.left, ans);
		}

		ans.add(root.data);
	}

	// TC: O(N), SC: O(H)
    static void printBoundary(Node node)
    {
        // Your code here
		if (node == null) {
			return;
		}
		
		ArrayList<Integer> ans = new ArrayList<>();

		// step 1: add root node
		ans.add(node.data);

		// step 2: add left boundry (excluding leaf node and root node)
		leftBoundry(node.left, ans);

		// step 3: add leaf 
		if (node.left != null || node.right != null) {
			leafNodes(node, ans);	
		}

		// step 4: add right boundry (excluding leaf node and root node) in reverse order
		rightBoundry(node.right, ans);

		for (int a : ans) {
			System.out.print(a + " ");
		}
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
