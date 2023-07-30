import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        //write code here
		HashSet<Character> set = new HashSet();
		for (var ch : s.toCharArray()) {
			set.add(ch);
		}

		StringBuilder sb = new StringBuilder("");
		for (var ch : set) {
			sb.append(ch);
		}

		String t = sb.toString();

		HashMap<Character, Integer> fmap2 = new HashMap();
		for (char ch : t.toCharArray()) {
			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
		}

		int mcnt = t.length();
		int dmcnt = 0;

		HashMap<Character, Integer> fmap1 = new HashMap();

		int inc = -1;
		int exc = -1;

		String ans = "";

		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;
			
			if (inc + 1 < s.length() && mcnt > dmcnt) {
				inc++;

				char ch = s.charAt(inc);
				fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

				if (fmap1.get(ch) <= fmap2.getOrDefault(ch, 0)) {
					dmcnt++;
				}

				flag1 = true;
			}

			if (exc < inc && mcnt == dmcnt) {
				String window = s.substring(exc + 1, inc + 1);
				if(ans == "" || ans.length() > window.length()) {
					ans = window;
				}
				
				exc++;

				char ch = s.charAt(exc);
				fmap1.put(ch, fmap1.get(ch) - 1);

				if (fmap2.containsKey(ch) && fmap1.get(ch) < fmap2.get(ch)) {
					dmcnt--;
				}

				if (fmap1.get(ch) == 0) {
					fmap1.remove(ch);
				}

				flag2 = true;
			}

			if (flag1 == false && flag2 == false) {
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