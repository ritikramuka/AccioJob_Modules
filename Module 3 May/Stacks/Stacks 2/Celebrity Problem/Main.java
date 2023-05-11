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
	    Stack<Integer> potentialCeleb = new Stack<>();

		for (int i = 0; i < n; i++) {
			potentialCeleb.push(i);
		}

		while (potentialCeleb.size() > 1) {
			int p1 = potentialCeleb.pop();
			int p2 = potentialCeleb.pop();

			
			if (M[p1][p2] == 1) {
				// p1 knows p2, p1 can't be a celeb
				potentialCeleb.push(p2);
			} else {
				// p1 doesn't knows p2, then p2 can't be a celeb
				potentialCeleb.push(p1);
			}
		}

		int celeb = potentialCeleb.pop();
		
		// row should be zero, why?
		// as a celeb doesn't knows anyone
		for (int i = 0; i < n; i++) {
			if (celeb != i && M[celeb][i] == 1) {
				return -1;
			}
		}

		// col should be one, why?
		// as a celeb is known by everyone
		for (int i = 0; i < n; i++) {
			if (celeb != i && M[i][celeb] == 0) {
				return -1;
			}
		}

		return celeb;
    }

}