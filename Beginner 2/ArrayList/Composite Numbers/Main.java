import java.util.*;

class Main
{

	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		// prime numbers are numbers divisible by 1 and itself\
		
		// if number is divisible by any value between 2 to (n - 1), then it is non prime number
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	static void removeComposite(int arr[], int len)
	{
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			if (isPrime(arr[i]) == true) {
				ans.add(arr[i]);
			}
		}

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    for(int i=0; i<n; i++){
	        arr[i] = sc.nextInt();
	    }
		removeComposite(arr, n);
	}
}
