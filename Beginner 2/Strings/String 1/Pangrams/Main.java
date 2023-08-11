import java.util.*;
import java.io.*;

public class Main {
	public  static void isPangram(String s) {
	    // Your code here

		boolean[] vis = new boolean[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				int pos = ch - 'A';
				vis[pos] = true;
			} else if (ch >= 'a' && ch <= 'z') {
				int pos = ch - 'a';
				vis[pos] = true;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (vis[i] == false) {
				System.out.println("not pangram");
				return;
			}
		}

		System.out.println("pangram");
    }
    
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);
    }
}