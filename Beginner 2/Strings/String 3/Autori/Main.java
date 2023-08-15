import java.io.*;
import java.util.*;

public class Main {
	static String autori(String str){
        // Your code here

		// str -> Ramuka-Gupta-Kaushik
		// Split against '-' and get each last name as a seprate string

		String[] lastNames = str.split("-");
		// lastNames = {"Ramuka", "Gupta", "Kaushik"}

		String ans = "";
		for (int i = 0; i < lastNames.length; i++) {
			String lastName = lastNames[i];

			// add first char of last name in ans
			ans += lastName.charAt(0);
		}

		// ans -> RGK
		return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String result = autori(str);
        System.out.print(result);        
        System.out.println('\n');
    }
}