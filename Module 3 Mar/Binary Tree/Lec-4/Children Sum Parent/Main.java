
//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null) {
            return 1;
        }

        // if leaf node, then return true
        if (root.left == null && root.right == null) {
            return 1;
        }

        int isFollowedInLeftSubTree = isSumProperty(root.left);

        int isFollowedInRightSubTree = isSumProperty(root.right);

        int childrenSum = 0;
        if (root.left != null) {
            childrenSum += root.left.data;
        }
        if (root.right != null) {
            childrenSum += root.right.data;
        }

        int isFollowedAtRoot = 0;
        if (childrenSum == root.data) {
            isFollowedAtRoot = 1;
        }

        if (isFollowedInLeftSubTree == 1 && isFollowedInRightSubTree == 1 && isFollowedAtRoot == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}