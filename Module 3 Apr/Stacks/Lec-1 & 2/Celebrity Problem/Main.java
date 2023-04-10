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
	    Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			int p1 = st.pop();
			int p2 = st.pop();

			if (M[p1][p2] == 1) {
				// if p1 is knows p2, p1 can't be a celeb
				st.push(p2);
			} else {
				// if p1 doesn't knows p2, p2 can't be a celeb
				st.push(p1);
			}
		}

		int pCeleb = st.pop();

		// row should be 0
		for (int c = 0; c < n; c++) {
			if (c != pCeleb) {
				if (M[pCeleb][c] == 1) {
					return -1;
				}
			}
		}

		// col should be 1
		for (int r = 0; r < n; r++) {
			if (r != pCeleb) {
				if (M[r][pCeleb] == 0) {
					return -1;
				}
			}
		}

		return pCeleb;
    }
}