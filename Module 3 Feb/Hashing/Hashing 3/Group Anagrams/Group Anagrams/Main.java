import java.util.*;

class Solution {
    // TC: O(N * M), SC: O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        // SC: O(N)
        HashMap<String, ArrayList<String>> map = new HashMap();

        // TC: O(N), N -> Length of strs
        for (String word : strs) {
            // create freq map for this word

            // TC: O(M), M -> Length of word
            // SC: O(26), size of freqChar
            int[] freqChar = new int[26];
            for (char ch : word.toCharArray()) {
                freqChar[ch - 'a'] += 1;
            }

            // generate a code from this

            // TC: O(26) ~ O(1)
            // SC: O(52) ~ O(1)
            StringBuilder code = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                if (freqChar[i] > 0) {
                    code.append((char) (i + 'a'));
                    code.append(freqChar[i]);
                }
            }

            // check is code seen for the fisrt time

            // TC: O(1)
            if (map.containsKey(code.toString()) == false) {
                ArrayList<String> group = new ArrayList<>();
                group.add(word);
                map.put(code.toString(), group);
            } else {
                ArrayList<String> group = map.get(code.toString());
                group.add(word);
                map.put(code.toString(), group);
            }
        }

        // TC: O(N), N -> Length of strs
        List<List<String>> ans = new ArrayList<>();
        for (String code : map.keySet()) {
            ans.add(map.get(code));
        }

        return ans;
    }
}