import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr[i]=x;
        }
        
        Solution ob=new Solution();
        System.out.println(ob.findspecial(arr,n));
	}
}


class Solution {
     public int findspecial(int[] arr,int n) {
        //Write code here    

        // first create freq map of each number
        HashMap <Integer, Integer> fmap = new HashMap<>();
        for (int num : arr) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        int sp = -1;
        for (int key : fmap.keySet()) {
            int freq = fmap.get(key);
            if (key == freq) {
                // special number
                if (key > sp) {
                    // if special number stored previously is smaller than curr special number, so update it
                    sp = key;
                }
            }
        }

        return sp;
    }
}