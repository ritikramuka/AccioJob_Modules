import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution {
	int maxPos = Integer.MIN_VALUE;
	int minPos = Integer.MAX_VALUE;

	void getPos(TreeNode root, int pos) {
		if (root == null) {
			return;
		}

		maxPos = Math.max(maxPos, pos);
		minPos = Math.min(minPos, pos);

		getPos (root.left, pos - 1);
		getPos (root.right, pos + 1);
	}

	class Pair implements Comparable<Pair> {
		TreeNode node;
		int pos;

		Pair (TreeNode node, int pos) {
			this.node = node;
			this.pos = pos;
		}

		@Override
		public int compareTo(Pair other) {
			if (this.pos == other.pos) {
				// is pos is same and both are in same level, smaller value should come first
				return this.node.data - other.node.data;
			} else {
				return this.pos - other.pos;
			}
		}
	}
	
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        //Write your code here
		getPos (root, 0);
		int numberOfLevels = maxPos - minPos + 1;
		
		List<List<Integer>> vo = new ArrayList<>();
		for (int i = 0; i < numberOfLevels; i++) {
			vo.add(new ArrayList<>());
		}

		PriorityQueue<Pair> mainPq = new PriorityQueue<>();
		mainPq.add(new Pair (root, -minPos));

		while (mainPq.size() != 0) {
			int size = mainPq.size();
			PriorityQueue<Pair> childPq = new PriorityQueue<>();
			while (size-->0) {
				Pair rpair = mainPq.remove();
				int pos = rpair.pos;
				TreeNode rnode = rpair.node;

				vo.get(pos).add(rnode.data);

				if (rnode.left != null) {
					childPq.add(new Pair(rnode.left, pos - 1));
				}

				if (rnode.right != null) {
					childPq.add(new Pair(rnode.right, pos + 1));
				}
			}

			mainPq = childPq;
		}

		return vo;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            t--;
        }
    }
}