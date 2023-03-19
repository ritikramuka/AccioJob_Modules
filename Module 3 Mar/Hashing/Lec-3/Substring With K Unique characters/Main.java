import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){
        // all imp people
        
        int inc = -1;
        int exc = -1;

        HashMap<Character, Integer> map1 = new HashMap<>();

        String ans = "";

        while (true) {
            boolean f1 = false;
            // include people
            while (inc + 1 < s.length() && map1.size() <= k) {
                inc  = inc + 1;

                char ch = s.charAt(inc);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

				if (map1.size() == k) {
					String pans = s.substring(exc + 1, inc + 1);
	                if (ans.length() == 0 || pans.length() > ans.length()) {
	                    ans = pans;
	                }	
				}

                f1 = true;
            }

            boolean f2 = false;
            // exclude people
            while (exc < inc && map1.size() > k) {

                exc = exc + 1;

                char ch = s.charAt(exc);
                map1.put(ch, map1.get(ch) - 1);

                if (map1.get(ch) == 0) {
                    map1.remove(ch);
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
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}