import java.util.*;

class Solution{
	// TC: O(log N), SC: O(1)
    public int findPeak(int A[], int n)
    {
        //Write your code here
	    int si = 0;
		int ei = A.length - 1;

		while (si <= ei) {
			int mid = (si + ei) / 2;

			if (mid == A.length - 1) {
				if (A[mid] > A[mid - 1]) {
					return mid;
				} else {
					// move left
					ei = mid - 1;
				}
			} else if (mid == 0) {
				if (A[mid] > A[mid + 1]) {
					return mid;
				} else {
					// move right
					si = mid + 1;
				}
			} else {
				if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
					return mid;
				} else if (A[mid] > A[mid - 1]) {
					si = mid + 1;
				} else {
					ei = mid - 1;
				}
			}
		}

		return -1;
    }
}

class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				Solution ob =new Solution();
				int ans = ob.findPeak(A,n);
                if(ans==0){
                    if(A[ans]>A[ans+1]){
                        System.out.println("true");
                    }
                    else{
                       System.out.println("false");    
                    }
                }
                else if(ans==n-1){
                    if(A[ans]>A[ans-1]){
                        System.out.println("true");                        
                    }
                    else{
                        System.out.println("false");                        
                    }
                }
                else{
                    if(A[ans]>A[ans+1] && A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");                        
                    }
                }
				t--;
			}
		}
	}
}