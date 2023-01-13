import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k, String s) {
        // write code here
        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int inc = -1;
        int exc = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // inc
            while (inc < s.length() - 1 && map.size() <= k) {
                inc++;
                char ch = s.charAt(inc);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() == k) {
                    String currAns = s.substring(exc + 1, inc + 1);
                    if (ans.length() == 0 || ans.length() < currAns.length()) {
                        ans = currAns;
                    }
                }

                f1 = true;
            }

            // exc
            while (exc < inc && map.size() > k) {
                exc++;
                char ch = s.charAt(exc);
                map.put(ch, map.getOrDefault(ch, 0) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
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