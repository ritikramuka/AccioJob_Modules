import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> triangle = pascalTriangleRow(n);
        for (int i = 0; i < triangle.size(); i++) {
            System.out.print(triangle.get(i) + " ");
        }
    }

	public static ArrayList<Integer> pascalTriangleRow(int numRows) {
        // write code here
		// ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
		// for (int i = 0; i < numRows; i++) {
		// 	pascalsTriangle.add(new ArrayList<>());
		// }

		// for (int i = 0; i < numRows; i++) {
		// 	for (int j = 0; j <= i; j++) {
		// 		if (j == 0 || j == i) {
		// 			pascalsTriangle.get(i).add(1);
		// 		} else {
		// 			pascalsTriangle.get(i).add(pascalsTriangle.get(i - 1).get(j) + pascalsTriangle.get(i - 1).get(j - 1));
		// 		}
		// 	}
		// }

		// return pascalsTriangle.get(numRows - 1);

		ArrayList<Integer> pascalsTriangleRow = new ArrayList<>();
		pascalsTriangleRow.add(1);
		
		for (int i = 1; i < numRows; i++) {
			int temp = 0;
			for (int j = 0; j < pascalsTriangleRow.size(); j++) {
				if (j == 0) {
					temp = 1;
				} else {
					int temp2 = pascalsTriangleRow.get(j);
					pascalsTriangleRow.set(j, temp + pascalsTriangleRow.get(j));
					temp = temp2;
				}
			}
			pascalsTriangleRow.add(1);
		}

		return pascalsTriangleRow;
    }
}

