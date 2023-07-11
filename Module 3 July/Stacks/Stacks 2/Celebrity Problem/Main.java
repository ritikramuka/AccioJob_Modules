import java.io.*;
import java.util.*; 

class Main {
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

class Solution { 
	// TC: O(N), SC: O(N)
    int findCelebrity(int M[][], int n) {
	    Stack<Integer> pCeleb = new Stack<>();
		for (int i = 0; i < n; i++) {
			pCeleb.push(i);
		}

		while (pCeleb.size() != 1) {
			int p1 = pCeleb.pop();
			int p2 = pCeleb.pop();

			// p1 knows p2, p1 is not a celeb
			if (M[p1][p2] == 1) {
				pCeleb.push(p2);
			} else {
				// p1 doesn't knows p2, p2 is not a celeb
				pCeleb.push(p1);
			}
		}

		int celeb = pCeleb.pop();

		// celeb row should be zero
		for (int i = 0; i < n; i++) {
			if (i != celeb && M[celeb][i] == 1) {
				return -1;
			}
		}

		// celeb col should be one
		for (int i = 0; i < n; i++) {
			if (i != celeb && M[i][celeb] == 0) {
				return -1;
			}
		}

		return celeb;
    }

}