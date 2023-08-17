import java.util.*;

public class Main {
	static int[] Sorting01(int n,int[] arr){
        // Your code here
		int lo = 0;
		int hi = n - 1;

		while (lo <= hi) {
			if (arr[lo] == 1) {
				// swap arr[lo], arr[hi], hi--;
				int temp = arr[lo];
				arr[lo] = arr[hi];
				arr[hi] = temp;

				hi--;
			} else {
				lo++;
			}
		}

		return arr;
    }
	
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int[] ans=Sorting01(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}