import java.io.*;
import java.util.*;
public class Main {
  
	public static void solution(String str) {
		String currWord = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				// capital char
				if (currWord.equals("") == false) {
					System.out.println(currWord);
				}

				currWord = "";
				currWord += ch;
			} else {
				// smaller char
				currWord += ch;
			}
		}

		System.out.println(currWord);
	}

	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    String str = scn.next();
	    solution(str);
	}
}