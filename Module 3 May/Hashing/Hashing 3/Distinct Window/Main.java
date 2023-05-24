import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        //write code here
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			set.add(ch);
		}

		StringBuilder sb = new StringBuilder("");
		for(char ch : set) {
			sb.append(ch);
		}

		String t = sb.toString();

		// TC: O(M), SC: O(M)
		// create a fmap of String t
		HashMap<Character, Integer> fmap2 = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
		}

		// cal imp characters, desired match count
		int dmcnt = t.length();

		// people matched till now
		int mcnt = 0;

		String ans = "";

		int inc = -1;
		int exc = -1;

		// fmap for String s
		HashMap<Character, Integer> fmap1 = new HashMap<>();

		// TC: O(N)
		while (true) {

			boolean f1 = false;
			while (inc + 1 < s.length() && mcnt < dmcnt) {
				// move to inc pos
				inc = inc + 1;

				char ch = s.charAt(inc);
				fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

				if (fmap2.containsKey(ch) == true && fmap2.get(ch) >= fmap1.get(ch)) {
					mcnt++;
				}

				f1 = true;
			}

			boolean f2 = false;
			// while exc
			while (exc < inc && mcnt == dmcnt) {
				String pans = s.substring(exc + 1, inc + 1);
				if (ans.length() == 0 || ans.length() > pans.length()) {
					ans = pans;
				}

				exc = exc + 1;

				char ch = s.charAt(exc);
				fmap1.put(ch, fmap1.get(ch) - 1);

				if (fmap2.containsKey(ch) == true && fmap1.get(ch) < fmap2.get(ch)) {
					mcnt--;
				}

				if (fmap1.get(ch) == 0) {
					fmap1.remove(ch);
				}

				f2 = true;
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}

		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}