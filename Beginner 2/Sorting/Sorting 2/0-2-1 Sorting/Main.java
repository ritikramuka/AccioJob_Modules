import java.util.*;


public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int[] ans=Sorting021(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }

	static int[] Sorting021(int n,int[] arr){
        // Write your code here
		int lo = 0;
		int mid = 0;
		int hi = n - 1;

		while (mid <= hi) {
			if (arr[mid] == 2) {
				mid++;
			} else if (arr[mid] == 1) {
				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;

				hi--;
			} else {
				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;

				mid++;
				lo++;
			}
		}

		return arr;
    }
}