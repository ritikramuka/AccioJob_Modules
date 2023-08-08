import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

	public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
        // write code here

		// using static array
		// int[][] pascalsTriangle = new int[numRows][numRows];

		// for (int i = 0; i < numRows; i++) {
		// 	for (int j = 0; j <= i; j++) {
		// 		if (j == 0 || j == i) {
		// 			pascalsTriangle[i][j] = 1;
		// 		} else {
		// 			pascalsTriangle[i][j] = pascalsTriangle[i - 1][j] + pascalsTriangle[i - 1][j - 1];
		// 		}
		// 	}
		// }

		// for (int i = 0; i < numRows; i++) {
		// 	for (int j = 0; j < numRows; j++) {
		// 		System.out.print(pascalsTriangle[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			pascalsTriangle.add(new ArrayList<>());
		}

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					pascalsTriangle.get(i).add(1);
				} else {
					pascalsTriangle.get(i).add(pascalsTriangle.get(i - 1).get(j) + pascalsTriangle.get(i - 1).get(j - 1));
				}
			}
		}
		

		return pascalsTriangle;
    }
}
