import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        //write code here
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            set.add(ch);
        }

        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int inc = -1;
        int exc = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // inc
            while (inc < s.length() - 1 && map.size() < set.size()) {
                inc++;
                char ch = s.charAt(inc);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                f1 = true;
            }

            // exc
            while (exc < inc && map.size() == set.size()) {
                String currAns = s.substring(exc + 1, inc + 1);
                if (ans.length() == 0 || ans.length() > currAns.length()) {
                    ans = currAns;
                }

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

        return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}