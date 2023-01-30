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

class Main {
    void getLeftBoundry(Node root, ArrayList<Integer> treeBoundry) {
        if (root == null) {
            return;
        }

        // leaf node
        if (root.left == null && root.right == null) {
            // do nothing
            return;
        } else {
            treeBoundry.add(root.data);
        }

        if (root.left != null) {
            getLeftBoundry(root.left, treeBoundry);
        } else {
            getLeftBoundry(root.right, treeBoundry);
        }
    }

    void getBottomBoundry(Node root, ArrayList<Integer> treeBoundry) {
        if (root == null) {
            return;
        }

        // leaf node
        if (root.left == null && root.right == null) {
            treeBoundry.add(root.data);
        }

        getBottomBoundry(root.left, treeBoundry);
        getBottomBoundry(root.right, treeBoundry);
    }

    void getRightBoundry(Node root, ArrayList<Integer> treeBoundry) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            getRightBoundry(root.right, treeBoundry);
        } else {
            getRightBoundry(root.left, treeBoundry);
        }

        // leaf node
        if (root.left == null && root.right == null) {
            // do nothing
            return;
        } else {
            treeBoundry.add(root.data);
        }
    }

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> treeBoundry = new ArrayList<>();

        if (root == null) {
            return treeBoundry;
        }

        // add root as top boundry
        treeBoundry.add(root.data);

        if (root.left == null && root.right == null) {
            return treeBoundry;
        }

        // add left boundry
        getLeftBoundry(root.left, treeBoundry);

        // add bottom boundry
        getBottomBoundry(root, treeBoundry);

        // add right boundry
        getRightBoundry(root.right, treeBoundry);

        return treeBoundry;
    }
}