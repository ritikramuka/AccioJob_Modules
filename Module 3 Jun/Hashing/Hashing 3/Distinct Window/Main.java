import java.util.*;

public class Main {

	// TC: O(N), SC: O(N) s can have all distict char 
    public static String DistinctWindow(String s){
        //write code here
		StringBuilder sb = new StringBuilder("");
		HashSet<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (set.contains(ch) == true) {
				continue;
			} else {
				sb.append(ch);
				set.add(ch);
			}
		}

		String t = sb.toString();

		HashMap<Character, Integer> fmap2 = new HashMap<>();
		for (char ch : t.toCharArray()) {
			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
		}

		int inc = -1;
		int exc = -1;

		int dmcnt = t.length();
		int mcnt = 0;

		HashMap<Character, Integer> fmap1 = new HashMap<>();
		String ans = "";
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			
			// inc
			if (inc + 1 < s.length() && dmcnt > mcnt) {
				inc += 1;
				char ch = s.charAt(inc);

				if (fmap2.containsKey(ch) == true) {
					if (fmap1.getOrDefault(ch, 0) < fmap2.get(ch)) {
						// this char is imp to me
						mcnt++;
					}
				}

				fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

				f1 = true;
			} 
			// exc
			else if (exc < inc && dmcnt == mcnt) {
				String pans = s.substring(exc + 1, inc + 1);
				if (ans == "" || ans.length() > pans.length()) {
					ans = pans;
				}

				exc++;
				char ch = s.charAt(exc);

				if (fmap2.containsKey(ch) == true) {
					if (fmap1.get(ch) <= fmap2.get(ch)) {
						mcnt--;
					}
				}

				fmap1.put(ch, fmap1.get(ch) - 1);

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