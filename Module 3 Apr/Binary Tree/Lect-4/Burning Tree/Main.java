

//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static void setParent(Node root, HashMap<Node, Node> parent) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            parent.put(root.left, root);
        }
        
        if (root.right != null) {
            parent.put(root.right, root);
        }
        
        setParent(root.left, parent);
        setParent(root.right, parent);
    }
    
    static Node find(Node root, int target) {
        if (root == null) {
            return null;
        }
        
        if (root.data == target) {
            return root;
        }
        
        Node filc = find(root.left, target);
        if (filc != null) {
            return filc;
        }
        
        Node firc = find(root.right, target);
        if (firc != null) {
            return firc;
        }
        
        return null;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        setParent(root, parent);
        
        Node src = find(root, target);
        
        // BFS
        HashSet<Node> vis = new HashSet<>();
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(src);
        vis.add(src);
        
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-->0) {
                Node rnode = que.remove();
                
                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }
                
                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }
                
                if (parent.get(rnode) != null && vis.contains(parent.get(rnode)) == false) {
                    que.add(parent.get(rnode));
                    vis.add(parent.get(rnode));
                }
            }
            level++;
        }
        
        int time = level - 1;
        
        if (time < 0) {
            return 0;
        }
        
        return time;
    }
}