import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k, String s) {
        // write code here
        String ans = "";

        HashMap<Character, Integer> freq = new HashMap<>();

        int inc = -1;
        int exc = -1;

        while (true) {
            boolean f1 = false;

            // when including
            while (inc + 1 < s.length() && freq.size() <= k) {
                // move inc to the index which has to be included
                inc = inc + 1;

                char ch = s.charAt(inc);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                if (freq.size() == k) {
                    String pans = s.substring(exc + 1, inc + 1);
                    if (ans.length() == 0 || ans.length() < pans.length()) {
                        ans = pans;
                    }
                }

                f1 = true;
            }

            boolean f2 = false;

            // when excluding
            while (exc < inc && freq.size() > k) {
                // got to index to exc
                exc = exc + 1;

                char ch = s.charAt(exc);
                freq.put(ch, freq.get(ch) - 1);

                if (freq.get(ch) == 0) {
                    freq.remove(ch);
                }

                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans.length() == 0 ? -1 : ans.length();
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n, k, s);
        System.out.println(ans);
    }
}