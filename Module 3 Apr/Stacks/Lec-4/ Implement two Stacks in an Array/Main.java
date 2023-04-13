import java.util.*;

class twoStacks {
	int[] arr;
	int size;
	int top1, top2;

	// Constructor
	twoStacks(int n)
	{
		size = n;
		arr = new int[n];
		top1 = -1;
		top2 = n;
	}

	// TC: O(1)
	// Method to push an element x to stack1
	void push1(int x)
	{
	    // Your code here
		if (top1 + 1 < top2) {
			top1 += 1;
			arr[top1] = x;
		} else {
			// carsh will happen
			return;
		}
	}

	// TC: O(1)
	// Method to push an element
	// x to stack2
	void push2(int x)
	{
	    // Your code here
		if (top2 - 1 > top1) {
			top2 -= 1;
			arr[top2] = x;
		} else {
			// carsh will happen
			return;
		}
	}

	// TC: O(1)
	// Method to pop an element from first stack
	void pop1()
	{
		// Your code here
		if (top1 == -1) {
			// empty stack 1
			System.out.println(-1);
			return;
		} else {
			System.out.println(arr[top1]);
			arr[top1] = 0;
			top1 -= 1;
		}
	}

	// TC: O(1)
	// Method to pop an element
	// from second stack
	void pop2()
	{
		// Your code here
		if (top2 == size) {
			// empty stack 2
			System.out.println(-1);
			return;
		} else {
			System.out.println(arr[top2]);
			arr[top2] = 0;
			top2 += 1;
		}
	}
};
public class Main {

	/* Driver program to test twoStacks class */
	public static void main(String[] args)
	{
		twoStacks ts = new twoStacks(50);
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i =0; i<n; i++){
            int temp;
            temp = sc.nextInt();
            if(temp == 1) ts.pop1();
            else if(temp==3) ts.pop2();
            else if(temp == 2) {
                int temp2;
                temp2 = sc.nextInt();
                ts.push1(temp2);
            }
            else{
                int temp2;
                temp2 = sc.nextInt();
                ts.push2(temp2);
            }
        }
	}
}