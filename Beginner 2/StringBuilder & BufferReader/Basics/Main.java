import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here

		// ArrayList<Integer> arr = new ArrayList<>();
		// String str  = "";
		// for (int i = 0; i < 100000; i++) {
		// 	str += "aaaaa";
		// 	// arr.add(10);
		// }

		// System.out.println("Done");

		// String str1 = new String("Accio");
		// String str2 = new String("Accio");

		// if (str1 == str2) {
		// 	System.out.println("Same");
		// } else {
		// 	System.out.println("Not Same");
		// }

		// if (str1.equals(str2) == true) {
		// 	System.out.println("Same");
		// } else {
		// 	System.out.println("Not Same");
		// }

		// if (str1 == "Accio" && str2 == "Accio") {
		// 	System.out.println("Same");
		// } else {
		// 	System.out.println("Not Same");
		// }

		// String str1 = "Accio";
		// String str2 = "Accio";

		// if (str1 == str2) {
		// 	System.out.println("Same");
		// } else {
		// 	System.out.println("Not Same");
		// }


		// StringBuilder -----------------------

		// StringBuilder sb = new StringBuilder("Accio Jobs");
		// System.out.println(sb);

		// String to StringBuilder
		// String str = "Accio";
		// StringBuilder sb = new StringBuilder(str);
		// System.out.println(sb);

		// StringBuilder to String
		// String str2 = sb.toString();
		// System.out.println(str2);

		// StringBuilder sb = new StringBuilder("I love programming");
		
		// access character at a specific index
		// System.out.println(sb.charAt(3));

		// get length of the StringBuilder
		// System.out.println(sb.length());

		// reverse a StringBuilder
		// sb.reverse();
		// System.out.println(sb);
		// sb.reverse();

		// append things in StringBuilder
		// sb.append(" and coffee");
		// System.out.println(sb);

		// StringBuilder sb2  = new StringBuilder("");
		// for (int i = 0; i < 100000; i++) {
		// 	sb2.append("aaaaa");
		// }

		// System.out.println("Done");

		// mutable
		// sb.setCharAt(2, 'L');
		// System.out.println(sb);

		// replace (si, ei, replacedString) -> where last index is not included
		// sb.replace(19, 29, "and Football");
		// System.out.println(sb);

		// SubString
		// String substr = sb.substring(19, 22);
		// System.out.println(substr);

		// StringBuilder sb3 = new StringBuilder("Accio");
		// StringBuilder sb4 = new StringBuilder("Accio");

		// if (sb3 == sb4) {
		// 	System.out.println("yes");
		// } else {
		// 	System.out.println("No");
		// }

		// Note: .equals take strings as parameter, so convert StringBuilder to String for equating
		// if (sb3.toString().equals(sb4.toString()) == true) {
		// 	System.out.println("yes");
		// } else {
		// 	System.out.println("No");
		// }


		// Buffered Reader -----------------------------
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in);

		// String a = bf.readLine();
		// System.out.println(a);

		// int a = Integer.parseInt(bf.readLine());
		// System.out.println(a);

		// String str = bf.readLine();
		// str = str.trim();
		// System.out.println(str);
	}
}