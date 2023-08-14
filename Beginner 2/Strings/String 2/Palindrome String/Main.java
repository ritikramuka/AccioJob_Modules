import java.io.*;
import java.util.*;

public class Main {

	// alphabet or numberic value
	static boolean isAlphaNumeric (char ch) {
		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
			return true;
		} else {
			return false;
		}
	}
	
	static int isPalindrome(String str)
    {
	    //write code here
		str = str.toLowerCase();
		
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			// increase i till you find a position to be alpha numeric
			while (i < str.length() && isAlphaNumeric(str.charAt(i)) == false) {
				i++;
			}

			while (j >= 0 && isAlphaNumeric(str.charAt(j)) == false) {
				j--;
			}

			if (str.charAt(i) != str.charAt(j)) {
				return 0;
			} else {
				i++;
				j--;
			}
		}

		return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);        
    }
}