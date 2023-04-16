/**
 * https://course.acciojob.com/idle?question=481f654d-3285-4ebc-af28-0e041aa79d88
 */
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String operation[]=new String[n];
        for(int i=0;i<n;i++)
        operation[i]=sc.next();
        
        Solution obj=new Solution();

        System.out.println(obj.solve(operation,n));

		sc.close();
    }
}

class Solution {

	// TC: O(N), SC: O(N)
    int solve(String operation[], int n) {
        Stack<Integer> records = new Stack<>();

		for (int i = 0; i < n; i++) {
			String currOperation = operation[i];
			
			if (currOperation.equals("C") == true) {
				records.pop();
			} else if (currOperation.equals("+") == true) {
				int v1 = records.pop();
				int v2 = records.pop();
				int sum = v1 + v2;
				records.push(v2);
				records.push(v1);
				records.push(sum);
			} else if (currOperation.equals("D") == true) {
				int val = records.pop();
				int doubleValue = val * 2;
				records.push(val);
				records.push(doubleValue);
			} else {
				// currOperation will be int value
				int val = Integer.parseInt(currOperation);
				records.push(val);
			}
		}

		int sum = 0;
		while (records.size() > 0) {
			sum += records.pop();
		}

		return sum;
	}
}
