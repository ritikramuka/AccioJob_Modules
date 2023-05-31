import java.util.*;
import java.io.*;
class Node{
    int data; 
    Node left, right;
    Node(int key){
        data = key;
        left = right = null;
    }
}

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for(int i = 0; i < n; i++)
          preorder[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
          inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }
    
    public static void postOrdrer(Node root){
        if(root == null)
          return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}


class Solution {

	public static Node construct (int[] in, int isi, int iei, int[] pre, int psi, int pei) {
		if (psi > pei || isi > iei) {
			return null;
		}
		
		Node root = new Node(pre[psi]);
		int cnt = 0;
		int itr = isi;
		while (in[itr] != root.data) {
			cnt++;
			itr++;
		}

		Node lst = construct (in, isi, itr - 1, pre, psi + 1, psi + cnt);
		Node rst = construct (in, itr + 1, iei, pre, psi + cnt + 1, pei);

		root.left = lst;
		root.right = rst;

		return root;
	}
	
    public static Node buildTree(int inorder[], int preorder[], int n){
        //Your code here 
		return construct(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}
