import java.io.*;
import java.util.*;
 
 class Solution
{
	// TC: O(N), SC: O(N)
	static int solve(int N, int[] Arr, int K){
	    // Write your code here
	    int result = 0;

		HashMap<Integer, Integer> fmap = new HashMap();
		fmap.put(0, 1);

		int runningSum = 0;
		for (int i = 0; i < N; i++) {
			runningSum += Arr[i];

			int x = runningSum - K;
			if (fmap.containsKey(x) == true) {
				result += fmap.get(x);
			}

			fmap.put(runningSum, fmap.getOrDefault(runningSum, 0) + 1);
		}
		
        return result;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());
 
         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
}