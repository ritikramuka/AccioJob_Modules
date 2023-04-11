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
// 	Stack<Integer> s;
    
// 	Solution()
// 	{
// 		s = new Stack<Integer>();
// 	}

// 	// TC: O(1)
// 	void push(int x){
//         //Write Code here	
// 		s.push(x);
//     }

// 	// TC: O(1)
// 	int pop(){
//         //Write Code here
// 		return s.pop();
// 	}

// 	// TC: O(N)
//     int getMin(){
//         //Write Code here

// 		Stack<Integer> aux = new Stack<>();
// 		int minEle = Integer.MAX_VALUE;
// 		while (s.size() > 0) {
// 			int ele = s.pop();
// 			minEle = Math.min(ele, minEle);
// 			aux.push(ele);
// 		}

// 		while (aux.size() > 0) {
// 			int ele = aux.pop();
// 			s.push(ele);
// 		}

// 		return minELe;
// 	}	
// }


// class Solution
// {
// 	int minEle = Integer.MAX_VALUE;
	
// 	class Pair {
// 		int val;
// 		int minEle;

// 		Pair (int val, int minEle) {
// 			this.val = val;
// 			this.minEle = minEle;
// 		}
// 	}
	
// 	Stack<Pair> s;
    
// 	Solution() {
// 		s = new Stack<Pair>();
// 	}

// 	// TC: O(1)
// 	void push(int x) {
//         //Write Code here
// 		minEle = Math.min(x, minEle);
// 		s.push(new Pair(x, minEle));
//     }

// 	// TC: O(1)
// 	int pop() {
//         //Write Code here
// 		if (s.size() == 0) {
// 			return -1;
// 		}
// 		return s.pop().val;
// 	}

// 	// TC: O(1)
//     int getMin() {
//         //Write Code here
// 		return s.peek().minEle;
// 	}	
// }


class Solution
{
	int minEle;
	Stack<Integer> s;
    
	Solution() {
		s = new Stack<Integer>();
	}

	// TC: O(1)
	void push(int x) {
        //Write Code here
		if (s.size() == 0) {
			s.push(x);
			minEle = x;
		} else {
			if (x < minEle) {
				int val = x - minEle;
				s.push(val);
				minEle = x;
			} else {
				s.push(x);
			}
		}
    }

	// TC: O(1)
	int pop() {
        //Write Code here
		if (s.size() == 0) {
			return -1;
		} else {
			if (s.peek() < minEle) {
				int prevMin = minEle - s.peek();
				s.pop();
				int val = minEle;
				minEle = prevMin;
				return val;
			} else {
				return s.pop();
			}
		}
	}

	// TC: O(1)
    int getMin() {
        //Write Code here
		if (s.size() == 0) {
			return -1;
		}
		return minEle;
	}	
}
