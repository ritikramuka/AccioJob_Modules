import java.util.*;

public class Main {
    
    static void ptice(int n, String key) {
        // Write your code here and print output in this function

		int Adrain = 0;

		// ABC
		for (int i = 0; i < n; i++) {
			switch(i % 3) {
				case 0: 
					if (key.charAt(i) == 'A') {
						Adrain++;
					}
					break;
				case 1:
					if (key.charAt(i) == 'B') {
						Adrain++;
					}
					break;
				case 2: 
					if (key.charAt(i) == 'C') {
						Adrain++;
					}
					break;
			}
		}

		int Bruno = 0;

		// BABC
		for (int i = 0; i < n; i++) {
			switch(i % 4) {
				case 0: 
					if (key.charAt(i) == 'B') {
						Bruno++;
					}
					break;
				case 1: 
					if (key.charAt(i) == 'A') {
						Bruno++;
					}
					break;
				case 2: 
					if (key.charAt(i) == 'B') {
						Bruno++;
					}
					break;
				case 3: 
					if (key.charAt(i) == 'C') {
						Bruno++;
					}
					break;
			}
		}
		

		int Goran = 0;

		// CCAABB
		for (int i = 0; i < n; i++) {
			switch(i % 6) {
				case 0: 
					if (key.charAt(i) == 'C') {
						Goran++;
					}
					break;
				case 1: 
					if (key.charAt(i) == 'C') {
						Goran++;
					}
					break;
				case 2: 
					if (key.charAt(i) == 'A') {
						Goran++;
					}
					break;
				case 3: 
					if (key.charAt(i) == 'A') {
						Goran++;
					}
					break;
				case 4: 
					if (key.charAt(i) == 'B') {
						Goran++;
					}
					break;
				case 5:
					if (key.charAt(i) == 'B') {
						Goran++;
					}
					break;
			}
		}

		int maxScore = Math.max(Adrain, Math.max(Goran, Bruno));

		System.out.println(maxScore);
		if (maxScore == Adrain) {
			System.out.println("Adrian");
		}
		if (maxScore == Bruno) {
			System.out.println("Bruno");
		}
		if (maxScore == Goran) {
			System.out.println("Goran");
		}
	}  
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String str = sc.next();
        ptice(n, str);
        sc.close();
    }
}