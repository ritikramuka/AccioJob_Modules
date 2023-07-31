import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr){
        // write code here
		int n = arr.length;
		
		HashMap<String, Integer> map = new HashMap();

		int x = 0;
		int y = 0;
		int z = 0;

		String key = (x - y) + "#" + (y - z);

		map.put(key, -1);

		int maxLen = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				x++;
			} else if (arr[i] == 1) {
				y++;
			} else if (arr[i] == 2) {
				z++;
			}

			key = (x - y) + "#" + (y - z);

			if (map.containsKey(key) == true) {
				int len = i - map.get(key);
				if (len > maxLen) {
					maxLen = len;
				}
			} else {
				map.put(key, i);
			}
		}

		return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
