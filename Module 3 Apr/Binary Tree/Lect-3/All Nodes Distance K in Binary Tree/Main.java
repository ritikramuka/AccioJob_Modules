
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            int n = sc.nextInt();
		    int K = sc.nextInt();
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.KDistanceNodes(root,n,K);
            Collections.sort(ans);
			for(int i = 0 ; i < ans.size() ; ++i){
                System.out.print(ans.get(i) + " ");
            }
		
	}
}
  


class Solution{
	static void setParents(Node root, HashMap<Node, Node> parents) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			parents.put(root.left, root);
		}

		if (root.right != null) {
			parents.put(root.right, root);
		}

		setParents(root.left, parents);
		setParents(root.right, parents);
	}

	static Node find (Node root, int target) {
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
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        //Write your code here 
		HashMap<Node, Node> parents = new HashMap<>();
		setParents(root, parents);

		Node src = find(root, target);

		HashSet<Node> vis = new HashSet<>();
		
		Queue<Node> que = new ArrayDeque<>();
		que.add(src);
		vis.add(src);

		int level = 0;
		while (que.size() != 0) {
			int size = que.size();
			ArrayList<Integer> currLevel = new ArrayList<>();
			while (size-->0) {
				Node rnode = que.remove();

				currLevel.add(rnode.data);
				
				if (rnode.left != null && vis.contains(rnode.left) == false) {
					vis.add(rnode.left);
					que.add(rnode.left);
				}

				if (rnode.right != null && vis.contains(rnode.right) == false) {
					vis.add(rnode.right);
					que.add(rnode.right);
				}

				if (parents.get(rnode) != null && vis.contains(parents.get(rnode)) == false) {
					vis.add(parents.get(rnode));
					que.add(parents.get(rnode));
				}
			}
			if (level == k) {
				return currLevel;
			}
			level++;
		}

		return new ArrayList<>();
    }
    
}

