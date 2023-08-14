import java.util.*;

public class Main {
	static boolean isPalindrome(String str) {
		int i = 0; 
		int j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}

		return true;
	}
	
    static void palindromeSubStrs(String s) {
        //Write your code here
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String substr = s.substring(i, j);

				if (isPalindrome(substr) == true) {
					list.add(substr);
				}
			}
		}

		// sort the list: as list as Strings so sorting is done in lexo order
		Collections.sort(list);

		ArrayList<String> ans = new ArrayList<>();

		ans.add(list.get(0));

		int idx = 1;
		String str = list.get(0);

		while (idx < list.size()) {
			while (idx < list.size() && list.get(idx).equals(str)) {
				idx++;
			}

			ans.add(list.get(idx));
			str = list.get(idx);
			idx++;
		}

		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        palindromeSubStrs(s);
    }
}