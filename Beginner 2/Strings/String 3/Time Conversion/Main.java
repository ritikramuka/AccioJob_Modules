import java.util.*;

public class Main {
    static void timeConversion(String s) {
        //Write your code here

		//        0 1 2 3 4 5 6 7 8 9
		// str -> h h : m m : s s P M

		char h1 = s.charAt(0);
		char h2 = s.charAt(1);
		int hh = (int)(h1 - '0') * 10 + (int)(h2 - '0');

		if (s.charAt(8) == 'P') {
			// PM 
			if (hh == 12) {
				for (int i = 0; i <= 7; i++) {
					System.out.print(s.charAt(i));
				}
			} else {
				hh = hh + 12;
				System.out.print(hh);
				for (int i = 2; i <= 7; i++) {
					System.out.print(s.charAt(i));
				}	
			}
		} else {
			// AM based
			if (hh == 12) {
				System.out.print("00");
				for (int i = 2; i <= 7; i++) {
					System.out.print(s.charAt(i));
				}
			} else {
				for (int i = 0; i <= 7; i++) {
					System.out.print(s.charAt(i));
				}	
			}
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        timeConversion(str);
        sc.close();
    }
}