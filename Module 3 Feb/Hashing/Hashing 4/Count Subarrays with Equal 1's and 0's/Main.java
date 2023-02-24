import java.util.*;

class Solution {
    static int countEqualSubarray01(int arr[], int n) {
        // Write your code here
        // Map -> code, index
        // code -> difference of freq1 - freq2 # freq2 - freq0
        HashMap<String, Integer> mymap = new HashMap<>();
        mymap.put("0#0", -1);

        int maxLen = 0;

        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt0++;
            } else if (arr[i] == 1) {
                cnt1++;
            } else if (arr[i] == 2) {
                cnt2++;
            }

            String code = (cnt1 - cnt2) + "#" + (cnt2 - cnt0);
            if (mymap.containsKey(code) == true) {
                int len = i - mymap.get(code);
                maxLen = Math.max(len, maxLen);
            } else {
                mymap.put(code, i);
            }
        }

        return maxLen;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray01(arr, N));

    }
}