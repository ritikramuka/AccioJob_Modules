
// A Java program to print all anagrams together
import java.util.*;

public class Main {
	static String getCode(String word) {
		// get char freq in this word
		int[] fmap = new int[26];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			fmap[ch - 'a']++;
		}

		// generate code
		StringBuilder codeSb = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			if (fmap[i] > 0) {
				codeSb.append((char)(i + 'a'));
				codeSb.append(fmap[i]);
			}
		}

		return codeSb.toString();
	}
	
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String wordArr[], int size) {
        //your code here
		HashMap<String, ArrayList<String>> groups = new HashMap();

		ArrayList<String> firstOfGroup = new ArrayList<>();
		for (String word : wordArr) {
			String code = getCode(word);

			if (groups.containsKey(code) == true) {
				ArrayList<String> group = groups.get(code);
				group.add(word);
				groups.put(code, group);
			} else {
				ArrayList<String> group = new ArrayList<>();
				group.add(word);
				groups.put(code, group);
				
				firstOfGroup.add(word);
			}
		}

		Collections.sort(firstOfGroup);
		for (String word : firstOfGroup) {
			String code = getCode(word);

			ArrayList<String> group = groups.get(code);
			for (String str : group) {
				System.out.print(str + " ");
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