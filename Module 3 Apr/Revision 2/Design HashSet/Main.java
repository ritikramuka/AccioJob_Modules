import java.util.*;

class Solution {
	boolean[] set = new boolean[1000001];
	
    public void add(int key) {
        //Complete the function
		set[key] = true;
    }

    public void remove(int key) {
        //Complete the function
		set[key] = false;
    }

    public boolean contains(int key) {
        //Complete the function
		if (set[key] == true) {
			return true;
		} else {
			return false;
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}