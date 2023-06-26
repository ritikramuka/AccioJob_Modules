import java.util.*;

public class Main {
	// TC: O(N), SC: O(26) ~ O(1)
    public static int longestkSubstr(int n, int k,String s){
        //write code here
		HashMap<Character, Integer> fmap = new HashMap<>();

		int inc = -1;
		int exc = -1;

		int maxLen = -1;

		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			
			// inc
			if (inc + 1 < n && fmap.size() <= k) {
				inc++;

				char ch = s.charAt(inc);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

				if (fmap.size() == k) {
					// is this a valid window of k unique char
					int len = inc - exc;
					maxLen = Math.max(maxLen, len);
				}

				f1 = true;
			} else if (exc < inc && fmap.size() > k) {
				exc++;

				char ch = s.charAt(exc);
				fmap.put(ch, fmap.get(ch) - 1);

				if (fmap.get(ch) == 0) {
					fmap.remove(ch);
				}

				f2 = true;
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}

		return maxLen;
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