import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 

class Solution
{ 
	// TC: O(N), SC: O(N)
    int findCelebrity(int M[][], int n)
    {
	    Stack<Integer> potentialCelebs = new Stack<>();

		for (int i = 0; i < n; i++) {
			potentialCelebs.push(i);
		}

		while (potentialCelebs.size() != 1) {
			int p1 = potentialCelebs.pop();
			int p2 = potentialCelebs.pop();

			if (M[p1][p2] == 1) {
				// p1 knows p2, hence p1 can't be a celeb
				potentialCelebs.push(p2);
			} else {
				// p1 doesn't know p2, hence p2 can't be celeb
				potentialCelebs.push(p1);
			}
		}

		int pCeleb = potentialCelebs.pop();

		// row should be 0
		for (int i = 0; i < n; i++) {
			if (i != pCeleb && M[pCeleb][i] != 0) {
				// my pCeleb knows someone
				return -1;
			}
		}

		// col should be 1
		for (int i = 0; i < n; i++) {
			if (i != pCeleb && M[i][pCeleb] != 1) {
				// Someone doesn't knows my pCeleb
				return -1;
			}
		}

		return pCeleb;
    }
}