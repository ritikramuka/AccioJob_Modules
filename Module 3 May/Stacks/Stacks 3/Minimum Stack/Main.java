import java.util.*;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			Solution g = new Solution();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
        sc.close();
		
	}
}

// class Solution
// {
// 	int minEle;
// 	Stack<Integer> s;
    
// 	Solution()
// 	{
// 		s = new Stack<Integer>();
// 	}

// 	void push(int x){
//         //Write Code here		
//     }
	
// 	int pop(){
//         //Write Code here
// 	}

//     int getMin(){
//         //Write Code here
// 	}	
// }

// class Solution
// {
// 	Stack<Integer> st;
    
// 	Solution() {
// 		st = new Stack<Integer>();
// 	}

// 	// TC: O(1)
// 	void push(int x) {
//         //Write Code here	
// 		st.push(x);
//     }

// 	// TC: O(1)
// 	int pop() {
//         //Write Code here
// 		if (st.size() == 0) {
// 			return -1;
// 		} else {
// 			return st.pop();
// 		}
// 	}

// 	// TC: O(N)
//     int getMin() {
//         //Write Code here
// 		int minEle = Integer.MAX_VALUE;
		
// 		Stack<Integer> temp = new Stack<>();
// 		while (st.size() != 0) {
// 			minEle = Math.min(minEle, st.peek());
// 			temp.push(st.pop());
// 		}

// 		while (temp.size() != 0) {
// 			st.push(temp.pop());
// 		}

// 		return minEle;
// 	}	
// }

// class Solution
// {
// 	class Pair {
// 		int val;
// 		int minEle;

// 		Pair (int val, int minEle) {
// 			this.val = val;
// 			this.minEle = minEle;
// 		}
// 	}
	
// 	Stack<Pair> st;
    
// 	Solution() {
// 		st = new Stack<Pair>();
// 	}

// 	// TC: O(1)
// 	void push(int x) {
//         //Write Code here
// 		if (st.size() == 0) {
// 			// as I'm first person in the stack, min is me only in stack
// 			st.push(new Pair(x, x));
// 		} else {
// 			// minEle till now
// 			int prevMin = st.peek().minEle;

// 			// minEle in stack is
// 			prevMin = Math.min(prevMin, x);

// 			st.push(new Pair(x, prevMin));
// 		}
//     }

// 	// TC: O(1)
// 	int pop() {
//         //Write Code here
// 		if (st.size() == 0) {
// 			return -1;
// 		} else {
// 			return st.pop().val;
// 		}
// 	}

// 	// TC: O(1)
//     int getMin() {
//         //Write Code here
// 		if (st.size() == 0) {
// 			return -1;
// 		}
		
// 		return st.peek().minEle;
// 	}	
// }


class Solution
{
	int minEle;
	Stack<Integer> st;
    
	Solution() {
		st = new Stack<Integer>();
		minEle = Integer.MAX_VALUE;
	}

	void push(int x){
        //Write Code here	
		if (st.size() == 0) {
			st.push(minEle);
			st.push(x);
			minEle = x;
		} else {
			if (x <= minEle) {
				st.push(minEle);
				st.push(x);
				minEle = x;
			} else {
				st.push(x);
			}
		}
    }
	
	int pop(){
        //Write Code here
		if (st.size() == 0) {
			return -1;
		} else {
			if (st.peek() == minEle) {
				int x = st.pop();
				minEle = st.pop();

				return x;
			} else {
				return st.pop();
			}
		}
	}

    int getMin(){
        //Write Code here
		if (minEle == Integer.MAX_VALUE) {
			return -1;
		} else {
			return minEle;
		}
	}	
}