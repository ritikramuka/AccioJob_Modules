import java.util.Scanner;



// class Main {
// 	public static void main(String[] args) {
// 		Scanner s = new Scanner(System.in);
//         int N = s.nextInt();
// 		int[] A = new int[N];
// 		for(int i = 0; i < N; i++){
// 			A[i] = s.nextInt();
// 		}
// 		int T = s.nextInt();
// 		System.out.println(lastIndex(A, T, N - 1));
// 	}

// 	static int lastIndex(int A[], int T, int endIndex) {
// 		// Base Case
// 		if (endIndex < 0) {
// 			return -1;
// 		}

// 		if (A[endIndex] == T) {
// 			return endIndex;
// 		}

// 		int a = lastIndex(A, T, endIndex - 1);
// 		return a;
// 	}
// }

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++){
			A[i] = s.nextInt();
		}
		int T = s.nextInt();
		System.out.println(lastIndex(A, T, 0));
	}

	// Faith: returns last occ of T in the array starting from startIndex
	static int lastIndex(int A[], int T, int startIndex) {
		if (startIndex == A.length) {
			return -1;
		}
		
		int a = lastIndex(A, T, startIndex + 1);
		if (a != -1) {
			return a;
		} else {
			if (A[startIndex] == T) {
				return startIndex;
			} else {
				return -1;
			}
		}
	}
}