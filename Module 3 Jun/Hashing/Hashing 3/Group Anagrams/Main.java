// A Java program to print all anagrams together
import java.util.*;

public class Main {
	static String generateCode(String word) {
		// step 1: create fmap array of char
		int[] fmap = new int[26];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			fmap[ch - 'a']++;
		}

		// step 2: create code: character freq
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			if (fmap[i] > 0) {
				sb.append((char)('a' + i));
				sb.append(fmap[i]);
			}
		}

		String code = sb.toString();
		return code;
	}
	
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String wordArr[], int size) {
        //your code here

		HashMap<String, ArrayList<String>> groups = new HashMap<>();
		ArrayList<String> firstOfEachGroup = new ArrayList<>();
		
		for (String word : wordArr) {
			String code = generateCode(word);
			
			if (groups.containsKey(code) == true) {
				ArrayList<String> group = groups.get(code);
				group.add(word);
				groups.put(code, group);
			} else {
				ArrayList<String> group = new ArrayList<>();
				group.add(word);
				firstOfEachGroup.add(word);
				groups.put(code, group);
			}
		}

		Collections.sort(firstOfEachGroup);
		
		for (String word : firstOfEachGroup) {
			String code = generateCode(word);
			ArrayList<String> group = groups.get(code);
			for (String w : group) {
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