import java.util.*;

public class Main {

    public static String DistinctWindow(String s) {
        // write code here

        // get all unique Character
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        // get desired match count
        int dmcnt = set.size();

        // people I have matched till now
        int mcnt = 0;

        // smallest substring window
        String ans = "";

        // HashMap for each char -> freq in str1
        HashMap<Character, Integer> freq = new HashMap<>();

        int inc = -1;
        int exc = -1;

        while (true) {
            boolean f1 = false;

            // when including
            while (inc + 1 < s.length() && mcnt < dmcnt) {
                // move inc to the index which has to be included
                inc = inc + 1;

                char ch = s.charAt(inc);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                if (set.contains(ch) == true && freq.get(ch) == 1) {
                    mcnt++;
                }

                f1 = true;
            }

            boolean f2 = false;

            // when excluding
            while (exc < inc && mcnt == dmcnt) {
                // got a potential ans
                String pans = s.substring(exc + 1, inc + 1);
                if (ans.length() == 0 || ans.length() > pans.length()) {
                    ans = pans;
                }

                // got to index to exc
                exc = exc + 1;

                char ch = s.charAt(exc);
                freq.put(ch, freq.get(ch) - 1);

                if (set.contains(ch) && freq.get(ch) == 0) {
                    mcnt--;
                }

                if (freq.get(ch) == 0) {
                    freq.remove(ch);
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