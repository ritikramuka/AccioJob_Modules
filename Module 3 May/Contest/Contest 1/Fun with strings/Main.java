import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        String s=sc.nextLine();

        Solution obj=new Solution();
        System.out.println(obj.solve(s));
        sc.close();
    }
}

class Solution {

	// String helper (String s, int idx) {
	// 	if (idx == s.length()) {
	// 		return "";
	// 	}
		
	// 	String ans = helper (s, idx + 1);
		
	// 	return ans + s.charAt(idx);
	// }

	// faith: solve fn reverse the string s
    public String solve(String s)
    {
		if (s.length() == 0) {
			return "";
		}
		
        StringBuilder ans = new StringBuilder(solve(s.substring(1)));

		return ans.append(s.charAt(0)).toString();
    }
}