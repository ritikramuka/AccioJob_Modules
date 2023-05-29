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
	int leftMostPos = 0;
	int rightMostPos = 0;

	void getSpan(TreeNode root, int pos) {
		if (root == null) {
			return;
		}

		leftMostPos = Math.min(leftMostPos, pos);
		rightMostPos = Math.max(rightMostPos, pos);

		getSpan(root.left, pos - 1);
		getSpan(root.right, pos + 1);
	}

	class Pair implements Comparable<Pair> {
		TreeNode node;
		int vl;

		Pair(TreeNode node, int vl) {
			this.node = node;
			this.vl = vl;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.vl == o.vl) {
				// return smaller value person before
				return this.node.data - o.node.data;
			} else {
				// return person with smaller vl
				return this.vl - o.vl;
			}
		}
	}
	
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        // calculate span
		if (root == null) {
			return new ArrayList<>();
		}
		
		getSpan(root, 0);

		int numberOfVL = rightMostPos - leftMostPos + 1;
		int posOfRoot = -leftMostPos;

		List<List<Integer>> vo = new ArrayList<>();
		for (int i = 0; i < numberOfVL; i++) {
			vo.add(new ArrayList<>());	
		}
		
		PriorityQueue<Pair> que = new PriorityQueue<>();
		que.add(new Pair(root, posOfRoot));

		while (que.size() != 0) {
			int size = que.size();
			PriorityQueue<Pair> tempPq = new PriorityQueue<>();
			while (size-->0) {
				Pair rpair = que.remove();
				vo.get(rpair.vl).add(rpair.node.data);

				if (rpair.node.left != null) {
					tempPq.add(new Pair(rpair.node.left, rpair.vl - 1));
				}

				if (rpair.node.right != null) {
					tempPq.add(new Pair(rpair.node.right, rpair.vl + 1));
				}
			}
			que = tempPq;
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
            // System.out.println();
            t--;
        }
    }
}