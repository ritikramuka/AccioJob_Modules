import java.util.*;

//User function Template for Java
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> treeBoundry;

    void leftBoundry(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        } else {
            treeBoundry.add(node.data);
        }

        if (node.left != null) {
            leftBoundry(node.left);
        } else {
            leftBoundry(node.right);
        }
    }

    void leafNodes(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            treeBoundry.add(node.data);
        }

        leafNodes(node.left);
        leafNodes(node.right);
    }

    void rightBoundry(Node node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            rightBoundry(node.right);
        } else {
            rightBoundry(node.left);
        }

        if (node.left == null && node.right == null) {
            return;
        } else {
            treeBoundry.add(node.data);
        }
    }

    ArrayList<Integer> boundary(Node node) {
        treeBoundry = new ArrayList<>();

        // step 1: add root
        treeBoundry.add(node.data);
        if (node.left == null && node.right == null) {
            return treeBoundry;
        }

        // step 2: add left boundry from left sub-tree
        leftBoundry(node.left);

        // step 3: add leaf nodes
        leafNodes(node);

        // step 4: add right boundry from bottom to top from right sub-tree
        rightBoundry(node.right);

        return treeBoundry;
    }
}