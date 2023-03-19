import java.util.*;

public class Main {

  public static String DistinctWindow(String s) {
    //write code here

    HashSet<Character> set = new HashSet();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      set.add(ch);
    }

    StringBuilder sb = new StringBuilder("");
    for (char ch : set) {
      sb.append(ch);
    }

    String t = sb.toString();

    HashMap<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }

    // all imp people
    int dmcnt = t.length();

    // number of imp people in my current window
    int mcnt = 0;

    int inc = -1;
    int exc = -1;

    HashMap<Character, Integer> map1 = new HashMap<>();

    String ans = "";

    while (true) {
      boolean f1 = false;
      // include people
      while (inc + 1 < s.length() && mcnt < dmcnt) {
        inc = inc + 1;

        char ch = s.charAt(inc);
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        if (map2.containsKey(ch) == true && map1.get(ch) <= map2.get(ch)) {
          mcnt++;
        }

        f1 = true;
      }

      boolean f2 = false;
      // exclude people
      while (exc < inc && dmcnt == mcnt) {
        String pans = s.substring(exc + 1, inc + 1);
        if (ans.length() == 0 || pans.length() < ans.length()) {
          ans = pans;
        }

        exc = exc + 1;

        char ch = s.charAt(exc);
        map1.put(ch, map1.get(ch) - 1);

        if (map2.containsKey(ch) == true && map1.get(ch) < map2.get(ch)) {
          mcnt--;
        }

        if (map1.get(ch) == 0) {
          map1.remove(ch);
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
