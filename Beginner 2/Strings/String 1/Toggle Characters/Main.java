import java.util.*;

public class Main {

	public static void main(String[] args) throws Throwable {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    sc.nextLine();
	    String str = sc.nextLine();
	    toggleCase(n, str);
	}

	static void toggleCase(int n, String str) {
		// your code here
		// String ans = "";

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);

			// Lower case char
			if (ch >= 'a' && ch <= 'z') {
				// convert me to a upper case char
				char newCh = (char) ('A' + ch - 'a');
				// ans += newCh;
				System.out.print(newCh);
			}
			// Upper case char
			else if (ch >= 'A' && ch <= 'Z') {
				// convert me to a lower case char
				char newCh = (char) ('a' + ch - 'A');
				// ans += newCh;
				System.out.print(newCh);
			}
			// Not a Alpha
			else {
				// ans += ch;
				System.out.print(ch);
			}
		}

		// System.out.println(ans);
	}
}