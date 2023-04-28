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


class Solution{
	public static Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei) {
			return null;
		}

		if (isi > iei) {
			return null;
		}

		Node root = new Node(pre[psi]);

		int i = isi;
		int cntNumberOfPeopleInLeftSubTree = 0;
		while (in[i] != root.data) {
			cntNumberOfPeopleInLeftSubTree++;
			i++;
		}

		root.left = construct(pre, psi + 1, psi + cntNumberOfPeopleInLeftSubTree, in, isi, i - 1);
		root.right = construct(pre, psi + cntNumberOfPeopleInLeftSubTree + 1, pei, in, i + 1, iei);

		return root;
	}
	
    public static Node buildTree(int inorder[], int preorder[], int n){
        //Your code here 
		return construct(preorder, 0, n - 1, inorder, 0, n - 1);
    }
}
