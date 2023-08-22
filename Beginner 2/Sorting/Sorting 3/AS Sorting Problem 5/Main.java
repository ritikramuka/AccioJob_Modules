import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int[] arr = new int[n];
        
        inputLine = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
    
        int ans= sorting5(n, arr);
        System.out.println(ans);
  }

	static int sorting5(int n, int[] arr){
        // Write your code here
		Arrays.sort(arr);

		return arr[n - 1] * arr[n - 2] - arr[1] * arr[0];
    }
}


