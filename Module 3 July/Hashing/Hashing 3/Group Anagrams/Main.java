
// A Java program to print all anagrams together
import java.util.*;

public class Main {
	// TC: o(M) + o(26) ~ O(M)
	// SC: o(26) + o(52) ~ O(1)
	static String getCode(String word) {
		int[] fmap = new int[26];
		for (char ch : word.toCharArray()) {
			fmap[(int)(ch - 'a')] += 1;
		}

		StringBuilder code = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			char ch = (char)('a' + i);
			code.append(ch);
			code.append(fmap[i]);
		}

		return code.toString();
	}
	
    // Given a list of words in wordArr[],
	// N -> number of words given
	// M -> longest word present
	// TC: O(N * N * M * log N), SC: O(N)
    static void printAnagramsTogether(String wordArr[], int size) {
        //your code here
		
		// key: code of each grp, value: grp
		HashMap<String, ArrayList<String>> map = new HashMap();

		ArrayList<String> firstOfEachGrp = new ArrayList<>();

		for (String word : wordArr) {
			// generate the code
			String code = getCode(word);

			if (map.containsKey(code) == true) {
				ArrayList<String> grp = map.get(code);
				grp.add(word);
				map.put(code, grp);
			} else {
				ArrayList<String> grp = new ArrayList<>();
				firstOfEachGrp.add(word);
				grp.add(word);
				map.put(code, grp);
			}
		}

		Collections.sort(firstOfEachGrp);

		for (String word : firstOfEachGrp) {
			String code = getCode(word);

			ArrayList<String> grp = map.get(code);
			for (String w : grp) {
				System.out.print(w + " ");
			}
		}
		
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}