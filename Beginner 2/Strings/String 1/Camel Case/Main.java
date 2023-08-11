import java.util.*;

class Main {

	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while (t-- > 0) {
	      String s = sc.next();
	      camelCase(s);
	      System.out.println(); 
	      
	    }
	}

	static void camelCase(String s) {
	    // your code here

		String[] arr = s.split("_");

		System.out.print(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			String str = arr[i];

			char firstChar = str.charAt(0);
			// capitilize it
			if (firstChar >= 'a' && firstChar <= 'z') {
				firstChar = (char) ('A' + (firstChar - 'a'));
			}

			System.out.print(firstChar);
			
			for (int j = 1; j < str.length(); j++) {
				System.out.print(str.charAt(j));
			}
		}
	}
}