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
	public static Node buildTree2(int[] in, int isi, int iei, int[] pre, int psi, int pei) {
		if (isi > iei || psi > pei) {
			return null;
		}
		
		Node root = new Node(pre[psi]);

		int cntLST = 0;
		int i = isi;
		while (in[i] != root.data) {
			i++;
			cntLST++;
		}

		root.left = buildTree2(in, isi, i - 1, pre, psi + 1, psi + cntLST);
		root.right = buildTree2(in, i + 1, iei, pre, psi + cntLST + 1, pei);

		return root;
	}
	
    public static Node buildTree(int inorder[], int preorder[], int n){
        //Your code here
		return buildTree2(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}
