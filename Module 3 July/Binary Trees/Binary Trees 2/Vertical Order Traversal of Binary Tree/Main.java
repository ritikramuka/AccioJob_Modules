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

	int maxPos = 0;
	int minPos = 0;
	void posOfEachNode(TreeNode root, int pos) {
		if (root == null) {
			return;
		}

		minPos = Math.min(pos, minPos);
		maxPos = Math.max(pos, maxPos);
		
		posOfEachNode(root.left, pos - 1);
		posOfEachNode(root.right, pos + 1);
	}

	class Pair implements Comparable<Pair> {
		TreeNode node;
		int vLevel;

		Pair (TreeNode node, int vLevel) {
			this.node = node;
			this.vLevel = vLevel;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.vLevel == o.vLevel) {
				return this.node.data - o.node.data;
			} else {
				return this.vLevel - o.vLevel;
			}
		}
	}
	
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        //Write your code here
		if (root == null) {
			return new ArrayList<>();
		}
		
		posOfEachNode(root, 0);

		int vLevelOfRoot = -minPos;
		int numberOfVLevel = maxPos - minPos + 1;

		List<List<Integer>> vo = new ArrayList<>();
		for (int i = 0; i < numberOfVLevel; i++) {
			vo.add(new ArrayList<>());
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(root, vLevelOfRoot));

		while (pq.size() != 0) {
			int size = pq.size();

			PriorityQueue<Pair> tempPq = new PriorityQueue<>();
			while (size-->0) {
				Pair rpair = pq.remove();

				vo.get(rpair.vLevel).add(rpair.node.data);

				if (rpair.node.left != null) {
					tempPq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
				}

				if (rpair.node.right != null) {
					tempPq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
				}
			}

			pq = tempPq;
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