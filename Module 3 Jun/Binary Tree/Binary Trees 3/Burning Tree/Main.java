

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
    
    public static void traversal(Node root, HashMap<Node, Node> map) 
    {
        if (root == null) 
        {
            return;
        }    
        
        if (root.left != null) 
        {
            map.put(root.left, root);    
        }
        
        if (root.right != null) 
        {
            map.put(root.right, root); 
        }
        
        traversal(root.left, map);
        traversal(root.right, map);
    }
    
    static Node find(Node root, int tar) 
    {
        if (root == null) 
        {
            return null;
        }
        
        if (root.data == tar) 
        {
            return root;
        }
        
        Node filc = find(root.left, tar);
        if (filc != null)
        {
            return filc;
        }
        
        Node firc = find(root.right, tar);
        if (firc != null)
        {
            return firc;
        }
        
        return null;
    }
    
    
    public static int minTime(Node root, int target) 
    {
        // stores child -> parent
        HashMap<Node, Node> map = new HashMap<>();
        traversal(root, map);
        
        Node src = find(root, target);
        
        if (src == null) 
        {
            return 0;    
        }
        
        Queue<Node> que = new ArrayDeque<>();
        
        que.add(src);
        
        HashSet<Node> vis = new HashSet<>();
        vis.add(src);
        
        int level = 0;
        
        while (que.size() > 0) 
        {
            int size = que.size();
            while (size-->0)
            {
                Node rnode = que.remove();
                
                if (rnode.left != null && vis.contains(rnode.left) == false) 
                {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }
                
                if (rnode.right != null && vis.contains(rnode.right) == false)
                {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }
                
                if (map.containsKey(rnode) == true && vis.contains(map.get(rnode)) == false)
                {
                    que.add(map.get(rnode));
                    vis.add(map.get(rnode));
                }
            }
            level++;
        }
        
        if (level == 0) 
        {
            return 0;    
        }
        
        int time = level - 1;
        
        return time;
    }
}