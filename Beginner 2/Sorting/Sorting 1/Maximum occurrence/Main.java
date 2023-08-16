import java.util.*;

public class Main {
    static int maximum_occurrence(int arr[], int n) {
        //Write code 

		Arrays.sort(arr);

		int maxOcc = 0;
		int maxOccEle = -1;

		int ele = arr[0];
		int currOcc = 1;

		for (int i = 1; i < n; i++) {
			if (ele == arr[i]) {
				currOcc++;
			} else {
				if (maxOcc < currOcc) {
					maxOcc = currOcc;
					maxOccEle = ele;
				}

				currOcc = 1;
				ele = arr[i];
			}
		}
		if (maxOcc < currOcc) {
			maxOcc = currOcc;
			maxOccEle = ele;
		}

		return maxOccEle;
    }
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(maximum_occurrence(arr, n));

    }
}
