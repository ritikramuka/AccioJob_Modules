import java.util.*;
  
public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A=scn.nextLine();
        String B=scn.nextLine();
        StringBuilder a= new StringBuilder(A);
        StringBuilder b= new StringBuilder(B);
        StringBuilder c=solve(a,b);
        System.out.println(c);
    }
    static StringBuilder solve(StringBuilder a, StringBuilder b)
    {
        // your code here

		StringBuilder c = new StringBuilder("");

		for (int i = 0; i < a.length(); i++) {
			char ch1 = a.charAt(i);
			char ch2 = b.charAt(i);

			if (ch1 == ch2) {
				c.append('0');
			} else {
				c.append('1');
			}
		}

		return c;
    }

    
}