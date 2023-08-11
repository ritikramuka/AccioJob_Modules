import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner scn = new Scanner(System.in);

		// regular to Caps
		// char ch = scn.next().charAt(0);

		// int dist = (int) (ch - 'a');

		// ch = (char) ('A' + dist);

		// System.out.print(ch);

		// Caps to regular
		char ch = scn.next().charAt(0);

		int dist = (int) (ch - 'A');

		ch = (char) ('a' + dist);

		System.out.print(ch);	
	}
}